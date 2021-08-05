package com.haowen.bare.parse;

import com.haowen.bare.parse.parser.*;

/**
 * 支持的平台
 */
public enum Platform {

    DOU_YIN("抖音", "v.douyin.com", DouYinParser.class),
    KUAI_SHOU("快手", "v.kuaishou.com", KuaiShouParser.class),
    WEI_SHI("微视", "isee.weishi.qq.com", WeiShiParser.class),
    PI_PI_XIA("皮皮虾", "h5.pipix.com", PiPiXiaParser.class),
    PI_PI_GAO_XIAO("皮皮搞笑", "h5.pipigx.com", PiPiGaoXiaoParser.class),
    HUO_SHAN("抖音火山版", "share.huoshan.com", HuoShanParser.class),
    ZUI_YOU("最右", "izuiyou.com", ZuiYouParser.class),
    XI_GUA("西瓜视频", "ixigua.com", XiGuaParser.class),
    QING_SHI_PING("轻视频", "bbq.bilibili.com", QingShiPingParser.class),
    XIN_PIAN_CHANGE("新片场", "www.xinpianchang.com", XinPianChangParser.class),
    WEI_BO("微博", "video.weibo", WeiBoParser.class),
    AC_FUN("AcFun", "m.acfun.cn", AcFunParser.class),
    LI_SHI_PIN("梨视频", "www.pearvideo.com", LiShiPinParser.class),
    LV_ZHOU("绿洲", "oasis.weibo.cn", LvZhouParser.class),
    DOU_PAI("逗拍", "p.doupai.cc", DouPaiParser.class),
    MEI_PAI("美拍", "www.meipai.com", MeiPaiParser.class),
    VUE_VLOG("VUE Vlog", "v.vuevideo.net", VueVlogParser.class),
    BEFORE("Before 避风", "m.hanyuhl.com", BeforeParser.class),
    QUAN_MING_K_GE("全民K歌", "kg3.qq.com", QuanMinKGeParser.class),
    DU_XIAO_SHI("度小视", "xspshare.baidu.com", DuXiaoShiParser.class),
    MIAO_PAI("秒拍", "miaopai.com", MiaoPaiParser.class),
    KAI_YAN("开眼", "eyepetizer.net", KaiYanParser.class),
    MO_MO("陌陌", "immomo.com", MoMoParser.class),
    HU_YA("虎牙", "huya.com", HuYaParser.class),
    HAO_KAN("好看", "haokan.hao123.com", HaoKanParser.class),
    XIAO_HONG_SHU("小红书", "xhslink.com", XiaoHongShuParser.class);

    private final String name;
    private final String domain;
    private final Class<?> parserClass;

    Platform(String name, String domain, Class<?> parserClass) {
        this.name = name;
        this.domain = domain;
        this.parserClass = parserClass;
    }

    public String getName() {
        return name;
    }

    public String getDomain() {
        return domain == null ? "" : domain;
    }

    public Class<?> getParserClass() {
        return parserClass;
    }
}
