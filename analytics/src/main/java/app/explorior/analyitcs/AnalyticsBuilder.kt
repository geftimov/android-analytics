package app.explorior.analyitcs

import app.explorior.analyitcs.adapters.AnalyticsAdapter
import app.explorior.analyitcs.clients.AnalyticsClient
import app.explorior.analyitcs.collector.AnalyticsCollector
import app.explorior.analyitcs.collector.memory.MemoryAnalyticsCollector

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