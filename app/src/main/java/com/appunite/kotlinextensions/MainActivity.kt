package com.appunite.kotlinextensions

import android.os.Bundle
import android.preference.PreferenceManager
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.appunite.ext_androidd.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        snackbars()
        sharedPrefs()

    }

    private fun sharedPrefs() {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        prefs.clear()

        prefs.save {
            putString("name", "John")
            putInt("age", 26)
        }
        check(prefs.getString("name") == "John")
        check(prefs.getInt("age") == 26)

        val editor = prefs.edit()
        editor.save {
            putString("name", "John Son")
            putInt("age", 25)
        }
        check(prefs.getString("name") == "John Son")
        check(prefs.getInt("age") == 25)
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
