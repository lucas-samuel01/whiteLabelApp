package com.lucas.whitelabelapp.ui.products

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lucas.whitelabelapp.databinding.ItemProductBinding
import com.lucas.whitelabelapp.domain.model.Product
import com.lucas.whitelabelapp.util.toCurrency
import java.nio.file.Path

class ProductsAdapter: ListAdapter<Product,ProductsAdapter.ProductsViewHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        return ProductsViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
       holder.binding(getItem(position))
    }

    class  ProductsViewHolder(
        private val itemBinding:ItemProductBinding
    ):RecyclerView.ViewHolder(itemBinding.root) {
        fun binding(product: Product) {
            itemBinding.run{
                Glide.with(itemView).load(product.imageUrl)
                    .fitCenter()
                    .into(imageProduct)

                textDescription.text = product.description
                textPrice.text = product.price.toCurrency()
            }
        }
        companion object {
            fun create(parent: ViewGroup):ProductsViewHolder{
                val itemBinding = ItemProductBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                return  ProductsViewHolder(itemBinding)
            }
        }
    }
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                    return oldItem == newItem
            }
        }
    }


}