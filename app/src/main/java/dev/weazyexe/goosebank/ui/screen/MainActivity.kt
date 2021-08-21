package dev.weazyexe.goosebank.ui.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsCompat.Type.navigationBars
import androidx.fragment.app.commitNow
import dev.weazyexe.goosebank.R
import dev.weazyexe.goosebank.databinding.ActivityMainBinding
import dev.weazyexe.goosebank.ui.common.BaseFragment
import dev.weazyexe.goosebank.ui.screen.chat.ChatFragment
import dev.weazyexe.goosebank.ui.screen.finances.FinancesFragment
import dev.weazyexe.goosebank.ui.screen.history.HistoryFragment
import dev.weazyexe.goosebank.ui.screen.payments.PaymentsFragment
import dev.weazyexe.goosebank.util.edgeToEdge
import dev.weazyexe.goosebank.util.paddingTo

/**
 * Main screen
 */
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private var currentScreen: BaseFragment? = null

    private val financesFragment by lazy { FinancesFragment() }
    private val historyFragment by lazy { HistoryFragment() }
    private val paymentsFragment by lazy { PaymentsFragment() }
    private val chatFragment by lazy { ChatFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupBottomNav()
        edgeToEdge()
    }

    private fun setupBottomNav() {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragment_container, historyFragment, historyFragment.tag()).hide(
                historyFragment
            )
            add(R.id.fragment_container, paymentsFragment, paymentsFragment.tag()).hide(
                paymentsFragment
            )
            add(R.id.fragment_container, chatFragment, chatFragment.tag()).hide(chatFragment)
            add(R.id.fragment_container, financesFragment, financesFragment.tag())
            currentScreen = financesFragment
            commit()
        }

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.tab_finances -> navigate(financesFragment)
                R.id.tab_history -> navigate(historyFragment)
                R.id.tab_payments -> navigate(paymentsFragment)
                R.id.tab_chat -> navigate(chatFragment)
                else -> false
            }
        }
    }

    private fun navigate(fragment: BaseFragment): Boolean {
        if (fragment != currentScreen) {
            supportFragmentManager.commitNow {
                hide(currentScreen ?: return false).show(fragment)
                currentScreen = fragment
            }

            return true
        }

        return false
    }

    private fun edgeToEdge() = with(binding) {
        edgeToEdge {
            bottomNavigation paddingTo navigationBars()
        }
    }
}