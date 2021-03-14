
package com.example.communication.Fragment



import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.communication.VM.CommunicationViewModel
import com.example.communication.R
import com.example.communication.activity.InfoContentActivity
import com.example.communication.activity.SearchActivity
import com.example.communication.adapter.ImageAdapter
import com.example.communication.adapter.RecyclerviewCommunity
import com.example.communication.adapter.RecyclerviewTow
import com.example.communication.model.RealTimeInfo
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.communication_fragment.*

class CommunicationFragment : Fragment() {
    val InfoList=ArrayList<RealTimeInfo>()
    val ImageList =ArrayList<Int>()
    val InfoListTwo =ArrayList<RealTimeInfo>()

    companion object {
        fun newInstance() = CommunicationFragment()
    }

    private lateinit var viewModel: CommunicationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.communication_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CommunicationViewModel::class.java)


        ImageList.add(R.drawable.test15)
        ImageList.add(R.drawable.test16)
        ImageList.add(R.drawable.test17)
        ImageList.add(R.drawable.test18)


        InfoListTwo.add(RealTimeInfo(R.drawable.sucai,"Today is a good day"))
        InfoListTwo.add(RealTimeInfo(R.drawable.sucai1,"Today is a good day"))
        InfoListTwo.add(RealTimeInfo(R.drawable.sucai2,"Today is a good day"))
        InfoListTwo.add(RealTimeInfo(R.drawable.sucai3,"Today is a good day"))

        InfoList.add(RealTimeInfo(R.drawable.sucai1,"  长城是古代中国在不同时期为抵御塞北游牧部落联盟侵袭而修筑的规模浩大的军事工程的统称。长城东西绵延上万华里，因此又称作万里长城。现存的长城遗迹主要为始建于14世纪的明长城，西起嘉峪关，东至辽东虎山，全长8851.8公里，平均高6至7米、宽4至5米。长城是我国古代劳动人民创造的伟大的奇迹，是中国悠久历史的见证。它与天安门，兵马俑一起被世人视为中国的象征长城是古代中国在不同时期为抵御塞北游牧部落联盟侵袭而修筑的规模浩大的军事工程的统称。长城东西绵延上万华里，因此又称作万里长城。现存的长城遗迹主要为始建于14世纪的明长城，西起嘉峪关，东至辽东虎山，全长8851.8公里，平均高6至7米、宽4至5米。长城是我国古代劳动人民创造的伟大的奇迹，是中国悠久历史的见证。它与天安门，兵马俑一起被世人视为中国的象征\"\n"))
        InfoList.add(RealTimeInfo(R.drawable.sucai3,"邮票从清朝发行至今，无论是从哪一方面都是独一无二的"))
        InfoList.add(RealTimeInfo(R.drawable.test0,"邮票从清朝发行至今，无论是从哪一方面都是独一无二的"))
        InfoList.add(RealTimeInfo(R.drawable.test18,"邮票从清朝发行至今，无论是从哪一方面都是独一无二的"))
        InfoList.add(RealTimeInfo(R.drawable.sucai2,"邮票从清朝发行至今，无论是从哪一方面都是独一无二的"))
        InfoList.add(RealTimeInfo(R.drawable.sucai,"邮票从清朝发行至今，无论是从哪一方面都是独一无二的"))
        InfoList.add(RealTimeInfo(R.drawable.sucai5,"邮票从清朝发行至今，无论是从哪一方面都是独一无二的"))


/*
        //设置轮播图

          banner.addBannerLifecycleObserver(this)//添加生命周期观察者
                        .setAdapter(ImageAdapter(ImageList))
              .setBannerGalleryEffect(60,60,15)     //画廊效果
                        .setIndicator( CircleIndicator(context));      //设置指示器*/

/*
        //设置横向Recyclerview
        val layoutManagerTow =LinearLayoutManager(context)
        layoutManagerTow.orientation=LinearLayoutManager.HORIZONTAL
        recyclerview_community_tow.layoutManager=layoutManagerTow
        val adaptertow= context?.let { RecyclerviewTow(it,InfoListTwo)}
        recyclerview_community_tow.adapter=adaptertow*/


        //设置推荐Recyclerview
        val layoutManager =StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        recyclerview_community.layoutManager=layoutManager
        val adapter= context?.let { RecyclerviewCommunity(it,InfoList) }
        recyclerview_community.adapter=adapter


        //设置点击事件
        search_community.setOnClickListener {
            val intent=Intent(context,SearchActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context?.startActivity(intent)
        }

    }

}