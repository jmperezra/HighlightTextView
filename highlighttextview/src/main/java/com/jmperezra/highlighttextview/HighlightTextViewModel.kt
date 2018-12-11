package com.jmperezra.highlighttextview


import com.jmperezra.commons.OnClickEvent

class HighlightTextViewModel(val textToHighlight: String,
                             val styleHighlightText: Int = R.style.Bold,
                             val clickHighlightText: OnClickEvent?,
                             val startPositionOccurence: Int = 0,
                             val limit: HighlightTextLimit = HighlightTextLimit.All(),
                             val ignoreCase: Boolean = false)