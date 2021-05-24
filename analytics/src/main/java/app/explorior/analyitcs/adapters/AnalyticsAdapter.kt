package app.explorior.analyitcs.adapters

interface AnalyticsAdapter<T : Any> {

    fun map(data: T): Map<String, Any>

}