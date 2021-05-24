package com.theappbusiness.analytics.client.adobe

import android.content.Context
import com.adobe.mobile.Analytics
import com.adobe.mobile.Config
import com.theappbusiness.analyitcs.clients.AnalyticsClient

class AdobeAnalyticsClient(context: Context) : AnalyticsClient {

    init {
        Config.setContext(context)
    }

    override fun send(event: String, eventMap: Map<String, Any>) {
        Analytics.trackAction(event, eventMap)
    }

}