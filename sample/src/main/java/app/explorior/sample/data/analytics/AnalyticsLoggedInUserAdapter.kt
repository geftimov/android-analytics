package app.explorior.sample.data.analytics

import app.explorior.analyitcs.adapters.AnalyticsAdapter
import app.explorior.sample.data.analytics.AnalyticsConstants.Fields
import app.explorior.sample.data.model.LoggedInUser

class AnalyticsLoggedInUserAdapter : AnalyticsAdapter<LoggedInUser> {

    override fun map(data: LoggedInUser) = mapOf<String, Any>(
        Fields.USER_ID to data.userId,
        Fields.DISPLAY_NAME to data.displayName
    )

}