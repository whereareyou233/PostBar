package com.example.postbar.View

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class viewpager_PostBar : ViewPager {

    constructor(mContext: Context) : super(mContext) {
        val context = mContext
    }
    constructor(mContext: Context, mAttributeSet: AttributeSet) : super(mContext, mAttributeSet) {

        val context = mContext
    }


    //viewpager滑动切换开关
    //开启 返回ture
    //关闭 返回false
  /*  override fun onTouchEvent(arg0: MotionEvent?): Boolean {
        return false
    }

    override fun onInterceptTouchEvent(arg0: MotionEvent?): Boolean {
        return  false
    }*/

}