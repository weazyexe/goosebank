package dev.weazyexe.goosebank.ui.common

import android.view.View
import androidx.core.graphics.Insets
import androidx.core.view.WindowInsetsAnimationCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsCompat.Type.ime
import androidx.core.view.WindowInsetsCompat.Type.systemBars

/**
 * [WindowInsetsAnimationCompat.Callback] what handles insets types animation
 *
 * @param view view what needs to be handled
 * @param deferredInsetsTypes insets what have to be handled and animated
 * @param persistentInsetsTypes system persistent insets
 * @param additionalInsets our own insets to be handled with others
 * @param dispatchMode callback dispatch mode. See [WindowInsetsAnimationCompat.Callback.DispatchMode]
 */
class EasyInsetsAnimationCallback(
    private val view: View,
    private val deferredInsetsTypes: Int = ime(),
    private val persistentInsetsTypes: Int = systemBars(),
    private val additionalInsets: Insets = Insets.NONE,
    @DispatchMode dispatchMode: Int = DISPATCH_MODE_CONTINUE_ON_SUBTREE
) : WindowInsetsAnimationCompat.Callback(dispatchMode) {

    override fun onProgress(
        insets: WindowInsetsCompat,
        runningAnimations: MutableList<WindowInsetsAnimationCompat>
    ): WindowInsetsCompat {

        val typesInset = insets.getInsets(deferredInsetsTypes)
        val otherInset = insets.getInsets(persistentInsetsTypes)

        val systemInsetsDiff = Insets.subtract(typesInset, otherInset)
        val diff = Insets.subtract(systemInsetsDiff, additionalInsets).let {
            Insets.max(it, Insets.NONE)
        }

        view.translationX = (diff.left - diff.right).toFloat()
        view.translationY = (diff.top - diff.bottom).toFloat()

        return insets
    }
}
