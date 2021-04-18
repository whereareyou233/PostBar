package com.example.home.activity

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Dialog
import android.content.Intent
import android.graphics.Interpolator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import com.example.common.activity.AddNewActivity
import com.example.common.activity.StampCollectionActivity
import com.example.home.R
import kotlinx.android.synthetic.main.activity_add_select.*

import kotlinx.android.synthetic.main.dialog_newpost.*


class AddSelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_select)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

        //点击事件
        bt_return_add.setOnClickListener { finish()}
        add_new.setOnClickListener { val intent=Intent(this,AddNewActivity::class.java)
        startActivity(intent)}
        bt_old.setOnClickListener{
            val intent = Intent(this,StampCollectionActivity::class.java)
            intent.putExtra("source","AddSelectActivity")
            startActivity(intent)
        }

    }

   /* private fun shownewpost(){
        val dialog = Dialog(this, R.style.DialogTheme)//设置style
        val view= View.inflate(this, R.layout.dialog_newpost, null)//设置布局
        dialog.setContentView(view)

        val window =dialog.window
        window?.setGravity(Gravity.CENTER) //设置弹出位置
        window?.setWindowAnimations(R.style.main_menu_animStyle)//设置弹出动画
        window?.setLayout(800, ViewGroup.LayoutParams.WRAP_CONTENT)//设置弹出框大小
        dialog.show()
        dialog.cancel.setOnClickListener {  dialog.dismiss()}
        dialog.define.setOnClickListener {
            dialog.dismiss()}
    }*/
}