package com.example.pruebatecnica.mvvm.common

import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pruebatecnica.R
import com.example.pruebatecnica.data.dto.ProductDTO
import com.example.pruebatecnica.databinding.ProductItemBinding

class ProductAdapter(
    private var _productList: MutableList<ProductDTO> = mutableListOf(),
    private val action: (ProductDTO) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductDTO) {
            binding?.apply {
                tvProductName.text = item.nameProduct
                if (item.productPromoPrice<=0.0) {
                    tvProductPrice.text = "$" + item.productPrice.toString()
                    tvProductPricePromo.visibility = View.GONE
                } else {
                    val text = "$ ${item.productPrice.toString()}"
                    val spannableString = SpannableString(text)
                    spannableString.setSpan(StrikethroughSpan(), 0, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                    tvProductPrice.text = spannableString
                    tvProductPricePromo.text ="$"+item.productPromoPrice.toString()
                }
                val imageUrl = item.smImage?.takeIf { it.isNotEmpty() }
                    ?: item.lgImage?.takeIf { it.isNotEmpty() }
                    ?: item.xlImage?.takeIf { it.isNotEmpty() } ?: ""
                Glide
                    .with(binding.root.context)
                    .load(imageUrl)
                    .error(R.drawable.ic_withou_image)
                    .centerCrop()
                    .into(ivProductImage)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProductItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(_productList[position])
    }

    override fun getItemCount(): Int = _productList.size

    fun updateProductList(value: MutableList<ProductDTO>) {
        _productList = value
        notifyDataSetChanged()
    }
}