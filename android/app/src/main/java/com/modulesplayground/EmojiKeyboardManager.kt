package com.modulesplayground

import android.util.Log
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext


class EmojiKeyboardManager: SimpleViewManager<EmojiKeyboardGeneratorView>() {
    private val COMMAND_TOGGLE_KEYBOARD = 1
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
            COMMAND_TOGGLE_KEYBOARD,);
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

}