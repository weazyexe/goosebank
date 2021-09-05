package dev.weazyexe.goosebank.ui.screen.chat

import android.os.Bundle
import android.view.View
import androidx.core.graphics.Insets
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
        chatToolbar.title = string(R.string.menu_support)
    }

    private fun edgeToEdge() = with(binding) {
        edgeToEdge {
            chatToolbar marginTo statusBars()

            doOnLayout {
                val bottomDiff = activityBinding.bottomNavigation.height
                val ignoredInsets = Insets.of(0, 0, 0, bottomDiff - typeMessageTv.marginBottom)

                typeMessageTv.animateInsets(additionalInsets = ignoredInsets)
                messagesRv.animateInsets(additionalInsets = ignoredInsets)
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
}