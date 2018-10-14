package com.jmperezra.highlighttextview

sealed class HighlightTextLimit(val startIndex: Int) {
	class First : HighlightTextLimit(1)
	class All : HighlightTextLimit(-1)
	class Default : HighlightTextLimit(-1)
	data class NumLimit(val number: Int) : HighlightTextLimit(number)
}