package com.theappbusiness.sample.data.analytics

import com.theappbusiness.analyitcs.adapters.AnalyticsAdapter
import com.theappbusiness.sample.data.analytics.AnalyticsConstants.Fields
import com.theappbusiness.sample.data.model.LoggedInUser

class AnalyticsLoggedInUserAdapter : AnalyticsAdapter<LoggedInUser> {

    override fun map(data: LoggedInUser) = mapOf<String, Any>(
        Fields.USER_ID to data.userId,
        Fields.DISPLAY_NAME to data.displayName
    )

}