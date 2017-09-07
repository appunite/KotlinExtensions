package com.appunite.ext_androidd

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.support.v4.content.res.ResourcesCompat


fun Resources.color(resId: Int, theme: Resources.Theme? = null): Int = ResourcesCompat.getColor(this, resId, theme)

fun Resources.drawable(resId: Int, theme: Resources.Theme? = null): Drawable? = ResourcesCompat.getDrawable(this, resId, theme)

fun Resources.screenWidthPx(): Int = displayMetrics.widthPixels

fun Resources.screenHeightPx(): Int = displayMetrics.heightPixels

fun Resources.density(): Float = displayMetrics.density

fun Resources.scaledDensity(): Float = displayMetrics.scaledDensity