package dev.weazyexe.goosebank.util

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.ViewGroup
import androidx.core.view.*
import androidx.fragment.app.Fragment

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

        insets
    }
}

/**
 * Handle insets on the [View] with margin
 */
infix fun View.marginTo(insetType: Int) {
    val oldMarginLeft = marginLeft
    val oldMarginTop = marginTop
    val oldMarginRight = marginRight
    val oldMarginBottom = marginBottom

    ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
        val inset = insets.getInsets(insetType)
        view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            updateMargins(
                left = oldMarginLeft + inset.left,
                top = oldMarginTop + inset.top,
                right = oldMarginRight + inset.right,
                bottom = oldMarginBottom + inset.bottom
            )
        }

        insets
    }
}