package com.modulesplayground

import android.content.Context
import android.widget.LinearLayout
import com.vanniktech.emoji.EmojiEditText
import com.vanniktech.emoji.EmojiPopup
import com.vanniktech.emoji.MaximalNumberOfEmojisInputFilter
import com.vanniktech.emoji.OnlyEmojisInputFilter

class EmojiKeyboardGeneratorView(context: Context) : LinearLayout(context) {
    private var myContext: Context = context
    private lateinit var editText: EmojiEditText
    lateinit var popup: EmojiPopup

    init {
        init()
    }
    private fun init() {
        val view = inflate(myContext, R.layout.activity_main, this)
        editText = view.findViewById(R.id.emojiEditText)
        val mainView = view.findViewById<LinearLayout>(R.id.root_view)
        editText.filters = arrayOf(OnlyEmojisInputFilter(), MaximalNumberOfEmojisInputFilter(5))
        popup = EmojiPopup.Builder.fromRootView(mainView).build(editText)
    }
}