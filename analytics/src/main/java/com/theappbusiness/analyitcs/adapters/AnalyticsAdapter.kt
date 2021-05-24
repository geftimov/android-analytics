package com.theappbusiness.analyitcs.adapters

interface AnalyticsAdapter<T : Any> {

    fun map(data: T): Map<String, Any>

}