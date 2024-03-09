package com.example.intershipvk.ui.catalog.rv

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.intershipvk.data.Product
import com.example.intershipvk.databinding.ProductViewHolderBinding

class CatalogItemViewHolder(private val view: ProductViewHolderBinding):RecyclerView.ViewHolder(view.root) {



    @SuppressLint("SetTextI18n")
    fun bind(product: Product) = with(view){
        this.tvProductItemTitle.text = product.title
        this.tvProductItemSubtitle.text = product.brand
        this.tvDiscountItemPerc.text = "-${product.discount}%"
        this.tvProductItemPrice.text = "${product.price} $"
        Glide.with(this.ivProductItemPreview)
            .load(product.thumbnailUrl)
            .centerCrop()
            .into(this.ivProductItemPreview)
    }



}