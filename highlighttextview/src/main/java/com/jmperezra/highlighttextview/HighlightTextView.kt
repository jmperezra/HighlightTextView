package com.jmperezra.highlighttextview

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet


class HighlightTextView @JvmOverloads constructor(
		context: Context,
		private val attrs: AttributeSet? = null,
		private val defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

	private val highlightTextHandler = HighlightTextHandler(this)

	init {
		parseStyleAttrs()
	}

	private fun parseStyleAttrs() {
		val viewModel = highlightTextHandler.buildViewModelFromAttrs(attrs, defStyleAttr)
		viewModel?.let {
			renderHighlightViewModels(mutableListOf(it))
		}
	}

	fun renderHighlightViewModels(highlightTextViewModels: List<HighlightTextViewModel>) {
		resetHighlightText()
		text = highlightTextHandler.buildSpannable(highlightTextViewModels)
	}

	fun resetHighlightText() {
		highlightTextHandler.resetHighlightText()
	}
}