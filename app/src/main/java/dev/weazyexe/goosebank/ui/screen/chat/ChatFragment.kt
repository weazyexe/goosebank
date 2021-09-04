package dev.weazyexe.goosebank.ui.screen.chat

import android.os.Bundle
import android.view.View
import androidx.core.view.WindowInsetsCompat.Type.ime
import androidx.core.view.WindowInsetsCompat.Type.statusBars
import androidx.core.view.marginBottom
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dev.weazyexe.goosebank.R
import dev.weazyexe.goosebank.databinding.ActivityMainBinding
import dev.weazyexe.goosebank.databinding.FragmentChatBinding
import dev.weazyexe.goosebank.ui.common.BaseFragment
import dev.weazyexe.goosebank.ui.screen.chat.adapter.MessagesAdapter
import dev.weazyexe.goosebank.util.*
import kotlinx.coroutines.flow.collectLatest

/**
 * Chat screen
 */
class ChatFragment : BaseFragment(R.layout.fragment_chat) {

    private val viewModel by viewModels<ChatViewModel>()
    private val binding by lazy { FragmentChatBinding.bind(requireView()) }
    private val activityBinding by lazy { ActivityMainBinding.bind(requireActivity().rootView()) }

    private val adapter = MessagesAdapter()

    override fun tag(): String = "CHAT_FRAGMENT"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edgeToEdge()
        setupToolbar()
        setupAdapter()
        observe()

        viewModel.loadMessages()
    }

    private fun setupToolbar() = with(binding) {
        toolbar.title = string(R.string.menu_chat)
    }

    private fun edgeToEdge() = with(binding) {
        edgeToEdge {
            toolbar marginTo statusBars()

            messagesRv.marginTo(ime()) {
                messagesRv.scrollDown()
                handleBottomNavMargin(messagesRv)
            }

            typeMessageTv.marginTo(ime()) {
                handleBottomNavMargin(typeMessageTv)
            }
        }
    }

    private fun setupAdapter() = with(binding) {
        messagesRv.adapter = adapter
        messagesRv.layoutManager = LinearLayoutManager(requireContext()).apply {
            stackFromEnd = true
        }
    }

    private fun observe() {
        lifecycleScope.launchWhenCreated {
            viewModel.messages.collectLatest {
                adapter.submitList(it)
            }
        }
    }

    /**
     * Handle too large bottom margin because nav bar
     */
    private fun handleBottomNavMargin(view: View) {
        if (view.isKeyboardVisible()) {
            val bottomNavHeight = activityBinding.bottomNavigation.height
            val oldMargin = view.marginBottom
            view.updateMargin(bottom = oldMargin - bottomNavHeight)
        }
    }
}