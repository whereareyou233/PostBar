package com.example.home.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.common.activity.PostInfoActivity
import com.example.home.R
import kotlinx.android.synthetic.main.activity_search_home.*


class SearchHomeActivity : AppCompatActivity() {
    val postnamelist=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_home)


        //
        postnamelist.add("澳门回归祖国二十周年")
        postnamelist.add("中国人民警察节")
        postnamelist.add("恩格斯诞辰200周年")
        postnamelist.add("北京2022年冬奥会——冰上运动")
        postnamelist.add("中国登山队登顶珠峰六十周年")
        postnamelist.add("精准扶贫")
        postnamelist.add("北京大兴国际机场通航纪念")
        postnamelist.add("鄱阳湖")
        postnamelist.add("春夏秋冬")
        postnamelist.add("梅兰竹菊")
        postnamelist.add("中华人民共和国民法典施行")
        postnamelist.add("中埃建交五十周年")
        postnamelist.add("海外民生工程")
        postnamelist.add("五牛图")
        postnamelist.add("中国人民志愿军抗美援朝出国作战70周年")
        postnamelist.add("查干湖")
        postnamelist.add("中国首次火星探测")
        postnamelist.add("丙申年")
        postnamelist.add("国家图书馆")
        postnamelist.add("《改革开放三十周年》纪念邮票")


        //点击事件

        bt_return_search_home.setOnClickListener { finish() }

        bt_search_home.setOnClickListener {
            if (bt_edit_search.text.toString().isNotEmpty()) {
                Nosearch.visibility = View.GONE
                insearch.visibility = View.VISIBLE
                var m=0
                for (i in postnamelist) {
                    if (bt_edit_search.text.toString() == i) {
                        val intent = Intent(this, PostInfoActivity::class.java)
                        intent.putExtra("post", i)
                        startActivity(intent)
                        m=1
                        break
                    }
                }
                if (m==0){
                    Toast.makeText(this,"很抱歉！未找到该名称邮票",Toast.LENGTH_SHORT).show()
                }
            }
        }
/*
        bt_edit_home.setOnClickListener {
            bt_edit_home.isCursorVisible=true
        }*/

        bt_edit_search.addTextChangedListener {
            if (!it.toString().isNotEmpty()) {
                Nosearch.visibility = View.VISIBLE
                insearch.visibility = View.GONE
            }
        }
    }
}