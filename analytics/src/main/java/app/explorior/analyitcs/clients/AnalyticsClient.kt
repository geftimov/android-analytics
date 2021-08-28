package app.explorior.analyitcs.clients

interface AnalyticsClient {

    fun userProperty(property: String, data: Any)

    fun send(event: String, eventMap: Map<String, Any>)

}