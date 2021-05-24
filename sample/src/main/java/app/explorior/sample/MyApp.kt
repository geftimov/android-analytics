package app.explorior.sample

import android.app.Application
import app.explorior.analyitcs.Analytics
import app.explorior.analyitcs.AnalyticsBuilder
import app.explorior.analyitcs.clients.LogAnalyticsClient
import app.explorior.sample.data.analytics.AnalyticsLoggedInUserAdapter

class MyApp : Application() {

    lateinit var analytics: Analytics

    override fun onCreate() {
        super.onCreate()
        analytics = AnalyticsBuilder()
            .clients(LogAnalyticsClient(),
                app.explorior.analytics.client.firebase.FirebaseAnalyticsClient(this)
            )
            .adapters(AnalyticsLoggedInUserAdapter())
            .build()
    }

}