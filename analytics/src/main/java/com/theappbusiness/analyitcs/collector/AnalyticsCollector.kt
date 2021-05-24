package com.theappbusiness.analyitcs.collector

interface AnalyticsCollector {

    fun collect(key: String, value: Any)

    fun collect(event: String, key: String, value: Any)

    fun getMap(event: String): Map<String, Any>

}