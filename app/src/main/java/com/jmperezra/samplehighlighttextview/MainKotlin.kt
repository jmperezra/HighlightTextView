package com.jmperezra.samplehighlighttextview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.jmperezra.commons.Eval
import com.jmperezra.commons.None
import com.jmperezra.commons.some
import com.jmperezra.highlighttextview.HighlightTextLimit
import com.jmperezra.highlighttextview.HighlightTextViewModel
import kotlinx.android.synthetic.main.view_example_08.*
import kotlinx.android.synthetic.main.view_example_09.*
import kotlinx.android.synthetic.main.view_example_10.*
import kotlinx.android.synthetic.main.view_example_11.*

class MainKotlin : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		initExamples()
	}

	private fun initExamples() {
		initExample8()
		initExample9()
		initExample10()
		initExample11()
	}

	private fun initExample8() {
		htvExample8.renderHighlightViewModels(mutableListOf(buildMinConfigViewModel()))
	}

	private fun initExample9() {
		htvExample9.renderHighlightViewModels(mutableListOf(buildFullConfigViewModel()))
	}

	private fun initExample10() {
		htvExample10.renderHighlightViewModels(mutableListOf(buildWithEventConfigViewModel()))
	}

	private fun initExample11() {
		htvExample11.renderHighlightViewModels(mutableListOf(buildRedViewModel(),
		                                                     buildGreenViewModel(),
		                                                     buildOrangeViewModel()))
	}

	private fun buildMinConfigViewModel() =
			HighlightTextViewModel(getText(R.string.example8_text_to_highlight).toString(),
			                       clickHighlightText = None)

	private fun buildFullConfigViewModel() =
			HighlightTextViewModel(getText(R.string.example9_text_to_highlight).toString(),
			                       R.style.Link,
			                       None,
			                       0,
			                       HighlightTextLimit.All(),
			                       true)

	private fun buildWithEventConfigViewModel() =
			HighlightTextViewModel(getText(R.string.example10_text_to_highlight).toString(),
			                       R.style.Link,
			                       Eval { showHelloWorldToast() }.some(),
			                       0,
			                       HighlightTextLimit.NumLimit(1),
			                       true)

	private fun buildRedViewModel() =
			HighlightTextViewModel(getText(R.string.example11_text_to_highlight_1).toString(),
			                       R.style.Red,
			                       Eval { showRedToast() }.some(),
			                       0,
			                       HighlightTextLimit.All(),
			                       true)

	private fun buildGreenViewModel() =
			HighlightTextViewModel(getText(R.string.example11_text_to_highlight_2).toString(),
			                       R.style.Green,
			                       None,
			                       0,
			                       HighlightTextLimit.NumLimit(1),
			                       true)

	private fun buildOrangeViewModel() =
			HighlightTextViewModel(getText(R.string.example11_text_to_highlight_3).toString(),
			                       R.style.Orange,
			                       Eval { showOrangeToast() }.some(),
			                       0,
			                       HighlightTextLimit.First(),
			                       true)

	private fun showHelloWorldToast() {
		Toast.makeText(this, R.string.hello_world, Toast.LENGTH_SHORT).show()
	}

	private fun showOrangeToast() {
		Toast.makeText(this, R.string.hello_orange_world, Toast.LENGTH_SHORT).show()
	}

	private fun showRedToast() {
		Toast.makeText(this, R.string.hello_red_world, Toast.LENGTH_SHORT).show()
	}
}
