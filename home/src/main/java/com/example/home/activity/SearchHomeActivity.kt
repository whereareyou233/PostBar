package com.example.home.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.example.home.R
import kotlinx.android.synthetic.main.activity_search_home.*


class SearchHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_home)

        //点击事件

        bt_return_search_home.setOnClickListener { finish()}

        bt_search_home.setOnClickListener {
            if (bt_edit_search.text.toString().isNotEmpty()) {
                Nosearch.visibility=View.GONE
                insearch.visibility=View.VISIBLE

            }
        }
/*
        bt_edit_home.setOnClickListener {
            bt_edit_home.isCursorVisible=true
        }*/

        bt_edit_search.addTextChangedListener {
            if (!it.toString().isNotEmpty())
            {
                Nosearch.visibility=View.VISIBLE
                insearch.visibility=View.GONE
            }
        }
    }
}