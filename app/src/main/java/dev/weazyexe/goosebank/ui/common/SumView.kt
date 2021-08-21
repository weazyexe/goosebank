package dev.weazyexe.goosebank.ui.common

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.view.isVisible
import dev.weazyexe.goosebank.databinding.ViewSumBinding
import dev.weazyexe.goosebank.domain.Currency

/**
 * View what displays sum more prettier
 */
class SumView(
    context: Context,
    attrs: AttributeSet
) : FrameLayout(context, attrs) {

    private val binding = ViewSumBinding.inflate(LayoutInflater.from(context)).also {
        addView(it.root)
    }

    var sum: Double? = 0.0
        set(value) {
            updateSum(value)
            field = value
        }

    var currency: Currency? = null
        set(value) {
            updateCurrency(value)
            field = value
        }

    @SuppressLint("SetTextI18n")
    private fun updateSum(sum: Double?) {
        sum?.let {
            val fractionalPart = (sum - sum.toInt()).round(2)
            val integerPart = sum.toInt().toString()

            binding.integerPartTv.text = integerPart
            binding.fractionalPartTv.text = fractionalPart
        }
    }

    private fun updateCurrency(currency: Currency?) {
        with(binding.currencyTv) {
            if (currency != null) {
                text = currency.symbol()
                isVisible = true
            } else {
                text = ""
                isVisible = false
            }
        }
    }

    private fun Double.round(decimals: Int = 2): String = "%.${decimals}f".format(this).substring(1)
}