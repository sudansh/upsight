package com.sudansh.upsight.upsight

import com.sudansh.upsight.R
import com.upsight.android.UpsightContext
import com.upsight.android.analytics.provider.UpsightSessionContext
import com.upsight.android.analytics.provider.UpsightUserAttributes
import com.upsight.android.analytics.session.UpsightSessionCallbacks
import com.upsight.android.analytics.session.UpsightSessionInfo
import com.upsight.android.analytics.session.UpsightUserSessionInfo

class SessionCallback : UpsightSessionCallbacks {
    override fun onUserStarted(p0: UpsightContext?) {

    }

    override fun onUserResume(p0: UpsightSessionContext?, p1: UpsightUserSessionInfo?) {

    }

    override fun onUserStart(p0: UpsightSessionContext?, p1: UpsightUserSessionInfo?) {

    }

    override fun onResume(p0: UpsightSessionContext?, p1: UpsightSessionInfo?) {

    }

    override fun onStarted(p0: UpsightContext?) {

    }

    override fun onUserResumed(p0: UpsightContext?) {

    }

    override fun onResumed(p0: UpsightContext?) {

    }

    override fun onStart(upsight: UpsightSessionContext?, info: UpsightSessionInfo?) {
        upsight?.let {
            UpsightUserAttributes.put(upsight, "name",
                    upsight.applicationContext.getString(R.string.default_name))
            UpsightUserAttributes.put(upsight, "age",
                    upsight.applicationContext.resources.getInteger(R.integer.default_age))
            UpsightUserAttributes.put(upsight, "gender",
                    upsight.applicationContext.getString(R.string.default_gender))
        }
    }
}