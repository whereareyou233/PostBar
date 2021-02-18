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

    override fun onTouchEvent(arg0: MotionEvent?): Boolean {
        return false
    }

    override fun onInterceptTouchEvent(arg0: MotionEvent?): Boolean {
        return  false
    }

}