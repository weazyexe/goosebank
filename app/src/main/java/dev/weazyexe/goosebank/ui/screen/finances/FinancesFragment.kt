package dev.weazyexe.goosebank.ui.screen.finances

import android.os.Bundle
import android.view.View
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dev.weazyexe.goosebank.R
import dev.weazyexe.goosebank.databinding.FragmentFinancesBinding
import dev.weazyexe.goosebank.ui.common.BaseFragment
import dev.weazyexe.goosebank.ui.screen.finances.adapter.AccountAdapter
import dev.weazyexe.goosebank.util.edgeToEdge
import dev.weazyexe.goosebank.util.margin
import dev.weazyexe.goosebank.util.padding
import dev.weazyexe.goosebank.util.string

/**
 * My finances screen
 */
class FinancesFragment : BaseFragment(R.layout.fragment_finances) {

    private val viewModel by viewModels<FinancesViewModel>()
    private val binding by lazy { FragmentFinancesBinding.bind(requireView()) }

    private val adapter = AccountAdapter()

    override fun tag(): String = "FINANCES_FRAGMENT"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        setupAdapter()
        edgeToEdge()

        adapter.submitList(viewModel.loadAccounts())
    }

    private fun setupToolbar() = with(binding) {
        toolbar.title = string(R.string.menu_finances)
    }

    private fun setupAdapter() = with(binding) {
        accountsRv.adapter = adapter
        accountsRv.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun edgeToEdge() = with(binding) {
        edgeToEdge {
            toolbar.margin(WindowInsetsCompat.Type.statusBars())
        }
    }
}