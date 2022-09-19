package com.example.watchchain.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.watchchain.R
import com.example.watchchain.adapter.BrowserAdapter
import com.example.watchchain.databinding.FragmentBrowserBinding

/**
 * Das MainFragment ist der Browser unserer App
 * sollte kein User eingeloggt sein wird man automatisch zum Login weitergeleitet
 */
class BrowserFragment : Fragment() {

    private lateinit var binding: FragmentBrowserBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_browser, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.nftList.adapter = BrowserAdapter(viewModel.collectors)
    }
}