package com.example.user.Fragment

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.common.activity.StampCollectionActivity
import com.example.home.Util.GlideEngine
import com.example.user.R
import com.example.user.VM.UserViewModel
import com.example.user.activity.FavoritesActivity
import com.example.user.activity.PersonalInformationActivity
import com.example.user.activity.PlayColletionActivity
import com.example.user.activity.SettingsActivity
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureMimeType
import kotlinx.android.synthetic.main.activity_personal_information.*
import kotlinx.android.synthetic.main.user_fragment.*

class UserFragment : Fragment() {

    companion object {
        fun newInstance() = UserFragment()

        private const val REQUEST_CODE_CHOOSE: Int = 777
    }

    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)



        //点击事件
        head_user_fragment.setOnClickListener { openPhoto()  }
        setting.setOnClickListener {
            val intent = Intent(context,SettingsActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context?.startActivity(intent)
        }
        bt_mylove_user.setOnClickListener {val intent=Intent(context,FavoritesActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context?.startActivity(intent)}
        bt_myplay_user.setOnClickListener { val intent=Intent(context,PlayColletionActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context?.startActivity(intent) }
        bt_mypost_user.setOnClickListener {
            val intent=Intent(context,StampCollectionActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("source","UserFragment")
            context?.startActivity(intent)
        }
        bt_mytool_user.setOnClickListener { Toast.makeText(context,"开发者正在连夜赶制...",Toast.LENGTH_SHORT).show() }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == Activity.RESULT_OK) {
            val results = PictureSelector.obtainMultipleResult(data)
            Glide.with(this).load(results[0].path).into(head_user_fragment)
        }}



    private fun openPhoto() {
        PictureSelector.create(this)
            .openGallery(PictureMimeType.ofImage())
            .imageEngine(GlideEngine.createGlideEngine())
            .isWeChatStyle(false)// 是否开启微信图片选择风格
            .imageSpanCount(3)// 每行显示个数
            .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) // 设置相册Activity方向，不设置默认使用系统
            .isPreviewImage(true)// 是否可预览图片
            .maxSelectNum(1)
            .isMaxSelectEnabledMask(true) // 选择数到了最大阀值列表是否启用蒙层效果
            .forResult(REQUEST_CODE_CHOOSE)
    }

}