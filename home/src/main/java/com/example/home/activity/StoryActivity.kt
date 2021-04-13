package com.example.home.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.home.R
import com.example.home.adapter.StoryContent
import com.example.home.adapter.StoryHorizontalContent
import com.example.home.model.StoryInfo
import kotlinx.android.synthetic.main.activity_story.*
import kotlinx.android.synthetic.main.home_fragment.*

class StoryActivity : AppCompatActivity() {

    val storylist=ArrayList<StoryInfo>()
    val storylist2=ArrayList<StoryInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

//初始化list
        storylist.add(StoryInfo(R.drawable.sucaih,"一切灵感都来于自然",""))
        storylist.add(StoryInfo(R.drawable.sucaih2,"晚间的港口总是能给人带来慰籍",""))

        storylist2.add(StoryInfo(R.drawable.p0001,"战争胜利","“中国人民抗日战争的伟大胜利，彻底粉碎了日本军国主义殖民奴役中国的图谋，有力捍卫了国家主权和领土完整，彻底洗刷了近代以来抗击外来侵略屡战屡败的民族耻辱！”抗战胜利具有伟大意义，14年不屈不挠浴血奋战，是近代以来中国人民反抗外敌入侵持续时间最长、规模最大、牺牲最多的民族解放斗争，第一次取得了民族解放斗争的完全胜利，从此再也没有侵略者敢在中国土地上横行霸道，为非作歹。从此，中国人民结束了受人奴役与宰割的屈辱历史，走上了自己掌握自己历史的独立发展道路，使我们民族在精神上站立起来了。"))
        storylist2.add(StoryInfo(R.drawable.p0002,"国家图书馆","为庆祝国家图书馆建馆百年，中国邮政于2009年9月9日发行《国家图书馆》特种邮票1套2枚。"))
        storylist2.add(StoryInfo(R.drawable.p0003,"中国火星探测","纪念中国首次火星探测“天问一号”发射成功"))
        storylist2.add(StoryInfo(R.drawable.p0004,"鄱阳湖","该套邮票采用国画的方法来表现鄱阳湖气韵悠远的山水美景。石钟奇音，表现鄱阳湖与长江交汇处的石钟山的湖光山色，石钟山因北宋苏轼的散文《石钟山记》而闻名天下；鞋山神韵，表现鄱阳湖上众多岛屿之一、拥有悠久历史人文景观的鞋山岛（又称大孤山）；湿地奇观，表现鄱阳湖国家湿地公园的自然景观以及最主要的珍稀候鸟——东方白鹳、天鹅、白鹤等。"))
        storylist2.add(StoryInfo(R.drawable.p0005,"五牛图","《五牛图》以并列平铺法布局五头各具姿态的牛。五牛既以独立的个体呈现，相互之间又形成呼应关系，是幅构图巧妙的唐画佳作。韩滉依据牛的不同部位采用了相应的笔法，以粗放、凝重而略显滞拙的线条勾画牛的形体和筋骨，以工细精准的笔触描绘牛的头部，以纤毫毕现的笔墨刻画牛口鼻处的细毛，由此可见韩滉写实求真的审美意趣。在造型方面，韩滉则展示出其敏锐的观察力和高超的技法表现力，无论是塑造正面、侧面、俯首或者回首的牛，均形体比例准确，透视关系合理。该画作表明我国畜兽画到唐代已达到了较高的艺术水平，也为研究唐代耕牛提供了难得的形象资料。"))
        storylist2.add(StoryInfo(R.drawable.p0006,"澳门回归","邮票第一图“爱国爱澳 薪火相传”，以金光璀璨的盛世莲花雕塑为中心，通过表现澳门各界群众在金莲花广场挥舞国旗、区旗的庆祝场面，在突出喜庆气氛的同时传递出澳门同胞爱国爱澳的精神和与国家同心同德、血脉相连的身份认同感、自豪感。第二图“中西荟萃 和谐共融”，以议事亭前地舞醉龙的场景为中心，背景为大三巴牌坊、妈祖阁、东望洋灯塔、龙环葡韵住宅式博物馆等建筑，展示出澳门多元文化的特征。第三图“城市建设 繁荣发展”，画面以港珠澳大桥为中心，回归后建设的西湾大桥从右侧向内延伸，紧扣澳门回归后的时代脉搏，体现了澳门回归后的城市建设发展。远景表现了澳门大学横琴校区、横琴·澳门青年创业谷，体现出澳门融入国家发展，积极加入区域合作战略，合力推进粤港澳大湾区建设的概念。"))

        //点击事件

        bt_return_story.setOnClickListener { finish() }


        //设置横向recyclerview
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation=LinearLayoutManager.HORIZONTAL
        recyclerview_home_story.layoutManager=layoutManager
        val adapter=StoryHorizontalContent(this,storylist)
        recyclerview_home_story.adapter=adapter

        //设置竖排recyclerview
        val layoutManager2=GridLayoutManager(this,2)
        recyclerview_home_story_2.layoutManager=layoutManager2
        val adapter2 = StoryContent(this,storylist2)
        recyclerview_home_story_2.adapter=adapter2

    }
}