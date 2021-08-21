package dev.weazyexe.goosebank.ui.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.weazyexe.goosebank.R
import dev.weazyexe.goosebank.databinding.ActivityMainBinding
import dev.weazyexe.goosebank.ui.common.BaseFragment
import dev.weazyexe.goosebank.ui.screen.chat.ChatFragment
import dev.weazyexe.goosebank.ui.screen.finances.FinancesFragment
import dev.weazyexe.goosebank.ui.screen.history.HistoryFragment
import dev.weazyexe.goosebank.ui.screen.payments.PaymentsFragment

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
    }

    private fun setupBottomNav() {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragment_container, financesFragment, financesFragment.tag())
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
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, fragment)
                currentScreen = fragment
                commit()
            }

            return true
        }

        return false
    }
}