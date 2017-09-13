package com.appunite.ext_androidd

import android.content.Context
import android.support.v4.content.ContextCompat

fun Context.checkPermission(permissions: String): Int = ContextCompat.checkSelfPermission(this, permissions)







