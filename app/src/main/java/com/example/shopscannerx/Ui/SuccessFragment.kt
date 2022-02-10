package com.example.shopscannerx.Ui

//import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.shopscannerx.R
import com.example.shopscannerx.databinding.FragmentSuccessBinding
import com.example.shopscannerx.viewBinding

class SuccessFragment : androidx.fragment.app.Fragment() {
    private val binding: FragmentSuccessBinding by
    viewBinding(FragmentSuccessBinding::bind)
//    private lateinit var mViewModel: SuccessViewModel by viewModels {
//        SuccessViewModel.SuccessViewModelFactory((application as BarcodeApplication).repository)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentSuccessBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_success, container, false
        )
        //        val v = inflater.inflate(R.layout.fragment_success, container, false)

        val safeArgs: com.example.shopscannerx.Ui.SuccessFragmentArgs by navArgs()
        val code = safeArgs.code

        binding.fragmentSuccessTextViewTitle.text = code

        binding.fragmentSuccessButtonBackToScanner.setOnClickListener { view: View ->
            view.findNavController().navigateUp()
        }
        return binding.root
    }

}