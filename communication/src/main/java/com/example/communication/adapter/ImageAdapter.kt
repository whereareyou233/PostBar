package com.example.communication.adapter

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.youth.banner.adapter.BannerAdapter


class ImageAdapter(mList: List<Int>) :BannerAdapter<Int, ImageAdapter.BannerViewHolder>(mList) {

    override fun onCreateHolder(parent: ViewGroup, viewType: Int): BannerViewHolder? {
        val imageView = ImageView(parent.context)
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return BannerViewHolder(imageView)
    }
    override fun onBindView(holder: BannerViewHolder, data: Int, position: Int, size: Int) {
        holder.imageView.setImageResource(data)
    }
    class BannerViewHolder(var imageView: ImageView) :
        RecyclerView.ViewHolder(imageView)
}