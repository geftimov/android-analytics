package app.explorior.analyitcs.collector.memory

import app.explorior.analyitcs.collector.AnalyticsCollector

class MemoryAnalyticsCollector : AnalyticsCollector {

    private val allEventsMap = mutableMapOf<String, Any>()
    private val eventMap = mutableMapOf<String, MutableMap<String, Any>>()

    override fun collect(key: String, value: Any) {
        allEventsMap[key] = value
    }

    override fun collect(event: String, key: String, value: Any) {
        val map = getMap(event)
        map.put(key, value)
        eventMap[event] = map
    }

    override fun getMap(event: String): MutableMap<String, Any> {
        return mutableMapOf<String, Any>().apply {
            putAll(allEventsMap)
            putAll(eventMap[event] ?: mutableMapOf())
        }
    }

}