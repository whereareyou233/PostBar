package com.example.home.Fragment

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.home.VM.HomeViewModel
import com.example.home.R
import com.example.home.Util.GlideEngine
import com.example.home.activity.MaterialActivity
import com.example.home.activity.PlayActivity
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureMimeType
import kotlinx.android.synthetic.main.home_fragment.*
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.FileInputStream

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()

        private const val REQUEST_CODE_CHOOSE: Int = 999
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel


        //点击事件
        bt_openphoto.setOnClickListener { openPhoto() }
        bt_play.setOnClickListener {
            val intent = Intent(context, PlayActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context?.startActivity(intent)
        }
            bt_material.setOnClickListener {
                val intent=Intent(context, MaterialActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context?.startActivity(intent)
            }

    }

    //结果回调
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == Activity.RESULT_OK) {
            val results = PictureSelector.obtainMultipleResult(data)

            //将图片转化为base64
              val bitmap =getBitmapFromUrl(Uri.parse(results[0].path))
                val  os= ByteArrayOutputStream()
                bitmap?.compress(Bitmap.CompressFormat.PNG,100,os)
                val byte =os.toByteArray()
                val base=Base64.encodeToString(byte,Base64.DEFAULT)


            //将base64转化为图片
/*
            val deode=Base64.decode(base,Base64.DEFAULT)
            val bitmap2=BitmapFactory.decodeByteArray(deode,0,deode.size)
            tp1.setImageBitmap(bitmap2)*/


        }
    }




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

    private fun getBitmapFromUrl(uri: Uri) =this.getActivity()!!.contentResolver.openAssetFileDescriptor(uri, "r")?.use {
        BitmapFactory.decodeFileDescriptor(it.fileDescriptor)
    }

}


