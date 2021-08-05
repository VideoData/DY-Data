package com.haowen.bare;

import com.haowen.bare.parse.Platform;
import com.haowen.bare.result.BareResult;
import com.haowen.bare.service.BareService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class BareApplicationTests {

    @Resource
    private BareService bareService;

    @Test
    void contextLoads() {

    }

    /**
     * 解析校验
     *
     * @param platform 平台
     * @param link     复制链接
     */
    private void parse(Platform platform, String link) throws Exception {
        BareResult result = bareService.parse(link);
        log.info("===========================================================================================");
        log.info("{}：{}", platform.getName(), result.toString());
        log.info("===========================================================================================");
        assert result.getVideos() != null || result.getImages() != null;
        assert result.getVideos() == null || result.getVideos().get(0).getUrl() != null;
    }

    /**
     * AcFun
     */
    @Test
    void acFunTest() throws Exception {
        parse(Platform.AC_FUN, "https://m.acfun.cn/v/?ac=17351705&sid=3d4bfa049a81667f");
    }

    /**
     * before避风
     */
    @Test
    void beforeTest() throws Exception {
        parse(Platform.BEFORE, "https://m.hanyuhl.com/detail/64678085?shareId=763440260");
    }

    /**
     * 逗拍
     */
    @Test
    void douPaiTest() throws Exception {
        parse(Platform.DOU_PAI, "我想到没人认识的地方，在那里酩酊大醉一场！\n" +
                "可以添加一张照片。 星河影视的逗拍视频模板，你也去做一个这个视频吧！https://p.doupai.cc/modules/topic/?id=60fa63223ed358003e2ec270&utm_source=topic-H5&utm_medium=doupaiapp-H5-fenxiang&utm_term=shareH5&utm_content=shareH5&utm_campaign=20210602-topic-H5-share&_channel_track_key=Q6x6xfxk");
    }

    /**
     * 抖音
     */
    @Test
    void douYinTest() throws Exception {
        parse(Platform.DOU_YIN, "6.97 xsE:/ “浪漫至死不渝，我比你想象中更加深情”%你的名字   https://v.douyin.com/e3md8Sv/ 復制此鏈接，打开Dou音搜索，直接观看視频！");
    }

    /**
     * 度小视
     */
    @Test
    void duXiaoShiTest() throws Exception {
        parse(Platform.DU_XIAO_SHI, "https://xspshare.baidu.com/88fc0154b588926c3abcbdd74a62f738?source=share-h5&pd=qm_share_mvideo&vid=4360835078718407166&shareTime=1627867933&shareid=1932363553&shared_cuid=_uBW8_8av8gx8v8Bja2sag8CSt0pu2uPgPvq8lulvfKkLl-uB&shared_uid=Al-uB");
    }

    /**
     * 好看
     */
    @Test
    void haoKanShiTest() throws Exception {
        parse(Platform.HAO_KAN, "https://haokan.hao123.com/v?vid=2434682787138128513&pd=haokan_share&context=%7B%22cuid%22%3A%22_uBW8_8av8gx8v8Bja2sag8CSt0pu2uPgPvq8lulvfKkLqqqB%22%7D");
    }

    /**
     * 火山
     */
    @Test
    void huoShanTest() throws Exception {
        parse(Platform.HUO_SHAN, "双胞胎车模（星星）在火山分享了视频，快来围观！传送门戳我>>https://share.huoshan.com/hotsoon/s/bWA4mrCMtk8/ 复制此链接，打开【抖音火山版】，直接观看视频~");
    }

    /**
     * 虎牙
     */
    @Test
    void huYaTest() throws Exception {
        parse(Platform.HU_YA, "http://v.huya.com/m/play/fans/531742009.html?source=android&sharetype=other&shareid=s6366141037850304773&platform=7&oexp=1389.1686%2C2114.2719%2C2163.2778%2C4890.7103%2C5372.7817%2C6773.9963%2C719.993%2C7936.11691%2C8274.12218%2C8943.13201%2C8977.13252%2C9052.13360%2C9081.13409%2C9090.13424%2C9102.13441%2C9108.13451%2C9129.13485%2C9145.13510%2C9148.13513%2C9175.13545%2C9208.13604%2C9218.13625%2Carcore_1.0&guid=0a439f97880005617b01ec52ed525a6f");
    }

    /**
     * 开眼
     */
    @Test
    void kaiYanTest() throws Exception {
        parse(Platform.KAI_YAN, "https://m.eyepetizer.net/u1/video-detail?video_id=267766&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0&udid=e03fdb127ded489a842d5e0b4f6ea6a431c9285b&vc=7020001&vn=7.2.0&size=1080X2265&deviceModel=VOG-AL00&first_channel=testflight&last_channel=testflight&system_version_code=29");
    }

    /**
     * 快手
     */
    @Test
    void kuaiShouTest() throws Exception {
        parse(Platform.KUAI_SHOU, "我说我不做 非要让我做 做完还埋汰我\uD83D\uDE44 https://v.kuaishou.com/bQ30Bb 复制此消息，打开【快手】直接观看！");
    }

    /**
     * 梨视频
     */
    @Test
    void liShiPinTest() throws Exception {
        parse(Platform.LI_SHI_PIN, "https://www.pearvideo.com/detail_1111663?st=7");
    }

    /**
     * 绿洲
     */
    @Test
    void lvZhouTest() throws Exception {
        parse(Platform.LV_ZHOU, "女神写真｜张天爱 @Crystal张天爱 #张天爱蝴蝶结镂空裙 纯白蝴蝶结镂空长裙搭配金色高跟... @爱豆女神在绿洲APP发了一条超棒的动态，戳我看看>>https://m.oasis.weibo.cn/v1/h5/share?sid=4641658404078184");
    }

    /**
     * 美拍
     */
    @Test
    void meiPaiTest() throws Exception {
        parse(Platform.MEI_PAI, "向姐姐们的大长腿看齐 http://www.meipai.com/video/863/6826061694944437551?client_id=1089857302&utm_media_id=6826061694944437551&utm_source=meipai_share&utm_term=meipai_android&gid=2185880175&utm_content=9458&utm_share_type=3");
    }

    /**
     * 秒拍
     */
    @Test
    void miaoPaiTest() throws Exception {
        parse(Platform.MIAO_PAI, "https://n.miaopai.com/v2/media/JhmurB2vhltQKYxjqFjqVlRl545TtIEi");
    }

    /**
     * 陌陌
     */
    @Test
    void moMoTest() throws Exception {
        parse(Platform.MO_MO, "https://m.immomo.com/s/moment/new-share-v2/ax10162362063.html?time=1628004007&name=zSVJpNjfRz+jfCrMQT06jg==&avatar=1C5C9130-A810-CAB8-DD8C-D227F02C2C5720210731&isdaren=0&isuploader=0&from=qqfriend");
    }

    /**
     * 皮皮搞笑
     */
    @Test
    void piPiGaoXiaoTest() throws Exception {
        parse(Platform.PI_PI_GAO_XIAO, "https://h5.pipigx.com/pp/post/475450717068?zy_to=copy_link&share_count=1&m=23fbbe82ccbe4731e10b923ebdd2c2db&app=&type=post&did=a81e6fd901939c1a&mid=7328875321474&pid=475450717068");
    }

    /**
     * 皮皮虾
     */
    @Test
    void piPiXiaTest() throws Exception {
        parse(Platform.PI_PI_XIA, "https://h5.pipix.com/s/e3moCwR/");
    }

    /**
     * 轻视频
     */
    @Test
    void qingShiPingTest() throws Exception {
        parse(Platform.QING_SHI_PING, "#轻视频# https://bbq.bilibili.com/video/?id=1623658971064418152");
    }

    /**
     * 全民K歌
     */
    @Test
    void quanMingKGeTest() throws Exception {
        parse(Platform.QUAN_MING_K_GE, "https://kg3.qq.com/node/4080mMBKO5/play_v2?s=6Cipi56JTgfy76DQ&shareuid=619c9981242a3189344d&topsource=a0_pn201001006_z11_u3144176203_l1_t1628133537__&pageId=feed");
    }

    /**
     * VUE Vlog
     */
    @Test
    void vueVlogTest() throws Exception {
        parse(Platform.VUE_VLOG, "https://v.vuevideo.net/share/post/-3151640006220828088");
    }

    /**
     * 微博
     */
    @Test
    void weiBoTest() throws Exception {
        parse(Platform.WEI_BO, "https://video.weibo.com/show?fid=1034:4656279344578592");
    }

    /**
     * 微视
     */
    @Test
    void weiShiTest() throws Exception {
        parse(Platform.WEI_SHI, "一条被水“断开”的公路，船在上面走车在底下开，设计感十足！>>https://isee.weishi.qq.com/ws/app-pages/share/index.html?wxplay=1&id=77nTk9kdd1M5JhOeS&collectionid=ai-60fecd4cddad6b010a08900a&spid=2124850950999772140&qua=v1_and_weishi_8.31.0_588_312026001_d&chid=100081003&pkg=&attach=cp_reserves3_1000370721");
    }

    /**
     * 小红书
     */
    @Test
    void xiaoHongShuTest() throws Exception {
        // 图片
        parse(Platform.XIAO_HONG_SHU, "13 CD视觉婚纱摄影发布了一篇小红书笔记，快来看吧！ \uD83D\uDE06 ky6HepJZ9zuPsUL \uD83D\uDE06 http://xhslink.com/Q6nfHd，复制本条信息，打开【小红书】App查看精彩内容！");
        // 视频
        parse(Platform.XIAO_HONG_SHU, "75 蝶讯DCI配色师发布了一篇小红书笔记，快来看吧！ \uD83D\uDE06 LAEjItC8CaHsyT2 \uD83D\uDE06 http://xhslink.com/UMNlHd，复制本条信息，打开【小红书】App查看精彩内容！");
    }

    /**
     * 西瓜视频
     */
    @Test
    void xiGuaTest() throws Exception {
        parse(Platform.WEI_SHI, "https://v.ixigua.com/e3mKfcU/");
    }

    /**
     * 新片场
     */
    @Test
    void xinPianChangTest() throws Exception {
        parse(Platform.XIN_PIAN_CHANGE, "https://www.xinpianchang.com/a10450763?from=share&channel=Link&type=URL&xpcApp=xpc");
    }

    /**
     * 最右
     */
    @Test
    void zuiYouTest() throws Exception {
        parse(Platform.ZUI_YOU, "#最右#分享一条有趣的内容给你，不好看算我输。请戳链接>> https://share.izuiyou.com/hybrid/share/post?pid=208977136&zy_to=applink&share_count=1&m=8df56b3a3afc94fd6ded32b716559572&d=35dfa91e566ca98c1bb301450a76fba02e84e82c1465c3d1c1ab7d683e48be36&app=zuiyou&recommend=r0&name=n0&title_type=t0");
    }
}
