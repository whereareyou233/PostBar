package com.example.postbar.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

open class FragmentAdapter(list: MutableList<Fragment>, fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    val mFragments:  MutableList<Fragment> = list
    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getItem(position: Int): Fragment {
        return mFragments.get(position)
    }
}