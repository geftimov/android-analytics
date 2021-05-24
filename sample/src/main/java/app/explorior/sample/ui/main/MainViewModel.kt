package app.explorior.sample.ui.main

import androidx.lifecycle.ViewModel
import app.explorior.analyitcs.Analytics
import app.explorior.sample.data.analytics.AnalyticsConstants.Event
import app.explorior.sample.data.analytics.AnalyticsConstants.Fields

class MainViewModel constructor(
    private val analytics: Analytics
) : ViewModel() {

    init {
        analytics.collect {
            "shhhhh" to false
        }
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
