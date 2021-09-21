package com.modulesplayground

import android.util.Log
import android.widget.LinearLayout
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.views.image.ImageResizeMode

import com.facebook.react.views.image.ReactImageView

import com.facebook.react.uimanager.ViewProps

import com.facebook.react.uimanager.annotations.ReactProp
import com.vanniktech.emoji.EmojiEditText


class EmojiKeyboardManager: ViewGroupManager<EmojiKeyboardGeneratorView>() {
    private val COMMAND_TOGGLE_KEYBOARD = 1
    private val COMMAND_CHANGE_TEXT = 2
    lateinit var emojiView : EmojiKeyboardGeneratorView
    override fun createViewInstance(context: ThemedReactContext): EmojiKeyboardGeneratorView {
        emojiView = EmojiKeyboardGeneratorView(context)
       return emojiView
    }
    override fun getName(): String {
        return "EmojiKeyboard"
    }

    override fun getCommandsMap(): MutableMap<String, Int> {
        return MapBuilder.of(
            "toggleKeyboard",
            COMMAND_TOGGLE_KEYBOARD,
            "changetext",
            COMMAND_CHANGE_TEXT,
            );
    }

    override fun getExportedCustomDirectEventTypeConstants(): MutableMap<String, Any>? {
        return MapBuilder.of(
            "onTextChange",
            MapBuilder.of("registrationName", "onTextChange"),
        )
    }
    override fun receiveCommand(
        root: EmojiKeyboardGeneratorView,
        commandId: Int,
        args: ReadableArray?
    ) {
        when(commandId) {
            1 ->  emojiView.popup.toggle()
        }
    }

    @ReactProp(name = "value")
    fun setTextValue(parent: EmojiKeyboardGeneratorView, value: String) {
        parent.editText.setText(value)
    }
}