package com.theappbusiness.sample.ui.main

import androidx.lifecycle.ViewModel
import com.theappbusiness.analyitcs.Analytics
import com.theappbusiness.sample.data.analytics.AnalyticsConstants.Event
import com.theappbusiness.sample.data.analytics.AnalyticsConstants.Fields

class MainViewModel constructor(
    private val analytics: Analytics
) : ViewModel() {

    init {
        analytics.send(Event.MAIN_SCREEN)
    }

    fun logEventA() {
        analytics.send(Event.MAIN_BUTTON_CLICK) {
            Fields.BUTTON_HEIGHT to 50
            Fields.BUTTON_ELEVATION to 4
        }
    }

    fun logEventB() {
        analytics.send(Event.MAIN_BUTTON_2_CLICK) {
            Fields.BACKGROUND_COLOR to "white"
        }
    }
}
