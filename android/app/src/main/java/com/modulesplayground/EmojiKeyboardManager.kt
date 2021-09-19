package com.modulesplayground

import android.view.LayoutInflater
import android.widget.LinearLayout
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.vanniktech.emoji.EmojiEditText
import com.vanniktech.emoji.EmojiPopup


class EmojiKeyboardManager: SimpleViewManager<EmojiEditText>() {
    private lateinit var mCallerContext: ReactApplicationContext
    private val REACT_CLASS = "EmojiKeyboard"
    private lateinit var editText: EmojiEditText
    private lateinit var popUp: EmojiPopup

    fun ReactImageManager(reactContext: ReactApplicationContext) {
        mCallerContext = reactContext
    }

    override fun getName(): String {
        return REACT_CLASS
    }

    override fun createViewInstance(context: ThemedReactContext): EmojiEditText {
        val view = LayoutInflater.from(context).inflate(
            R.layout.layout,
            null
        ) as LinearLayout
        editText = view.findViewById(R.id.emojiEditText)
        EmojiPopup.Builder.fromRootView(view).build(editText)
        return EmojiEditText(context)
    }

    @ReactMethod
    private fun toggleKeyboard() {
        popUp.toggle()
    }
}