package com.example.communication.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.communication.R
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        //浸入式状态栏
        val decorView =window.decorView
        decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor= Color.TRANSPARENT
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

        //点击事件设置
        bt_return.setOnClickListener { finish() }

        bt_search.setOnClickListener {
            if (search_content.text.toString().isNotEmpty())
            {
                recycler_search.visibility=View.VISIBLE
                Toast.makeText(this,"搜索的内容不存在！",Toast.LENGTH_SHORT).show()
            }
        }

        //监听搜索框是否有输入
        search_content.addTextChangedListener { text: Editable? ->
            if (!text.toString().isNotEmpty())
            {
                recycler_search.visibility=View.GONE
            }
        }



    }
}