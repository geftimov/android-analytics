package app.explorior.analytics.client.adobe

import android.content.Context
import app.explorior.analyitcs.clients.AnalyticsClient
import com.adobe.mobile.Analytics
import com.adobe.mobile.Config

class AdobeAnalyticsClient(context: Context) : AnalyticsClient {

    init {
        Config.setContext(context)
    }

    override fun send(event: String, eventMap: Map<String, Any>) {
        Analytics.trackAction(event, eventMap)
    }

}