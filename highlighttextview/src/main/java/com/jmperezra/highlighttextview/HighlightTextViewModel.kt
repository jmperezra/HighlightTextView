package com.jmperezra.highlighttextview


import com.jmperezra.commons.Eval
import com.jmperezra.commons.Option

class HighlightTextViewModel(val textToHighlight: String,
                             val styleHighlightText: Int = R.style.Bold,
                             val clickHighlightText: Option<Eval>,
                             val startPositionOccurence: Int = 0,
                             val limit: HighlightTextLimit = HighlightTextLimit.All(),
                             val ignoreCase: Boolean = false)