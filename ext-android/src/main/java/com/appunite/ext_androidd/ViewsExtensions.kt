package com.appunite.ext_androidd

import android.support.annotation.LayoutRes
import android.support.annotation.UiThread
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation

fun ViewGroup.inflate(@LayoutRes layoutId: Int): View = LayoutInflater.from(context).inflate(layoutId, this, false)

fun ViewGroup.forEach(func: (View) -> Unit) {
    for (i in 0 until childCount) {
        func(getChildAt(i))
    }
}

@UiThread
fun View.setVisible() = { visibility = View.VISIBLE }

@UiThread
fun View.setIvisible() = { visibility = View.INVISIBLE }

@UiThread
fun View.setGone() = { visibility = View.GONE }

@UiThread
fun View.setVisible(visible: Boolean) = { visibility = if (visible) View.VISIBLE else View.GONE }

@UiThread
fun View.setVisible(visible: Boolean, visibilityWhenFalse: Int = View.GONE) = { visibility = if (visible) View.VISIBLE else visibilityWhenFalse }

@UiThread
fun View.fadeIn(duration: Long) {
    clearAnimation()
    val anim = AlphaAnimation(alpha, 1.0f)
    anim.duration = duration
    startAnimation(anim)
}

@UiThread
fun View.fadeOut(duration: Long) {
    clearAnimation()
    val anim = AlphaAnimation(alpha, 0.0f)
    anim.duration = duration
    startAnimation(anim)
}