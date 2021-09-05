package dev.weazyexe.goosebank.util

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.core.graphics.Insets
import androidx.core.view.*
import androidx.core.view.WindowInsetsCompat.Type.ime
import androidx.core.view.WindowInsetsCompat.Type.systemBars
import androidx.fragment.app.Fragment
import dev.weazyexe.goosebank.ui.common.EasyInsetsAnimationCallback

/**
 * Go to edge-to-edge mode and handle insets on the [Activity]
 */
fun Activity.edgeToEdge(handling: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        WindowCompat.setDecorFitsSystemWindows(window, false)

        window.statusBarColor = color(android.R.color.transparent)
        window.navigationBarColor = color(android.R.color.transparent)

        handling()
    }
}

/**
 * Go to edge-to-edge mode and handle insets on the [Fragment]
 */
fun Fragment.edgeToEdge(handling: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val window = requireActivity().window

        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = color(android.R.color.transparent)
        window.navigationBarColor = color(android.R.color.transparent)

        handling()
    }
}

/**
 * Handle insets on the [View] with padding
 */
infix fun View.paddingTo(insetType: Int) {
    paddingTo(insetType, null)
}

/**
 * Handle insets on the [View] with padding
 */
fun View.paddingTo(insetType: Int, onInsetsUpdate: (() -> Unit)?) {
    val oldPaddingLeft = paddingLeft
    val oldPaddingTop = paddingTop
    val oldPaddingRight = paddingRight
    val oldPaddingBottom = paddingBottom

    ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
        val inset = insets.getInsets(insetType)
        view.updatePadding(
            left = oldPaddingLeft + inset.left,
            top = oldPaddingTop + inset.top,
            right = oldPaddingRight + inset.right,
            bottom = oldPaddingBottom + inset.bottom
        )

        onInsetsUpdate?.invoke()

        insets
    }
}

/**
 * Handle insets on the [View] with margin
 */
infix fun View.marginTo(insetType: Int) {
    marginTo(insetType, null)
}

/**
 * Handle insets on the [View] with margin
 */
fun View.marginTo(insetType: Int, onInsetsUpdate: (() -> Unit)?) {
    val oldMarginLeft = marginLeft
    val oldMarginTop = marginTop
    val oldMarginRight = marginRight
    val oldMarginBottom = marginBottom

    ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
        val inset = insets.getInsets(insetType)
        view.updateMargin(
            left = oldMarginLeft + inset.left,
            top = oldMarginTop + inset.top,
            right = oldMarginRight + inset.right,
            bottom = oldMarginBottom + inset.bottom
        )

        onInsetsUpdate?.invoke()

        insets
    }
}

/**
 * Animates insets' appearing and disappearing
 *
 * @param deferredInsetsTypes insets what have to be handled and animated
 * @param persistentInsetsTypes system persistent insets
 * @param additionalInsets our own insets to be handled with others
 */
fun View.animateInsets(
    deferredInsetsTypes: Int = ime(),
    persistentInsetsTypes: Int = systemBars(),
    additionalInsets: Insets = Insets.NONE
) {
    ViewCompat.setWindowInsetsAnimationCallback(
        this,
        EasyInsetsAnimationCallback(
            this,
            deferredInsetsTypes,
            persistentInsetsTypes,
            additionalInsets
        )
    )
}

/**
 * Checks is keyboard visible right now
 */
fun View.isKeyboardVisible(): Boolean = isInsetVisible(ime())

/**
 * Shows the soft keyboard
 */
fun View.showKeyboard() {
    val activity = context as? Activity ?: return
    val controller = WindowInsetsControllerCompat(activity.window, this)
    controller.show(ime())
}

/**
 * Hides the soft keyboard
 */
fun View.hideKeyboard() {
    val activity = context as? Activity ?: return
    val controller = WindowInsetsControllerCompat(activity.window, this)
    controller.hide(ime())
}

/**
 * Checks is inset with [insetType] visible right now
 */
private fun View.isInsetVisible(insetType: Int): Boolean {
    val insets = ViewCompat.getRootWindowInsets(this)
    return insets?.isVisible(insetType) == true
}