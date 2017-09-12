package com.appunite.ext_androidd

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.support.v4.content.res.ResourcesCompat
import android.util.TypedValue


fun Resources.color(resId: Int, theme: Resources.Theme? = null): Int = ResourcesCompat.getColor(this, resId, theme)

fun Resources.drawable(resId: Int, theme: Resources.Theme? = null): Drawable = ResourcesCompat.getDrawable(this, resId, theme)!!

fun Resources.dpToPx(dp: Int): Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), displayMetrics)

val Resources.screenWidthPx: Int
    get() = displayMetrics.widthPixels

val Resources.screenHeightPx: Int
    get() = displayMetrics.heightPixels

val Resources.density: Float
    get() = displayMetrics.density

val Resources.scaledDensity: Float
    get() = displayMetrics.scaledDensity