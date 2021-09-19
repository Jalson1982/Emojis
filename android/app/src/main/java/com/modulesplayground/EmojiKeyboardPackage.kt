package com.modulesplayground;

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager
import java.util.*
import kotlin.collections.ArrayList

class EmojiKeyboardPackage: ReactPackage {
    override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
        return listOf(EmojiKeyboardManager())
    }

    override fun createNativeModules(
        reactContext: ReactApplicationContext): List<NativeModule> {
        val modules = ArrayList<NativeModule>()

        modules.add(EmojiKeyboard(reactContext))

        return modules
    }
}
