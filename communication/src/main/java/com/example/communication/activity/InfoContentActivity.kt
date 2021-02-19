package com.example.communication.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.communication.R
import kotlinx.android.synthetic.main.activity_info_content.*

class InfoContentActivity : AppCompatActivity() {

    companion object{
        const val INFO_IMAGE="info_image"
        const val INFO_TEXT ="info_text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_content)

        val Info_text=intent.getStringExtra(INFO_TEXT) ?: " "
        val Info_image=intent.getIntExtra(INFO_IMAGE,0)


        //浸入式状态栏
        val decorView =window.decorView
        decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor= Color.TRANSPARENT
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

        //toolbar
        setSupportActionBar(toolbar_info_content)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar_info_content.title="详情"
        info_text.setText(Info_text)
        image_info_content.setImageResource(Info_image)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}