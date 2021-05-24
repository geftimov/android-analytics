package com.theappbusiness.sample

import android.app.Application
import com.theappbusiness.analyitcs.Analytics
import com.theappbusiness.analyitcs.AnalyticsBuilder
import com.theappbusiness.analyitcs.clients.LogAnalyticsClient
import com.theappbusiness.analytics.client.firebase.FirebaseAnalyticsClient
import com.theappbusiness.sample.data.analytics.AnalyticsLoggedInUserAdapter

class MyApp : Application() {

    lateinit var analytics: Analytics

    override fun onCreate() {
        super.onCreate()
        analytics = AnalyticsBuilder()
            .clients(LogAnalyticsClient(), FirebaseAnalyticsClient(this))
            .adapters(AnalyticsLoggedInUserAdapter())
            .build()
    }

}