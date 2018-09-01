package com.sudansh.upsight.utils

import android.databinding.BindingAdapter
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner


object BindUtils {

    @BindingAdapter("adapter")
    fun setAdapter(spinner: Spinner, list: List<String>) {
        val adapter = ArrayAdapter(spinner.context, android.R.layout.simple_list_item_1, list)
        spinner.adapter = adapter
    }

    interface OnItemSelectedListener {
        fun onItemSelected(item: Any)
    }

    @BindingAdapter("itemSelectedListener")
    fun setListener(spinner: Spinner, itemSelectedListener: OnItemSelectedListener?) {
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                itemSelectedListener?.onItemSelected(parent.selectedItem)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }


}