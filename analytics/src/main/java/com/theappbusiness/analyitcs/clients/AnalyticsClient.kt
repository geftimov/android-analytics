package com.theappbusiness.analyitcs.clients

interface AnalyticsClient {

    fun send(event: String, eventMap: Map<String, Any>)

}