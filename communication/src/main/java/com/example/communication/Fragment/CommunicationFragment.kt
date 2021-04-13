
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


        /*InfoListTwo.add(RealTimeInfo(R.drawable.sucai,"Today is a good day"))
        InfoListTwo.add(RealTimeInfo(R.drawable.sucai1,"Today is a good day"))
        InfoListTwo.add(RealTimeInfo(R.drawable.sucai2,"Today is a good day"))
        InfoListTwo.add(RealTimeInfo(R.drawable.sucai3,"Today is a good day"))*/

        InfoList.add(RealTimeInfo(R.drawable.p00000,"万里长城","  长城是古代中国在不同时期为抵御塞北游牧部落联盟侵袭而修筑的规模浩大的军事工程的统称。长城东西绵延上万华里，因此又称作万里长城。现存的长城遗迹主要为始建于14世纪的明长城，西起嘉峪关，东至辽东虎山，全长8851.8公里，平均高6至7米、宽4至5米。长城是我国古代劳动人民创造的伟大的奇迹，是中国悠久历史的见证。它与天安门，兵马俑一起被世人视为中国的象征长城是古代中国在不同时期为抵御塞北游牧部落联盟侵袭而修筑的规模浩大的军事工程的统称。长城东西绵延上万华里，因此又称作万里长城。现存的长城遗迹主要为始建于14世纪的明长城，西起嘉峪关，东至辽东虎山，全长8851.8公里，平均高6至7米、宽4至5米。长城是我国古代劳动人民创造的伟大的奇迹，是中国悠久历史的见证。它与天安门，兵马俑一起被世人视为中国的象征\"\n"))
        InfoList.add(RealTimeInfo(R.drawable.sucai3,"一个邮票收藏的小据点","这是由一些邮票爱好者一起发起的活动，由这些爱好者们一起出钱修建了这样的小屋，用来存储他们最金贵的邮票"))
        InfoList.add(RealTimeInfo(R.drawable.test0,"邮票简介","邮票是邮政机关发行，供寄递邮件贴用的邮资凭证。发送者为邮政服务付费的一种形式。发送者会将邮票贴在信件上，再由邮局盖章（通常是邮戳）销值，以用于在邮件被寄出前，证明寄邮人已支付全部或部分传递费用。为方便使用，邮票四周一般会打上齿孔，背面则加上一层背胶。世界上的第一枚邮票是英国的黑便士。邮票发行由国家管理，通常是国家主权的象征，甚至是某些国家重要的财源，如列支敦士登。邮票是收藏品，集邮已经成为世界重要风潮之一。"))
        InfoList.add(RealTimeInfo(R.drawable.test18,"邮票记录下的庐山","庐山，又称匡山、匡庐，位于中国江西省九江市南郊，是联合国教科文组织评定的文化遗产和世界地质公园，同时还是中国国家5A级旅游景区和文明旅游风景区、世界名山大会的发起者。庐山形成于第四纪冰川时期，是一座地垒式断块山脉[1]，是中国自古以来重要的游览目的地。"))
        InfoList.add(RealTimeInfo(R.drawable.sucai2,"一次平常的英国邮局之行为一名幸运的集邮者开启了一场改变人生的奇遇","1967年，一位邮票发烧友到英国北部小镇罗奇代尔（Rochdale）的一个地方邮局购买两张大不列颠邮票。他花了一先令九便士（不到10美分），买了两张纪念电视发明和带有伊丽莎白二世剪影的邮票。\n" +
                "\n" +
                "他后来才发现，其中一张邮票上缺了女王的头像。后来证明这是一笔幸运的买卖。2014年，他拍卖了这张被称为“SG 755b”的邮票，成交价为23600英镑（即36260美元）。\n" +
                "\n" +
                "虽然近些年来电子邮件的到来打击了邮政服务，但是在很多国家，集邮仍然是一种爱好和有价值的商业和投资策略。自从1840年全世界第一枚带背胶的邮票英国黑便士（Penny Black）首次发行以来，世界发行了数以十亿计的邮票，其中很多邮票都与浪漫和传说有关——把集邮者带往充满异域风情的远方和历史的重要时刻，其中一些人还盼望着借此获得遥不可及的财富。"))
        InfoList.add(RealTimeInfo(R.drawable.sucai,"集邮的花费","就稀有邮票而言，一分钱一分货。根据英国Warwick & Warwick公司的邮票估值师兼美国苏富比拍卖行（Sotheby）顾问约瑟夫·科特里尔（Joseph Cottriall）的说法，尽管邮票的定价没有固定的规则，然而在拍卖会上，集邮者的预期应该是商品目录价格的40%到50%。商品目录价格是伦敦的Stanley Gibbons、美国的Scott、德语圈的Michel和法国的Yvert et Tellier等公司出版的业界权威出版物中列出的价格。\n" +
                "\n" +
                "在决定你的出价之前，先要判断邮票的稀有程度。最吸引全世界集邮者的是错版邮票（比如缺了女王头像的英国电视纪念邮票），不过因为政治或历史原因，也有一些邮票变得十分稀有。有时，如果一枚邮票贴在一封特别的信件上——比如能反映战争历史的信——那这枚邮票的价格就能提高几百美元。\n" +
                "\n" +
                "科特里尔所见过的最有价值的邮票是倒置的珍妮（inverted Jenny）。那是1918年发行的美国邮票，图案是一架老式的双翼飞机，周围是红色的老式边框。它看起来和别的古董邮票没有差别，不过你很快就会发现名为珍妮的飞机上下颠倒了。印刷机印出了一百张这样的错版邮票，如今一张至少价值10万美元，具体价格视保存状况而定。\n" +
                "\n" +
                "“我用放大镜仔细看，然后惊叹道，‘哇，这值一栋房子啊！’” 科特里尔回忆道。\n" +
                "\n" +
                "品质十分重要。总体来说，新邮票（从邮局直接买来的）比用过的邮票更值钱。新邮票的保存状况要求没有破损、折痕、污损，背面的胶纸也必须完好污损（用来保护背胶的纸）。即使是价值只有几美元的邮票，如果它是市场上这个图案保存状况最好的邮票，那它的价值可能会增加几百美元。\n" +
                "\n" +
                "邮票应存放在高品质的相册或存货簿中。它们的价格通常在75美元到150美元。“不带合页”的相册被认为是最安全的，因为这种相册带有塑料套，不需要把邮票粘上去，因为那样可能会损坏邮票的背面。集邮册应存放在阴凉处，防止过冷、过热或者过于潮湿的地方。"))
        InfoList.add(RealTimeInfo(R.drawable.sucai5,"找什么样的邮票","年代较早的邮票通常比现代的邮票更值钱，萨勒诺说。国家为了宣传和经济考量而发行的大多数套装特种邮票和纪念邮票都没有什么价值，因为发行量太大。\n" +
                "\n" +
                "“在英格兰，过去45年间发行的几乎所有邮票都已经跌到面值的60%，”他说。\n" +
                "\n" +
                "在政治和集邮者兴趣的影响下，在十年或二十年的时间里，邮票的价值也可能会发生巨大的变化。以中国为例，20世纪60年代，几乎没有人想要从这个社会主义国家购买邮票。但是如今，一版1962年梅兰芳舞台艺术的邮票价值约为15000美元。\n" +
                "\n" +
                "邮票在中国、香港、日本和印度都有旺盛的需求，反映了亚洲地区集邮兴趣不断增长的势头。而与此相反，西欧的邮票价格正在下滑，因为过去60年里购买了瑞士、德国、意大利的邮票的集邮者正在大量出售这些邮票，使得市场上充斥了这类邮票。不过，这些国家的经典邮票仍然有价值。而英国、英联邦国家和美国的邮票仍然比较保值，因为很多人一直在收集这些国家的邮票。"))


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