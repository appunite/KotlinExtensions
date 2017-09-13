package com.appunite.ext_androidd

import android.content.SharedPreferences
import java.util.*


fun SharedPreferences.save(func: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.func()
    editor.apply()
}

fun SharedPreferences.clear() {
    edit().clear().apply()
}

fun SharedPreferences.addToSet(setKey: String, value: String) {
    val originalSet = getStringSet(setKey, setOf<String>())
    val updatedSet = LinkedHashSet(originalSet) // Copy is needed as you cannot modify set from SharedPreferences
    updatedSet.add(value)
    save { putStringSet(setKey, updatedSet) }
}

fun SharedPreferences.removeFromSet(setKey: String, value: String) {
    val originalSet = getStringSet(setKey, setOf<String>())
    val updatedSet = LinkedHashSet(originalSet) // Copy is needed as you cannot modify set from SharedPreferences
    updatedSet.remove(value)
    save { putStringSet(setKey, updatedSet) }
}

fun SharedPreferences.getInt(key: String): Int {
    return getInt(key, 0)
}

fun SharedPreferences.getLong(key: String): Long {
    return getLong(key, 0L)
}

fun SharedPreferences.getFloat(key: String): Float {
    return getFloat(key, 0f)
}

fun SharedPreferences.getString(key: String): String? {
    return getString(key, null)
}

fun SharedPreferences.getBoolean(key: String): Boolean {
    return getBoolean(key, false)
}

fun SharedPreferences.getStringSet(key: String): Set<String> {
    return getStringSet(key, setOf())
}

fun SharedPreferences.Editor.save(func: SharedPreferences.Editor.() -> Unit) {
    func()
    apply()
}