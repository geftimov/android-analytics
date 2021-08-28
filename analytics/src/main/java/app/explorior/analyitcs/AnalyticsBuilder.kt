package app.explorior.analyitcs

import app.explorior.analyitcs.clients.AnalyticsClient
import app.explorior.analyitcs.collector.AnalyticsCollector
import app.explorior.analyitcs.collector.memory.MemoryAnalyticsCollector

class AnalyticsBuilder {

    private var clients = arrayListOf<AnalyticsClient>()
    private var collector: AnalyticsCollector = MemoryAnalyticsCollector()

    fun clients(vararg clients: AnalyticsClient): AnalyticsBuilder {
        this.clients.addAll(clients)
        return this
    }

    fun collector(collector: AnalyticsCollector): AnalyticsBuilder {
        this.collector = collector
        return this
    }


    fun build() = Analytics(clients, collector)

}