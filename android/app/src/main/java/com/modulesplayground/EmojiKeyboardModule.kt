package com.modulesplayground

import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.vanniktech.emoji.EmojiEditText
import com.vanniktech.emoji.EmojiPopup

class EmojiKeyboardModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    private lateinit var editText: EmojiEditText
    lateinit var popup: EmojiPopup

    override fun getName(): String {
        return "EmojiKeyboard"
    }

    @ReactMethod
    private fun printShit() {
        Log.d("Some shit", "hello from react native")
    }

    @ReactMethod
    private fun toggleKeyboard() {

    }
 }