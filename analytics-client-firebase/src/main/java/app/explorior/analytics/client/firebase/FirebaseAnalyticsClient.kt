package app.explorior.analytics.client.firebase

import android.content.Context
import android.os.Bundle
import android.os.IBinder
import android.os.Parcelable
import app.explorior.analyitcs.clients.AnalyticsClient
import com.google.firebase.analytics.FirebaseAnalytics
import java.io.Serializable

open class FirebaseAnalyticsClient(context: Context) : AnalyticsClient {

    val firebaseAnalytics = FirebaseAnalytics.getInstance(context)

    override fun userProperty(map: Map<String, Any>) {
        map.forEach { entry ->
            firebaseAnalytics.setUserProperty(entry.key, entry.value.toString())
        }
    }

    override fun send(event: String, eventMap: Map<String, Any>) {
        firebaseAnalytics.logEvent(event, eventMap.toBundle())
    }

    fun <V> Map<String, V>.toBundle(bundle: Bundle = Bundle()): Bundle = bundle.apply {
        forEach {
            val k = it.key
            val v = it.value
            when (v) {
                is IBinder -> putBinder(k, v)
                is Bundle -> putBundle(k, v)
                is Byte -> putByte(k, v)
                is ByteArray -> putByteArray(k, v)
                is Char -> putChar(k, v)
                is CharArray -> putCharArray(k, v)
                is CharSequence -> putCharSequence(k, v)
                is Float -> putFloat(k, v)
                is FloatArray -> putFloatArray(k, v)
                is Parcelable -> putParcelable(k, v)
                is Serializable -> {
                    putSerializable(k, v)
                }
                is Short -> putShort(k, v)
                is ShortArray -> putShortArray(k, v)
                else -> throw IllegalArgumentException("$v is of a type that is not currently supported")
            }
        }
    }
}