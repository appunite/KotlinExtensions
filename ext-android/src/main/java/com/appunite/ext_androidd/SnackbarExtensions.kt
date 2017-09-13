package com.appunite.ext_androidd

import android.app.Activity
import android.app.Fragment
import android.support.annotation.ColorInt
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.view.View

object SnackbarHelper {

    fun snackbar(@StringRes textResId: Int? = null,
                 text: String = "",
                 view: View,
                 duration: Int = Snackbar.LENGTH_SHORT,
                 @ColorInt colorResId: Int? = null,
                 callback: Snackbar.Callback? = null,
                 actionText: String? = null,
                 action: ((View) -> Unit)? = null,
                 @ColorInt actionTextColor: Int? = null): Snackbar {
        val snackbar = if (textResId == null) {
            Snackbar.make(view, text, duration)
        } else {
            Snackbar.make(view, textResId, duration)
        }

        if (callback != null) snackbar.addCallback(callback)
        if (colorResId != null) snackbar.view.setBackgroundColor(colorResId)
        if (actionText != null && action != null) snackbar.setAction(actionText, action)
        if (actionTextColor != null) snackbar.setActionTextColor(actionTextColor)

        return snackbar
    }

    fun showSnackbar(@StringRes textResId: Int? = null,
                     text: String = "",
                     view: View,
                     duration: Int = Snackbar.LENGTH_SHORT,
                     @ColorInt bgColor: Int? = null,
                     callback: Snackbar.Callback? = null,
                     actionText: String? = null,
                     action: ((View) -> Unit)? = null,
                     @ColorInt actionTextColor: Int? = null): Snackbar {
        val snackbar = snackbar(textResId, text, view, duration, bgColor, callback, actionText,
                action, actionTextColor)
        snackbar.show()
        return snackbar
    }
}

/** Activity **/
fun Activity.snackbar(@StringRes textResId: Int? = null,
                      text: String = "",
                      view: View = contentView(),
                      duration: Int = Snackbar.LENGTH_SHORT,
                      callback: Snackbar.Callback? = null,
                      bgColor: Int? = null,
                      actionText: String? = null,
                      action: ((View) -> Unit)? = null,
                      @ColorInt actionTextColor: Int? = null): Snackbar {
    return SnackbarHelper.snackbar(textResId, text, view, duration, bgColor,
            callback, actionText, action, actionTextColor)
}

fun Activity.snackbarLong(text: String): Snackbar {
    return snackbar(text = text, duration = Snackbar.LENGTH_LONG)
}

fun Activity.snackbarLong(textResId: Int): Snackbar {
    return snackbar(textResId = textResId, duration = Snackbar.LENGTH_LONG)
}

fun Activity.showSnackbar(@StringRes textResId: Int? = null,
                          text: String = "",
                          view: View = contentView(),
                          duration: Int = Snackbar.LENGTH_SHORT,
                          callback: Snackbar.Callback? = null,
                          @ColorInt bgColor: Int? = null,
                          actionText: String? = null,
                          action: ((View) -> Unit)? = null,
                          @ColorInt actionTextColor: Int? = null): Snackbar {
    return SnackbarHelper.showSnackbar(textResId, text, view, duration, bgColor,
            callback, actionText, action, actionTextColor)
}

fun Activity.showSnackbarLong(text: String): Snackbar {
    return showSnackbar(text = text, duration = Snackbar.LENGTH_LONG)
}

fun Activity.showSnackbarLong(textResId: Int): Snackbar {
    return showSnackbar(textResId = textResId, duration = Snackbar.LENGTH_LONG)
}
/****/

/** Fragment **/
fun Fragment.snackbar(@StringRes textResId: Int? = null,
                      text: String = "",
                      view: View = activity.contentView(),
                      duration: Int = Snackbar.LENGTH_SHORT,
                      callback: Snackbar.Callback? = null,
                      @ColorInt bgColor: Int? = null,
                      actionText: String? = null,
                      action: ((View) -> Unit)? = null,
                      @ColorInt actionTextColor: Int? = null): Snackbar {
    return SnackbarHelper.snackbar(textResId, text, view, duration, bgColor, callback,
            actionText, action, actionTextColor)
}

fun Fragment.snackbarLong(text: String): Snackbar {
    return snackbar(text = text, duration = Snackbar.LENGTH_LONG)
}

fun Fragment.snackbarLong(textResId: Int): Snackbar {
    return snackbar(textResId = textResId, duration = Snackbar.LENGTH_LONG)
}

fun Fragment.showSnackbar(@StringRes textResId: Int? = null,
                          text: String = "",
                          view: View = activity.contentView(),
                          duration: Int = Snackbar.LENGTH_SHORT,
                          callback: Snackbar.Callback? = null,
                          @ColorInt bgColor: Int? = null,
                          actionText: String? = null,
                          action: ((View) -> Unit)? = null,
                          @ColorInt actionTextColor: Int? = null): Snackbar {
    return SnackbarHelper.showSnackbar(textResId, text, view, duration, bgColor, callback,
            actionText, action, actionTextColor)
}

fun Fragment.showSnackbarLong(text: String): Snackbar {
    return showSnackbar(text = text, duration = Snackbar.LENGTH_LONG)
}

fun Fragment.showSnackbarLong(textResId: Int): Snackbar {
    return showSnackbar(textResId = textResId, duration = Snackbar.LENGTH_LONG)
}
/****/

/** Shows nextSnackbar when current is dismissed
 * @return this (current Snackbar)
 * **/
fun Snackbar.concatWith(nextSnackbar: Snackbar): Snackbar {
    this.addCallback(object : Snackbar.Callback() {
        override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
            super.onDismissed(transientBottomBar, event)
            nextSnackbar.show()
        }
    })
    return this
}
