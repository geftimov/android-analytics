package app.explorior.analyitcs.clients

interface AnalyticsClient {

    fun userProperty(map: Map<String, Any>)

    fun send(event: String, eventMap: Map<String, Any>)

}