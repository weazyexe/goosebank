package dev.weazyexe.goosebank.ui.screen.history

import android.os.Bundle
import android.view.View
import androidx.core.view.WindowInsetsCompat.Type.statusBars
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dev.weazyexe.goosebank.R
import dev.weazyexe.goosebank.databinding.FragmentHistoryBinding
import dev.weazyexe.goosebank.ui.common.BaseFragment
import dev.weazyexe.goosebank.ui.screen.history.adapter.TransactionAdapter
import dev.weazyexe.goosebank.util.edgeToEdge
import dev.weazyexe.goosebank.util.marginTo
import dev.weazyexe.goosebank.util.string
import kotlinx.coroutines.flow.collectLatest


/**
 * Transactions history screen
 */
class HistoryFragment : BaseFragment(R.layout.fragment_history) {

    private val viewModel by viewModels<HistoryViewModel>()
    private val binding by lazy { FragmentHistoryBinding.bind(requireView()) }

    private val adapter = TransactionAdapter()

    override fun tag(): String = "HISTORY_FRAGMENT"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.searchTransactions()

        edgeToEdge()
        setupToolbar()
        setupAdapter()

        listen()
        observe()
    }

    private fun setupToolbar() = with(binding) {
        setHasOptionsMenu(true)
        toolbar.title = string(R.string.menu_history)
        toolbar.menu = R.menu.search_menu
    }

    private fun edgeToEdge() = with(binding) {
        edgeToEdge {
            toolbar marginTo statusBars()
        }
    }

    private fun setupAdapter() = with(binding) {
        transactionsRv.adapter = adapter

        val layoutManager = LinearLayoutManager(requireContext())
        val dividerDecorator = DividerItemDecoration(
            requireContext(),
            layoutManager.orientation
        )

        transactionsRv.layoutManager = layoutManager
        transactionsRv.addItemDecoration(dividerDecorator)
    }

    private fun observe() {
        lifecycleScope.launchWhenCreated {
            viewModel.transactions.collectLatest {
                adapter.submitList(it)
            }
        }
    }

    private fun listen() = with(binding) {
        toolbar.onSearchChanged = {
            viewModel.searchTransactions(it)
        }
    }
}