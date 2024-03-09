package com.example.intershipvk.ui.catalog.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.intershipvk.data.Product
import com.example.intershipvk.databinding.ProductViewHolderBinding

class CatalogAdapter(
    private val data:List<Product>
):RecyclerView.Adapter<CatalogItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogItemViewHolder =
        CatalogItemViewHolder(
            view = ProductViewHolderBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        )

    override fun getItemCount(): Int =
        data.size

    override fun onBindViewHolder(holder: CatalogItemViewHolder, position: Int) {
        holder.bind(data[position])
    }
}