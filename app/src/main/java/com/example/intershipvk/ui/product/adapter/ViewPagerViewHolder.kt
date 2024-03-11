package com.example.intershipvk.ui.product.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.intershipvk.databinding.IamgeItemHolderBinding

class ViewPagerViewHolder(val view: IamgeItemHolderBinding):RecyclerView.ViewHolder(view.root) {
    fun bind(url:String){
        Glide.with(view.image)
            .load(url)
            .into(view.image)
    }
}