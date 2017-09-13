package com.appunite.kotlinextensions

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.appunite.ext_androidd.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        snackbars()

    }

    private fun snackbars() {
        showSnackbar(R.string.app_name)
                .concatWith(snackbarLong("Snackbar long")
                        .concatWith(
                                snackbar(text = "Colored indefinite",
                                        duration = Snackbar.LENGTH_INDEFINITE,
                                        bgColor = resources.color(R.color.colorPrimary),
                                        actionText = "Play",
                                        action = { showSnackbar(text = "action clicked") }
                                )
                        )
                )
    }
}
