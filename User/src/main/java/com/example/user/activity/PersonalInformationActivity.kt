package com.example.user.activity

import android.app.Dialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import com.example.user.R
import kotlinx.android.synthetic.main.activity_personal_information.*
import kotlinx.android.synthetic.main.dialog_name_user.*
import kotlinx.android.synthetic.main.dialog_signature_user.*

class PersonalInformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_information)

        //设置浸入式状态栏
        val decorView =window.decorView
        decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor= Color.TRANSPARENT
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

        //点击事件
        bt_return_information.setOnClickListener { finish() }
        bt_name.setOnClickListener { showdialogname() }
        bt_signature.setOnClickListener { showdialogsignature() }
    }


    private fun showdialogname(){
        val dialog = Dialog(this, R.style.DialogTheme)//设置style
        val view=View.inflate(this, R.layout.dialog_name_user, null)//设置布局
        dialog.setContentView(view)

        val window =dialog.window
        window?.setGravity(Gravity.CENTER) //设置弹出位置
        window?.setWindowAnimations(R.style.main_menu_animStyle)//设置弹出动画
        window?.setLayout(800, ViewGroup.LayoutParams.WRAP_CONTENT)//设置弹出框大小
        dialog.show()
        dialog.cancel_name.setOnClickListener { dialog.dismiss()  }
        dialog.confirm_name.setOnClickListener { name_user.setText(dialog?.edit_name.text.toString())
        dialog.dismiss()}

    }

    private fun showdialogsignature(){
        val dialog = Dialog(this, R.style.DialogTheme)//设置style
        val view=View.inflate(this, R.layout.dialog_signature_user, null)//设置布局
        dialog.setContentView(view)

        val window =dialog.window
        window?.setGravity(Gravity.CENTER) //设置弹出位置
        window?.setWindowAnimations(R.style.main_menu_animStyle)//设置弹出动画
        window?.setLayout(800, ViewGroup.LayoutParams.WRAP_CONTENT)//设置弹出框大小
        dialog.show()
        dialog.cancel_signature.setOnClickListener { dialog.dismiss()  }
        dialog.confirm_signature.setOnClickListener { signature_user.setText(dialog?.edit_signature.text.toString())
            dialog.dismiss()}

    }

}