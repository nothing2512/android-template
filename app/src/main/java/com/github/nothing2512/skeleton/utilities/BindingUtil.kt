package com.github.nothing2512.skeleton.utilities

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@BindingAdapter("source", requireAll = false)
fun ImageView.bind(source: Any?) {
    if (source != null) {
        Glide.with(this.context)
            .load(source)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(this)
    }
}

@Suppress("unused")
@BindingAdapter("activity", "fragment", requireAll = false)
fun FrameLayout.bindFragment(activity: FragmentActivity, fragment: Fragment?) {
    fragment?.let {
        activity.supportFragmentManager
            .beginTransaction()
            .replace(this.id, it)
            .commit()
    }
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun <VDB : ViewDataBinding> Activity.getBinding(layout: Int): VDB =
    DataBindingUtil.setContentView(this, layout)

fun <VDB : ViewDataBinding> getBinding(
    inflater: LayoutInflater,
    layout: Int,
    parent: ViewGroup?
): VDB =
    DataBindingUtil.inflate(inflater, layout, parent, false)

fun <VDB : ViewDataBinding> getBinding(layout: Int, parent: ViewGroup?): VDB =
    DataBindingUtil.inflate(LayoutInflater.from(parent?.context), layout, parent, false)

fun <T> ViewModel.launchMain(block: suspend CoroutineScope.() -> T) {
    viewModelScope.launch {
        withContext(Dispatchers.Main) {
            block.invoke(this)
        }
    }
}

fun <T> launchMain(block: suspend CoroutineScope.() -> T) {
    CoroutineScope(Dispatchers.Main).launch {
        block.invoke(this)
    }
}