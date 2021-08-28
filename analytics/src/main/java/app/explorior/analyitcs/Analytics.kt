package app.explorior.analyitcs

import app.explorior.analyitcs.clients.AnalyticsClient
import app.explorior.analyitcs.collector.AnalyticsCollector

class Analytics(
    private val clients: List<AnalyticsClient>,
    private val collector: AnalyticsCollector
) {

    fun userProperty(init: UserPropertyBuilder.() -> Unit = {}) {
        val builder = UserPropertyBuilder()
        init(builder)
        clients.forEach { it.userProperty(builder.map) }
    }

    fun collect(name: String, builder: EventBuilder.() -> Unit = {}) {
        builder(EventBuilder(name, collector))
    }

    fun send(name: String, builder: EventBuilder.() -> Unit = {}) {
        builder(EventBuilder(name, collector))
        clients.forEach { it.send(name, collector.getMap(name)) }
    }

    class UserPropertyBuilder {

        val map = hashMapOf<String, Any>()

        infix fun String.to(value: Any) {
            map[this] = value
        }

    }

    class EventBuilder(
        val name: String? = null,
        private val collector: AnalyticsCollector
    ) {

        infix fun String.to(value: Any) {
            if (name == null) {
                collector.collect(this, value)
            } else {
                collector.collect(name, this, value)
            }
        }

    }

}