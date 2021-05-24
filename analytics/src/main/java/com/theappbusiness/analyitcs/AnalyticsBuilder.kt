package com.theappbusiness.analyitcs

import com.theappbusiness.analyitcs.adapters.AnalyticsAdapter
import com.theappbusiness.analyitcs.clients.AnalyticsClient
import com.theappbusiness.analyitcs.collector.AnalyticsCollector
import com.theappbusiness.analyitcs.collector.memory.MemoryAnalyticsCollector

class AnalyticsBuilder {

    private var clients = arrayListOf<AnalyticsClient>()
    private var collector: AnalyticsCollector = MemoryAnalyticsCollector()
    private var adapters = arrayListOf<AnalyticsAdapter<*>>()

    fun clients(vararg clients: AnalyticsClient): AnalyticsBuilder {
        this.clients.addAll(clients)
        return this
    }

    fun collector(collector: AnalyticsCollector): AnalyticsBuilder {
        this.collector = collector
        return this
    }

    fun adapters(vararg adapters: AnalyticsAdapter<*>): AnalyticsBuilder {
        this.adapters.addAll(adapters)
        return this
    }

    fun build() = Analytics(clients, collector, adapters)

}