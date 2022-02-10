package com.example.shopscannerx.Ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopscannerx.*
import com.example.shopscannerx.databinding.FragmentItemsInBaseBinding
import com.example.shopscannerx.databinding.FragmentScanBarcodeBinding


import java.util.concurrent.Executors

class ItemsInBaseFragment: Fragment(
    R.layout.fragment_items_in_base
) {





    private lateinit var barcodeViewModel: BarcodeViewModel
//     by viewModels ()
//    private val binding: FragmentItemsInBaseBinding by viewBinding(
//        FragmentItemsInBaseBinding::bind)
//    private var _binding: FragmentItemsInBaseBinding? = null
//    private val binding get() = _binding!!

    private val binding:  FragmentItemsInBaseBinding by
    viewBinding( FragmentItemsInBaseBinding::bind)
//    {
//        BarcodeViewModelFactory((application as BarcodeApplication).repository)
//    }
//    private val binding: FragmentItemsInBaseBinding by
//    viewBinding(FragmentItemsInBaseBinding::bind)
//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
////    val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
////    recyclerView.layoutManager = LinearLayoutManager(this)
//}


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recyclerview_item, container, false)
//        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(this)


//
//        return inflater.inflate(R.layout.fragment_items_in_base, container, false)

    }

////        val binding = view?.let { FragmentItemsInBaseBinding.bind(it) }
//
//        _binding = FragmentItemsInBaseBinding.inflate(
//            inflater
////            , R.layout.fragment_items_in_base
//            , container, false
//        )
//        return binding.root
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val binding: FragmentItemsInBaseBinding = DataBindingUtil.inflate(
//
//            inflater, R.layout.fragment_items_in_base, container, false
        val binding = FragmentItemsInBaseBinding.bind(view)
        val barcodeAdapter = BarcodeListAdapter()
//               binding.recyclerview.adapter = barcodeAdapter

        binding.
               apply {
            recyclerview
                .apply {
                adapter = barcodeAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }

//        val barcodeAdapter = BarcodeListAdapter
//        binding.apply {
//            recyclerview
//                .apply {
//                adapter = barcodeAdapter
//                layoutManager = LinearLayoutManager(requireContext())
//                setHasFixedSize(true)
//            }
//        }
//        return binding.root
    }
        barcodeViewModel.allBarcode.observe(viewLifecycleOwner){
            barcodeAdapter.submitList(it)
        }

//    RecyclerView.Adapter<RecyclerView.ViewHolder!>?..RecyclerView.Adapter<*>?


}
}
//val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
//val adapter = WordListAdapter()
//recyclerView.adapter = adapter
//recyclerView.layoutManager = LinearLayoutManager(this)