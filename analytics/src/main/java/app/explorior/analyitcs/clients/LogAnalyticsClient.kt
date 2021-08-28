package app.explorior.analyitcs.clients

import android.util.Log

class LogAnalyticsClient(
    private val tag: String? = "Analytics"
) : AnalyticsClient {

    override fun userProperty(property: String, data: Any) {
        log("------------------------------------------------------------")
        log("|  User Property : $property = $data")
        log("------------------------------------------------------------")
    }

    override fun send(event: String, eventMap: Map<String, Any>) {
        log("------------------------------------------------------------")
        log("|  Event : $event")
        log("------------------------------------------------------------")
        if (eventMap.isEmpty()) return
        eventMap.entries.forEach { log("|  ${it.key} : ${it.value}") }
        log("------------------------------------------------------------")
    }

    private fun log(text: String) {
        Log.i(tag, text)
    }

}