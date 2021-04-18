package com.example.common.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.common.Bean.postInfoBean
import com.example.common.R
import kotlinx.android.synthetic.main.activity_post_info.*

class PostInfoActivity : AppCompatActivity() {

    val postlist =ArrayList<postInfoBean>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_info)

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        val postid=intent.getStringExtra("post")
post_id.setText(postid)

        //点击事件
        return_info.setOnClickListener { finish() }

        //
        postlist.add(postInfoBean("澳门回归祖国二十周年","",R.drawable.amhg,"邮票第一图“爱国爱澳 薪火相传”，以金光璀璨的盛世莲花雕塑为中心，通过表现澳门各界群众在金莲花广场挥舞国旗、区旗的庆祝场面，在突出喜庆气氛的同时传递出澳门同胞爱国爱澳的精神和与国家同心同德、血脉相连的身份认同感、自豪感。第二图“中西荟萃 和谐共融”，以议事亭前地舞醉龙的场景为中心，背景为大三巴牌坊、妈祖阁、东望洋灯塔、龙环葡韵住宅式博物馆等建筑，展示出澳门多元文化的特征。第三图“城市建设 繁荣发展”，画面以港珠澳大桥为中心，回归后建设的西湾大桥从右侧向内延伸，紧扣澳门回归后的时代脉搏，体现了澳门回归后的城市建设发展。远景表现了澳门大学横琴校区、横琴·澳门青年创业谷，体现出澳门融入国家发展，积极加入区域合作战略，合力推进粤港澳大湾区建设的概念。"))
        postlist.add(postInfoBean("中国人民警察节","",R.drawable.zgrmjcj,"经党中央批准、国务院批复，自2021年起，将每年1月10日设立为“中国人民警察节”，这是在国家层面专门为人民警察队伍设立的节日，是对人民警察队伍为党和人民利益英勇奋斗的充分肯定。"))
        postlist.add(postInfoBean("恩格斯诞辰200周年","",R.drawable.mksdc,"该套邮票采用素描表现方式，第一图展现了青年恩格斯半身像，背景为恩格斯故居；第二图展现了工作中的晚年恩格斯形象，背景为带有马克思、恩格斯头像的《共产党宣言》中文版封面和《资本论》中文版封面。"))
        postlist.add(postInfoBean("北京2022年冬奥会——冰上运动","",R.drawable.bsyd,"该套邮票由张强设计，边饰设计为张强、陈翊君，邮票采用电脑手绘的表现方式，展现了运动员在冰上的飒爽英姿和精彩瞬间。整体画面色彩鲜明饱满、线条简洁流畅，运动员造型富有张力、充满动感，体现了各项运动的灵动与技巧之美，速度与力量之美。画面背景搭配北京2022年冬奥会核心图形，5枚邮票衔接紧密，视觉效果自然流畅，营造出喜迎北京2022年冬奥盛会的热烈氛围。"))
        postlist.add(postInfoBean("中国登山队登顶珠峰六十周年","",R.drawable.zmlmf,"《中国登山队登顶珠峰六十周年》纪念邮票主体以插画的形式表现，画面以雄伟的珠穆朗玛峰为背景，前景表现我国登山队员克服艰难险阻向珠峰挺进的情景，画面中还设计了国旗元素，整体画面磅礴大气，色彩丰富，富有时代特征，充分展示出中国登山队勇攀高峰的拼搏精神，展现了人类第一次从珠峰北坡成功登顶珠峰的伟大壮举。"))
        postlist.add(postInfoBean("精准扶贫","",R.drawable.jzfp,"邮票第一图“大步迈向小康社会”，展现了义务教育有保障和健康扶贫的相关内容，烘托全国人民在习近平新时代中国特色社会主义思想指引下大步迈向小康社会的主题；第二图“福建宁德市赤溪村”，展现了一幅生态美，百姓富的美丽画卷；第三图“湖南花垣县十八洞村”，展现了湘西苗寨的新面貌和新气象；第四图“宁夏永宁县闽宁镇”，展现了闽宁美丽乡村全面发展，从“干沙滩”变为“金沙滩”翻天覆地的变化；第五图“河南兰考县”用精准生动的笔触描绘出兰考历史性跨越和巨变；第六图“江西井冈山市”，描绘了革命摇篮井冈山脱贫发展的新画卷。"))
        postlist.add(postInfoBean("北京大兴国际机场通航纪念","",R.drawable.bjdxgjjcth,"该套邮票采用主附票的设计形式，构图饱满，充满张力。邮票以机场航站楼的外形作为画面主体，完整展现了呈放射形的五条指廊，充分体现出大兴国际机场空间延展性强的特征，具有较强的视觉辨识度；附票以航站楼剖面图为主体，直观展示出航站楼内部复杂的空间结构，同时通过表现轨道交通、公路交通，体现了北京大兴国际机场新型国际化立体综合交通枢纽的定位。"))
        postlist.add(postInfoBean("鄱阳湖","",R.drawable.pyh,"该套邮票采用国画的方法来表现鄱阳湖气韵悠远的山水美景。石钟奇音，表现鄱阳湖与长江交汇处的石钟山的湖光山色，石钟山因北宋苏轼的散文《石钟山记》而闻名天下；鞋山神韵，表现鄱阳湖上众多岛屿之一、拥有悠久历史人文景观的鞋山岛（又称大孤山）；湿地奇观，表现鄱阳湖国家湿地公园的自然景观以及最主要的珍稀候鸟——东方白鹳、天鹅、白鹤等。"))
        postlist.add(postInfoBean("春夏秋冬","",R.drawable.cxqd,"邮票的第一图表现了春天的景色。微风和煦、两岸柳扬，有一群孩童在放风筝，春燕往来穿梭，充满了繁荣生机。第二图表现了夏天的景色。孩子们摇着小船穿梭在荷花荡中，有的顶着荷叶帽，有的摆弄着手中莲花，一片欣欣向荣的蓬勃景象。第三图表现了秋天的景色。云高万里，遍布金黄色调。孩童们忙着收稻谷，人们脸上满是喜悦，描绘了一片丰收的景象。第四图表现了冬天的景色。飘雪漫天，梅红绽放。女孩儿在忙着贴福字，还有孩童蹲在地上点燃鞭炮，给新的一年讨个好彩头，一派喜庆祥和的景象。"))
        postlist.add(postInfoBean("梅兰竹菊","",R.drawable.mlzj,"《梅兰竹菊》特种邮票以经典的诗词和绘画为主要表现形式。梅兰竹菊，占尽春夏秋冬。梅高洁傲岸，兰幽雅空灵，竹虚心有节，菊冷艳清贞。“梅”邮票主图选自清代“扬州八怪”画家金农的《画梅花册》，此画现藏于北京故宫博物院，金农尤精画梅，格调拙厚淳朴，树姿苍劲，暗香浮动，独占春光。“兰”邮票主图选用巢勋在上海有正书局以石印法影印出版的《芥子园画谱》，返璞归真，朴实无华，秀丽多姿，叶态优美，王者风范。“竹”邮票主图选自“扬州八怪”郑板桥的《兰竹图册》。郑板桥晚年以扬州为中心，以卖字画为生。郑板桥一生画竹最多，邮票上的“竹”，以草书中竖长撇法运笔，体貌疏朗，风格劲峭，潇洒秀丽，诗情画意。“菊”邮票主图选自“扬州八怪”画家李鱓的《菊石图》，现藏于北京炎黄艺术馆（朝阳区安定门外亚运村惠中路9号）。此画落笔有气势，设色清雅，有“水墨融成奇趣”的特色。整套邮票既雅致细腻，又展现了中国传统文化的深厚意蕴，堪称精品。"))
        postlist.add(postInfoBean("中华人民共和国民法典施行","",R.drawable.zhrmghgmfd,"2020年5月28日，中华人民共和国第十三届全国人民代表大会第三次会议表决通过了《中华人民共和国民法典》。这是新时代我国社会主义法治建设的重大成果。民法是民事领域的基础性、综合性法律。这部法律通过对我国现行的民事法律制度规范进行系统整合、编订纂修，形成了一部适应新时代中国特色社会主义发展要求，符合我国国情和实际，体例科学、结构严谨、规范合理、内容完整并协调一致的法典。\n"))
        postlist.add(postInfoBean("中埃建交五十周年","",R.drawable.zajj,"纪念中国与被誉为“非洲屋脊”的埃塞尔比亚建交五十周年"))
        postlist.add(postInfoBean("海外民生工程","",R.drawable.hwmsgc,"该套邮票画面采用电脑手绘的表现方式，画面清新优美、色调鲜艳明快。第一图“领事便民服务”，表现了“12308”海外民生热线，体现外交部致力于为海外中国公民提供“指尖上”的领事服务，在海外游子与祖国亲人之间起到的重要纽带作用；第二图“领事保护日常协助”，表现了驻外外交、领事机构为海外中国公民提供证件办理等服务和维护海外中国公民、法人安全及正当权益的内容，体现出领事保护和日常协助的概念；第三图“祖国在你身后”，表现了中国公民得到驻外使领馆协助后的团圆场景，体现出“祖国在你身后”的温度和爱国情怀。这三枚邮票画面左侧统一表现了外交部大楼、和平鸽和“外交为民”字样。"))
        postlist.add(postInfoBean("五牛图","",R.drawable.wnt,"《五牛图》以并列平铺法布局五头各具姿态的牛。五牛既以独立的个体呈现，相互之间又形成呼应关系，是幅构图巧妙的唐画佳作。韩滉依据牛的不同部位采用了相应的笔法，以粗放、凝重而略显滞拙的线条勾画牛的形体和筋骨，以工细精准的笔触描绘牛的头部，以纤毫毕现的笔墨刻画牛口鼻处的细毛，由此可见韩滉写实求真的审美意趣。在造型方面，韩滉则展示出其敏锐的观察力和高超的技法表现力，无论是塑造正面、侧面、俯首或者回首的牛，均形体比例准确，透视关系合理。该画作表明我国畜兽画到唐代已达到了较高的艺术水平，也为研究唐代耕牛提供了难得的形象资料。"))
        postlist.add(postInfoBean("中国人民志愿军抗美援朝出国作战70周年","",R.drawable.zgrmzyj,"《中国人民志愿军抗美援朝出国作战70周年》是中国邮政为了纪念中国人民志愿军抗美援朝出国作战70周年，于2020年10月25日发行的纪念邮票。"))
        postlist.add(postInfoBean("查干湖","",R.drawable.cgh,"第一枚“圣湖如画”，画面表现了秋季查干湖碧波荡漾、芦苇摇曳、水鸟翔集的静谧壮美的景色。远处为查干湖畔的引松工程纪念碑。第二枚“渔村冬景”，画面表现了冬季查干湖畔为冬捕做准备忙碌的渔民身影。白雪皑皑的大地、高挂的雾凇、乡村屋舍和渔民共同构成了查干湖特有的渔猎生活景象。第三枚“冰湖腾鱼”，画面表现了冬捕开网后，冰封的湖面上人头攒动，一片热闹景象。近处鱼跃而出、湖面沸腾，远处高头大马拉动绞盘，呈现出一幅鱼跃人欢冬捕忙的丰收景象。"))
        postlist.add(postInfoBean("中国首次火星探测“天问一号”发射成功","",R.drawable.twyh,"纪念中国首次火星探测“天问一号”发射成功"))
        postlist.add(postInfoBean("丙申年","",R.drawable.bsn,"第一枚“灵猴献瑞”采用了金色、黑色和红色三种色彩表现。画中，公猴子的一只手抓在树枝上，尾巴缠在桃树上，另一只手捧着桃子，意寓“捧桃献瑞”的概念。第二枚“福寿双至”，图案是双手怀抱两只猴宝宝的一只母猴，画面温馨生动感人，寄托着新的一年阖家团圆、福寿双至的美好祝愿。"))
        postlist.add(postInfoBean("国家图书馆","",R.drawable.gjtsg,"为庆祝国家图书馆建馆百年，中国邮政于2009年9月9日发行《国家图书馆》特种邮票1套2枚。"))
        postlist.add(postInfoBean("《改革开放三十周年》纪念邮票","",R.drawable.ggkf,"为纪念改革开放三十周年"))


        for (i in postlist){
            if (i.name==postid){
                post_image.setImageResource(i.image)
                post_content.text=i.content
                break
            }
        }
    }
}