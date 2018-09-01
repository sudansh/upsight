package com.sudansh.upsight.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.sudansh.upsight.R
import com.sudansh.upsight.databinding.ActivityMainBinding
import com.sudansh.upsight.utils.getText
import com.upsight.android.UpsightContext
import com.upsight.android.UpsightException
import com.upsight.android.analytics.event.UpsightCustomEvent
import com.upsight.android.analytics.event.milestone.UpsightMilestoneEvent
import com.upsight.android.analytics.provider.UpsightUserAttributes
import com.upsight.android.managedvariables.type.UpsightManagedInt
import com.upsight.android.managedvariables.type.UpsightManagedString
import com.upsight.android.managedvariables.type.UpsightManagedVariable
import com.upsight.android.marketing.*
import kotlinx.android.synthetic.main.view_custom_event.*
import kotlinx.android.synthetic.main.view_milestone.*
import kotlinx.android.synthetic.main.view_user_attributes.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), UpsightBillboard.Handler {

    private lateinit var binding: ActivityMainBinding
    private val upsight: UpsightContext by inject()
    private val viewModel by lazy { LoginViewModel() }
    private var billboard: UpsightBillboard? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewmodel = viewModel

        viewModel.name.set(UpsightUserAttributes.getString(upsight, getString(R.string.key_name)))
        viewModel.age.set(UpsightUserAttributes.getInteger(upsight, getString(R.string.key_age)))
        viewModel.gender.set(UpsightUserAttributes.getString(upsight, getString(R.string.key_gender)))
        save.setOnClickListener { onSave() }
        track.setOnClickListener { sendCustomEvent() }
        milestone.setOnClickListener { sendMilestone() }
        show_billboard.setOnClickListener { sendMilestone() }
        retrieveManagedVariables()
    }

    override fun onResume() {
        super.onResume()
        createBillboard()
    }

    private fun createBillboard() {
        billboard = UpsightBillboard.create(upsight, "upsightintegration", this)
    }

    private fun retrieveManagedVariables() {
        UpsightManagedString.fetch(upsight, "personage_name",
                object : UpsightManagedVariable.Listener<UpsightManagedString> {
                    override fun onSuccess(p0: UpsightManagedString?) {
                        viewModel.managedName.set(p0?.get().orEmpty())
                    }

                    override fun onFailure(p0: UpsightException?) {
                        viewModel.managedName.set(getString(R.string.error_loading_value))
                    }
                })
        UpsightManagedInt.fetch(upsight, "personage_coins",
                object : UpsightManagedVariable.Listener<UpsightManagedInt> {
                    override fun onSuccess(p0: UpsightManagedInt?) {
                        viewModel.managedCoins.set(p0?.get() ?: 0)
                    }

                    override fun onFailure(p0: UpsightException?) {
                        viewModel.managedName.set(getString(R.string.error_loading_value))
                    }
                })
    }

    override fun onPause() {
        billboard?.destroy()
        super.onPause()
    }

    private fun onSave() {
        UpsightCustomEvent.createBuilder("button_save_clicked").record(upsight)
        UpsightUserAttributes.put(upsight, getString(R.string.key_name), getName())
        UpsightUserAttributes.put(upsight, getString(R.string.key_age), getAge())
        UpsightUserAttributes.put(upsight, getString(R.string.key_gender), getGender())
    }

    private fun getGender() = gender.getText()

    private fun getAge() = Integer.parseInt(age.getText())

    private fun getName() = name.getText()

    private fun sendCustomEvent() {
        if (key.getText().isEmpty()) key.editText!!.error = getString(R.string.error_empty_field)
        if (value.getText().isEmpty()) value.editText!!.error = getString(R.string.error_empty_field)
        if (value.getText().isEmpty() || key.getText().isEmpty()) return
        UpsightCustomEvent.createBuilder("custom_user_attributes")
                .put(key.getText(), value.getText())
                .record(upsight)
    }

    private fun sendMilestone() {
        UpsightMilestoneEvent.createBuilder("upsightintegration").record(upsight)

    }

    override fun onDetach() {}

    override fun onData(p0: UpsightData?) {}

    override fun onPurchases(p0: MutableList<UpsightPurchase>?) {}

    override fun onAttach(p0: String?, p1: UpsightContentHint?): UpsightBillboard.AttachParameters? {
        return if (show_billboard.visibility == View.GONE) {
            show_billboard.visibility = View.VISIBLE
            null
        } else UpsightBillboard.AttachParameters(this)
    }

    override fun onRewards(p0: MutableList<UpsightReward>?) {}

    override fun onNextView() {}

}