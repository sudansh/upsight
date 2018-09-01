package com.sudansh.upsight.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import com.sudansh.upsight.R
import com.sudansh.upsight.databinding.ActivityLoginBinding
import com.sudansh.upsight.utils.*
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val prefs: Prefs by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        gender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, v: View?, position: Int, id: Long) {
//                viewModel.gender = resources.getStringArray(R.array.gender)[position]
            }
        }
        name.editText!!.setText(prefs.getString(PREF_KEY_NAME, DEFAULT_NAME))
        age.editText!!.setText(prefs.getInt(PREF_KEY_AGE, DEFAULT_AGE).toString())
        gender.setSelection(resources.getStringArray(R.array.gender).indexOf(prefs.getString(PREF_KEY_GENDER, DEFAULT_GENDER)))
        save.setOnClickListener { onSave() }
    }

    fun onSave() {
        prefs.write(PREF_KEY_NAME, name.editText!!.text.toString())
        prefs.write(PREF_KEY_AGE, Integer.parseInt(age.editText!!.text.toString()))
        prefs.write(PREF_KEY_GENDER, gender.selectedItem.toString())
    }
}