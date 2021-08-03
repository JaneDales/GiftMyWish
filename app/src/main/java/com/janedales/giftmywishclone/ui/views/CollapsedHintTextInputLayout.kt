package com.janedales.giftmywishclone.ui.views

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputLayout
import java.lang.reflect.Method

class CollapsedHintTextInputLayout(context: Context, attrs: AttributeSet): TextInputLayout(context, attrs) {
    private lateinit var collapseHintMethod: Method

    init {
        isHintAnimationEnabled = false

        try {
            collapseHintMethod = TextInputLayout::class.java.getDeclaredMethod("collapseHint", Boolean::class.javaPrimitiveType)
            collapseHintMethod.isAccessible = true
        } catch (ignored: Exception) {
            ignored.printStackTrace()
        }

    }

    override fun invalidate() {
        super.invalidate()
        try {
            collapseHintMethod.invoke(this, false)
        }
        catch (e: Exception) {
            e.printStackTrace()
        }
    }

}