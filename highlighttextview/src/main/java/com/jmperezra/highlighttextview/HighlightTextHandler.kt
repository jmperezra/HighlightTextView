package com.jmperezra.highlighttextview

import android.support.v4.content.res.TypedArrayUtils.getBoolean
import android.support.v4.content.res.TypedArrayUtils.getResourceId
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.CharacterStyle
import android.text.style.ClickableSpan
import android.text.style.TextAppearanceSpan
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.TextView
import com.jmperezra.commons.None


class HighlightTextHandler(private val textView: TextView) {

	private val text: CharSequence = textView.text
	private lateinit var highlightTextViewModels: List<HighlightTextViewModel>
	private lateinit var currentHighlightTextViewModel: HighlightTextViewModel
	private lateinit var spannableString: SpannableString

	init {
		setup()
	}

	private fun setup() {
		textView.movementMethod = LinkMovementMethod.getInstance()
	}

	fun buildSpannable(highlightTextViewModels: List<HighlightTextViewModel>): SpannableString {
		this.highlightTextViewModels = highlightTextViewModels
		renderModelToSpan()
		return spannableString
	}

	/**
	 * Delete whole spannable text
	 */
	fun resetHighlightText() {
		if (text is SpannableString) {
			val spans = text.getSpans(0, text.length, Object::class.java)
			spans.forEach {
				if (it is CharacterStyle) {
					text.removeSpan(it)
				}
			}
		}
	}

	private fun renderModelToSpan() {
		if (this::highlightTextViewModels.isInitialized) {
			spannableString = SpannableString(text)
			highlightTextViewModels.forEach {
				currentHighlightTextViewModel = it
				addSpan()
			}
		}
	}

	private fun addSpan() {
		val startIndex = findStartPositionFromOccurence()
		setFormatToHighlightText(startIndex)
	}

	/**
	 * Return the position of a given occurence
	 */
	private fun findStartPositionFromOccurence(): Int {
		var startIndex = 0
		var cont = 0
		while (cont < currentHighlightTextViewModel.startPositionOccurence) {
			startIndex = text.indexOf(currentHighlightTextViewModel.textToHighlight,
			                          startIndex,
			                          currentHighlightTextViewModel.ignoreCase)
			startIndex += 1
			cont += 1
		}
		return startIndex
	}

	/**
	 * Transform the occurrence chosen by the client into a number
	 */
	private fun getOccurences(): Int = when (currentHighlightTextViewModel.limit.startIndex) {
		HighlightTextLimit.All().startIndex -> {
			countOccurences()
		}
		else                                -> {
			currentHighlightTextViewModel.limit.startIndex
		}
	}

	/**
	 * Return total repetititions of substring in text
	 */
	private fun countOccurences(): Int {
		return if (currentHighlightTextViewModel.ignoreCase) {
			text.toString().toLowerCase()
					.split(currentHighlightTextViewModel.textToHighlight.toLowerCase(),
					       ignoreCase = currentHighlightTextViewModel.ignoreCase)
					.count()
		} else {
			text.split(currentHighlightTextViewModel.textToHighlight,
			           ignoreCase = currentHighlightTextViewModel.ignoreCase).count()
		}

	}

	/**
	 * Set the selected highlight forma
	 */
	private fun setFormatToHighlightText(startIndex: Int) {
		var currentIndex = startIndex
		for (i in 1..getOccurences()) {
			currentIndex = text.indexOf(currentHighlightTextViewModel.textToHighlight,
			                            currentIndex,
			                            currentHighlightTextViewModel.ignoreCase)
			if (currentIndex >= 0) {
				try {
					setStyleSpan(currentIndex)
					setEventSpan(currentIndex)
					currentIndex += 1
				} catch (ex: Exception) {
					Log.e("@dev", "Exception:", ex)
				}
			} else {
				return
			}
		}
	}

	/**
	 * Set the selected style to highlight text
	 */
	private fun setStyleSpan(currentIndex: Int) {
		spannableString.setSpan(TextAppearanceSpan(textView.context,
		                                           currentHighlightTextViewModel.styleHighlightText),
		                        currentIndex,
		                        currentIndex + (currentHighlightTextViewModel.textToHighlight.length),
		                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
	}

	/**
	 * Set the selected event to highlight text
	 */
	private fun setEventSpan(currentIndex: Int) {
		currentHighlightTextViewModel.clickHighlightText.map {
			spannableString.setSpan(object : ClickableSpan() {
				override fun onClick(textView: View) {
					it.f(textView)
				}

				override fun updateDrawState(ds: TextPaint?) {
					ds?.isUnderlineText = false
				}
			}, currentIndex,
			                        currentIndex + (currentHighlightTextViewModel.textToHighlight.length),
			                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
		}
	}

	fun buildViewModelFromAttrs(attrs: AttributeSet? = null, defStyleAttr: Int = 0): HighlightTextViewModel? {
		var viewModel: HighlightTextViewModel? = null
		textView.context.theme.obtainStyledAttributes(
				attrs,
				R.styleable.HighlightTextView,
				defStyleAttr,
				0).apply {
			try {
				val highlighttext: String? =
						getString(R.styleable.HighlightTextView_htv_highlight_text)
				highlighttext?.let {
					viewModel = HighlightTextViewModel(
							it,
							getResourceId(R.styleable.HighlightTextView_htv_highlight_style,
							              R.style.Bold),
							None,
							getInt(R.styleable.HighlightTextView_htv_start_position_occurrence,
							       0),
							HighlightTextLimit.NumLimit(getInt(R.styleable.HighlightTextView_htv_limit,
							                                   HighlightTextLimit.Default().startIndex)),
							getBoolean(R.styleable.HighlightTextView_htv_ignorecase, false)
					)
				}
			} catch (ex: Exception) {
				Log.e(HighlightTextView::class.java.name, ex.message, ex)
			} finally {
				recycle()
			}
		}
		return viewModel
	}
}