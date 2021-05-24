package app.explorior.analyitcs

import app.explorior.analyitcs.adapters.AnalyticsAdapter
import app.explorior.analyitcs.clients.AnalyticsClient
import app.explorior.analyitcs.collector.AnalyticsCollector

class Analytics(
    private val clients: List<AnalyticsClient>,
    private val collector: AnalyticsCollector,
    private val adapters: List<AnalyticsAdapter<*>>
) {

    fun collect(name: String? = null, builder: EventBuilder.() -> Unit = {}) {
        builder(EventBuilder(name, collector))
    }

    fun send(name: String, builder: EventBuilder.() -> Unit = {}) {
        builder(EventBuilder(name, collector))
        clients.forEach { it.send(name, collector.getMap(name)) }
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

//    fun <T : Any> collectData(data: T) {
//        val adapter = getAdapter(data)
//        val map = adapter.map(data = data)
//        collect(map)
//    }

//    fun <T : Any> collectData(event: String, data: T) {
//        val adapter = getAdapter(data)
//        val map = adapter.map(data = data)
//        collect(event, map)
//    }

//    fun setUserProperty(property: String, data: String) {
//        clients.forEach { it.setUserProperty(property, data) }
//    }

//    private fun <T : Any> getAdapter(data: T): AnalyticsAdapter<T> {
//        return adapters.filter {
//            val clazz = (it.javaClass.genericInterfaces.first() as ParameterizedType)
//                .actualTypeArguments
//                .first()
//            return@filter data.javaClass == clazz
//        }.map { it as AnalyticsAdapter<T> }
//            .firstOrNull()
//            ?: throw IllegalArgumentException("AnalyticsAdapter for ${data.javaClass} is missing.")
//    }

}