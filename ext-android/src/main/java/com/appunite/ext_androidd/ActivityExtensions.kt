package com.appunite.ext_androidd

import android.app.Activity
import android.view.View


fun Activity.contentView(): View = findViewById(android.R.id.content)