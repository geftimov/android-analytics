package app.explorior.analyitcs.collector.memory

import app.explorior.analyitcs.collector.AnalyticsCollector

class MemoryAnalyticsCollector : AnalyticsCollector {

    private val allEventsMap = hashMapOf<String, Any>()
    private val eventMap = hashMapOf<String, MutableMap<String, Any>>()

    override fun collect(key: String, value: Any) {
        if (checkValue(value)) return
        allEventsMap[key] = value
    }

    override fun collect(event: String, key: String, value: Any) {
        if (checkValue(value)) return
        val map = getMap(event)
        map[key] = value
        eventMap[event] = map
    }

    override fun getMap(event: String): MutableMap<String, Any> {
        return hashMapOf<String, Any>().apply {
            putAll(eventMap[event] ?: hashMapOf())
            putAll(allEventsMap)
        }
    }

    private fun checkValue(value: Any) = value is String && value.isBlank()

}