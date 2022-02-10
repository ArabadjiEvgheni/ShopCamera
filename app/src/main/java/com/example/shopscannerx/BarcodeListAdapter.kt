package com.example.shopscannerx

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.TaskStackBuilder.create
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shopscannerx.database.BarcodeEntity
import com.example.shopscannerx.databinding.RecyclerviewItemBinding
import kotlinx.android.synthetic.main.recyclerview_item.view.*
import androidx.recyclerview.widget.DiffUtil



class BarcodeListAdapter(private val dataSet: Array<String>): ListAdapter<BarcodeEntity,
        BarcodeListAdapter.BarcodeViewHolder>(
    DiffCallback())
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarcodeViewHolder {
        val binding = DataBindingUtil.inflate<RecyclerviewItemBinding>(
            LayoutInflater.from(parent.context),
            viewType,
            parent,
            false
        )
        return BarcodeViewHolder(binding)

    }
//    private val binding: RecyclerviewItemBinding by
//    viewBinding(RecyclerviewItemBinding::bind)


//    override fun onCreateViewHolder(parent: ViewGroup,
//                                        viewType: Int
//     ): BarcodeViewHolder{
//         return BarcodeViewHolder.create(parent)
//        }
    override fun onBindViewHolder(holder: BarcodeViewHolder,
                                  position: Int) {
    holder.binding.setVariable(BR.barcode, dataSet[position])

//        var barcode = getItem(position)
//        holder.bind(barcode)

//        val currentItem = getItem(position)
//        holder.bind(currentItem.barcodeName)
        }
    override fun getItemCount() = dataSet.size
//    class BarcodeViewHolder(itemView: View) : RecyclerView.ViewHolder((itemView)
//            binding.

//    class BarcodeViewHolder(itemBinding: RecyclerviewItemBinding
    class BarcodeViewHolder (val binding: RecyclerviewItemBinding
        ) : RecyclerView.ViewHolder(binding.root) {
//        private var barcodeNameView = binding.barcode?.barcodeName
//        fun bind(barcode: BarcodeEntity) {
//            barcodeNameView = barcode.barcodeName

//
//            binding.apply {
//                binding.barcode = barcode
//                binding.executePendingBindings()
////                itemView.textView.text = text
//            }
        }

//        companion object {
//            fun create(parent: ViewGroup): BarcodeViewHolder {
//                val binding = RecyclerviewItemBinding.inflate(
//                    LayoutInflater.from(parent.context), parent, false
//                )
//                return BarcodeViewHolder(binding)
//            }
//        }
    }

//    companion object {
//        private val BARCODE_COMPARATOR = object : DiffUtil.ItemCallback<BarcodeEntity>()
     class DiffCallback() : DiffUtil.ItemCallback<BarcodeEntity>()
//    DiffUtil.ItemCallback<BarcodeEntity>

        {
            override fun areItemsTheSame(oldItem: BarcodeEntity,
                                         newItem: BarcodeEntity
            ): Boolean {
                return oldItem === newItem
            }
            override fun areContentsTheSame(
                oldItem: BarcodeEntity,
                newItem: BarcodeEntity
            ): Boolean {
                return oldItem.barcodeName == newItem.barcodeName
            }
        }



