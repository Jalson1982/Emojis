package com.modulesplayground

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.LinearLayout
import com.facebook.react.bridge.Arguments
import com.vanniktech.emoji.EmojiEditText
import com.vanniktech.emoji.EmojiPopup
import com.vanniktech.emoji.MaximalNumberOfEmojisInputFilter
import com.vanniktech.emoji.OnlyEmojisInputFilter
import com.facebook.react.uimanager.events.RCTEventEmitter

import com.facebook.react.bridge.ReactContext

import com.facebook.react.bridge.WritableMap
import com.vdurmont.emoji.EmojiParser


class EmojiKeyboardGeneratorView(context: Context) : LinearLayout(context) {
    private var myContext: Context = context
    lateinit var editText: EmojiEditText
    lateinit var popup: EmojiPopup
    private var emojiCount: Int = 0

    init {
        init()
    }

    private fun dispatchOnProgress(count: Int, text: String) {
        val event: WritableMap = Arguments.createMap()
        event.putInt("count", count)
        event.putString("text", text)
        val reactContext = context as ReactContext
        reactContext.getJSModule(RCTEventEmitter::class.java).receiveEvent(
            id,
            "onTextChange",
            event
        )
    }
    private fun init() {
        val view = inflate(myContext, R.layout.activity_main, this)
        editText = view.findViewById(R.id.emojiEditText)
        val mainView = view.findViewById<LinearLayout>(R.id.root_view)
        mainView.gravity = 1
        editText.filters = arrayOf(OnlyEmojisInputFilter(), MaximalNumberOfEmojisInputFilter(5))
        popup = EmojiPopup.Builder.fromRootView(mainView).
            setOnEmojiClickListener{ignore, ignore2 ->
                emojiCount++
            }.build(editText)
        editText.clearFocus()
        editText.disableKeyboardInput(popup);

        editText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                Log.d("Charrr", getLengthWithEmoji(editText.text.toString()).toString())
                val count1 = getEmojiCount(editText.text.toString())
                dispatchOnProgress(getLengthWithEmoji(editText.text.toString()), editText.text.toString())
            }
        })

    }

    fun getLengthWithEmoji(s: String): Int{
        var emojiCount = EmojiParser.extractEmojis(s).size;
        return emojiCount;
    }
    fun getEmojiCount(text: String): Int {
        var emojiCount = 0
        for (i in text.indices) {
            val char = text[i]
            if (Character.UnicodeBlock.of(char) == Character.UnicodeBlock.EMOTICONS) {
                emojiCount++
            }
        }
        return emojiCount / 2
    }

    fun getLengthWithEmoji1(text: String): Int {
        return text.codePointCount(0, text.length)
    }
}