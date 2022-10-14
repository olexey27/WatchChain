package com.example.watchchain.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.watchchain.R
import com.example.watchchain.databinding.FragmentWalletBinding
import com.example.watchchain.ui.authentication.MainViewModel

class WalletFragment : Fragment() {

    private lateinit var binding: FragmentWalletBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_wallet, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.receive.setOnClickListener() {
            Toast.makeText(context,R.string.error, Toast.LENGTH_LONG).show()
        }
        binding.receiveImg.setOnClickListener() {
            Toast.makeText(context,R.string.error,Toast.LENGTH_LONG).show()
        }
        binding.buyText.setOnClickListener() {
            Toast.makeText(context,R.string.error,Toast.LENGTH_LONG).show()
        }
        binding.moneyImg.setOnClickListener() {
            Toast.makeText(context,R.string.error,Toast.LENGTH_LONG).show()
        }
        binding.sendMoneyImg.setOnClickListener() {
            Toast.makeText(context,R.string.error,Toast.LENGTH_LONG).show()
        }
        binding.sendMoney.setOnClickListener() {
            Toast.makeText(context,R.string.error,Toast.LENGTH_LONG).show()
        }
    }
}