package com.example.postbar.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.communication.Fragment.CommunicationFragment
import com.example.home.Fragment.HomeFragment
import com.example.postbar.Adapter.FragmentAdapter
import com.example.postbar.R
import com.example.user.Fragment.UserFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val userFragment: Fragment by lazy {
        UserFragment()
    }
    private val communityFragment: Fragment by lazy {
        CommunicationFragment()
    }
    private val homeFragment: Fragment by lazy {
        HomeFragment()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //设置浸入式状态栏
        val decorView =window.decorView
        decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor= Color.TRANSPARENT
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

        //设置viewpager
        val fragments = mutableListOf<Fragment>()
        fragments.add(homeFragment)
        fragments.add(communityFragment)
        fragments.add(userFragment)


        val fragmentAdapter = FragmentAdapter(
                fragments,
                supportFragmentManager
        )
        viewpager_pb.adapter = fragmentAdapter

        buttom_home.setOnNavigationItemSelectedListener {
                    when(it.itemId) {
                        R.id.home_postbar -> viewpager_pb.currentItem=0
                        R.id.community_postbar ->viewpager_pb.currentItem=1
                        R.id.user_postbar ->viewpager_pb.currentItem=2
                    }
                    false
                }

        //viewpager的滑动监控   当fragment改变时下方导航栏ui的改变
viewpager_pb.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
    override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
    ) {

    }

    override fun onPageSelected(position: Int) {
       buttom_home.menu.getItem(position).isChecked=true
    }

    override fun onPageScrollStateChanged(state: Int) {

    }
})

        //
    }

}