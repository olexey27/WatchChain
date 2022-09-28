package com.example.watchchain.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.example.watchchain.MainActivity
import com.example.watchchain.R
import com.example.watchchain.adapter.CollectorAdapter
import com.example.watchchain.databinding.FragmentBrowserBinding
import com.example.watchchain.ui.authentication.ApiStatus
import com.example.watchchain.ui.authentication.MainViewModel

private const val TAG = "BrowserFragment"

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

        val collectorAdapter = CollectorAdapter(requireContext())

        binding.nftList.adapter = collectorAdapter

        viewModel.nfts.observe(
            viewLifecycleOwner,
            Observer {
                collectorAdapter.submitList(it)
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
        snapHelper.attachToRecyclerView(binding.nftList)
    }
}