package app.explorior.analyitcs.clients

interface AnalyticsClient {

    fun send(event: String, eventMap: Map<String, Any>)

}