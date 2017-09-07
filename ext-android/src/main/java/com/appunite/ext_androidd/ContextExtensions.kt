package com.appunite.ext_androidd

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.util.TypedValue


/** Resources wrapping **/
fun Context.color(resId: Int): Int = resources.color(resId)

fun Context.drawable(resId: Int): Drawable? = resources.drawable(resId)

fun Context.integer(resId: Int): Int = resources.getInteger(resId)

fun Context.boolean(resId: Int): Boolean = resources.getBoolean(resId)

fun Context.intArray(resId: Int): IntArray = resources.getIntArray(resId)

fun Context.stringArray(resId: Int): Array<out String> = resources.getStringArray(resId)

fun Context.textArray(resId: Int): Array<out CharSequence> = resources.getTextArray(resId)

fun Context.dimensionPixelSize(resId: Int): Int = resources.getDimensionPixelSize(resId)

fun Context.dimensionPixelOffset(resId: Int): Int = resources.getDimensionPixelOffset(resId)

fun Context.screenWidthPx(): Int = resources.screenWidthPx()

fun Context.screenHeightPx(): Int = resources.screenHeightPx()
/****/


fun Context.dpToPx(dp: Int) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), resources.displayMetrics)

fun Context.checkSelfPermission(permissions: String): Int = ContextCompat.checkSelfPermission(this, permissions)






