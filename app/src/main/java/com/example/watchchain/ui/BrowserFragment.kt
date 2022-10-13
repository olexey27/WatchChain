package com.example.watchchain.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.example.watchchain.adapter.CollectorAdapter
import com.example.watchchain.databinding.FragmentBrowserBinding
import com.example.watchchain.ui.authentication.ApiStatus
import com.example.watchchain.ui.authentication.MainViewModel


class BrowserFragment : Fragment() {

    private lateinit var binding: FragmentBrowserBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBrowserBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.nfts.observe(
            viewLifecycleOwner,
            Observer {
                binding.collectorViewBrowser.adapter = CollectorAdapter(it)
            }
        )

        viewModel.loading.observe(
            viewLifecycleOwner,
            Observer {
                when (it) {
                    ApiStatus.LOADING -> binding.homeSpinner.visibility = View.VISIBLE
                    ApiStatus.ERROR -> {
                        binding.homeSpinner.visibility = View.GONE
                        binding.homeError.visibility = View.VISIBLE
                    }
                    ApiStatus.DONE -> binding.homeSpinner.visibility = View.GONE
                }
            }
        )
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.collectorViewBrowser)
    }
}