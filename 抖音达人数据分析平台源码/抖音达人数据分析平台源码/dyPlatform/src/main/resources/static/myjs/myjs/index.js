let localStorePlatformDataPrefix = "platformData1"
let localStorePlatformDataTypeUserPrefix = "platformDataTypeUser"
init()

function init() {
    /*初始化本地的搜索数据*/
    if (!mutilSearchGetData()) {
        mutilSearchReset()
    }
    /*获取达人列表html*/
    refreshUserTabel()
    /*处理添加是否已经添加或者重合度*/
    updateIndexBtnState()

    /*刷新tab按鈕激活*/
    updateActivePlatformTab()
    /*恢复搜索输入框的文字*/
    initSearchInput()
    /*恢复sort排序显示*/
    initSort()
    /*获取行业内容类型有效用户数据*/
    getPlatformDataTypeUser()
    /*恢复高级选项的候选结果*/
    initAdvanceOption()
    /*綁定图表缩放事件*/
    initZoomEvent()
}


/*分页跳转*/
function localRefresh(obj) {
    // 装载局部刷新返回的页面
    let page = $(obj).attr("data")
    mutilSearchSetpage(page)
    refreshUserTabel()
}


/*添加候选*/
$(document).on("click", ".add_candidate_btn", function (event) {
    console.log("点击添加候选事件")
    event.stopPropagation()
    let id = $(this).attr("data")
    let tempthis = this
    if ($(tempthis).text().trim() == "添加") {
        if (isInCandidate(id, lastCandidateField) || isInCandidate(id, lastCandidateAutoField)) {
            alert("达人已添加到最终选定列表中")
        } else if (addCandidate(id, candidateField)) {
            $(tempthis).text("移除")
            $(tempthis).removeClass("btn-primary")
            $(tempthis).addClass("btn-danger")
            $("#badge_num").text(getCandidateNum(candidateField))
        }
    } else if ($(tempthis).text().trim() == "移除") {
        if (subCandidate(id, candidateField)) {
            $(tempthis).text("添加")
            $(tempthis).removeClass("btn-danger")
            $(tempthis).addClass("btn-primary")
            $("#badge_num").text(getCandidateNum(candidateField))
        }
    }
    $(".list_group_item_index").each((index, item) => {
        let id = $(item).attr("data")
        if (isInCandidate(id, candidateField)) {
            if (!$(item).hasClass("my_item_btn_active")) {
                $(item).addClass("my_item_btn_active")
            }
        } else {
            $(item).removeClass("my_item_btn_active")
        }
    })
})
/*进入个人信息列表*/
$(document).on("click", ".my_item_btn", function (event) {
    let id = $(this).attr("data")
    window.open("/talentInfo/" + id)
})
/*搜索大人处理*/
$("#search_btn").click(function () {
    let text = $("#search_input").val();
    if (text == "" || text.length < 1) {
        mutilSearchSetKeyword(null)
    } else {
        mutilSearchSetKeyword(text)
    }
    refreshUserTabel()
})
let temp_active_index = 1


/*恢复高级选项的候选结果*/
function initAdvanceOption() {
    var searchcondimm = []
    let data = mutilSearchGetData()
    if (data) {
        if (data.type.length > 0) {
            var obj = {};
            obj.val = [];
            obj.key = "内容类型"
            obj.val = data.type
            searchcondimm.push(obj)
        }
        if (data.value.length > 0) {
            var obj = {};
            obj.val = [];
            obj.key = "价值"
            obj.val = data.value
            searchcondimm.push(obj)
        }
        if (data.fans.length > 0) {
            var obj = {};
            obj.val = [];
            obj.key = "粉丝数"
            obj.val = data.fans
            searchcondimm.push(obj)
        }
    }
    console.log("searchcondimm", searchcondimm)
    reder(searchcondimm)
    if (searchcondimm.length > 0) {
        for (let i = 0; i < searchcondimm.length; i++) {
            $(".crumb").children(".crumbcondiwrap").append("<span class='chosexuanxiang'><b data-key=" + searchcondimm[i].key + ">" + searchcondimm[i].key + "：</b><em>" + searchcondimm[i].val + "</em><i></i></span>");
        }
    }
    return 1
}


function initSort() {
    let data = mutilSearchGetData()
    if (data) {
        if (data.sortWord == null || data.sortWord.indexOf("综合排序") > -1) {
            activeSort("default_sort")
        } else if (data.sortWord.indexOf("粉丝数") > -1) {
            activeSort("fans_sort")
        } else if (data.sortWord.indexOf("预期播放量") > -1) {
            activeSort("price_sort")
        }
    }
}


function initSearchInput() {
    let data = mutilSearchGetData()
    if (data) {
        $("#search_input").val(data.keyWord)
    }
}

/*切換排序*/
let tempIndex = 1 // 记录当前排序的是第几个
function switch_sort(index) {
    let str = 1
    let data = mutilSearchGetData()
    if (tempIndex == index) {
        if (data.isDESC) {
            mutilSearchSetIsDESC(false)
        } else {
            mutilSearchSetIsDESC(true)
        }
    } else {
        mutilSearchSetIsDESC(true)
    }
    if (index == 1) {
        mutilSearchSetSortwod("综合排序")
        str = "default_sort"
        tempIndex = 1
    } else if (index == 2) {
        mutilSearchSetSortwod("粉丝数")
        str = "fans_sort"
        tempIndex = 2
    } else {
        mutilSearchSetSortwod("预期播放量")
        str = "price_sort"
        tempIndex = 3
    }
    refreshUserTabel(str)
}


/*行业总览、大人列表切换*/
function switch_panel(a) {
    if (a == 0) {
        if ($("#data_panel").css("display") == "none") {
            $("#data_panel").css("display", "block")
            $("#type_property_panel").css("display", "none")
            $("#data_btn").addClass("btn-primary")
            $("#data_btn").removeClass("btn-default")
            $("#type_property_btn").addClass("btn-default")
            $("#type_property_btn").removeClass("btn-primary")
        }
    } else {
        /*切换到行业总览*/
        if ($("#data_panel").css("display") == 'block') {
            $("#data_panel").css("display", "none")
            $("#type_property_panel").css("display", "block")
            $("#data_btn").removeClass("btn-primary")
            $("#data_btn").addClass("btn-default")
            $("#type_property_btn").addClass("btn-primary")
            $("#type_property_btn").removeClass("btn-default")
            initTypePanel()
        }
    }
}

/*行业类型id*/
let typeid = -1

/*行业总览面板初始化*/
function initTypePanel() {
    let typeName = $("#type_property_btn").attr("data")
    $.ajax({
        url: "/multiSearch/getTypeId/" + typeName,
        type: "GET",
        async: false,
        success: function (ajaxdata) {
            if (ajaxdata.code == 200) {
                // typeid = ajaxdata.data[0].id
                typeid = -1
            }
        }
    })
}

getPlatformData(1)

/*获得平台数据*/
function getPlatformData(platformId) {
    let platformData = JSON.parse(sessionStorage.getItem(localStorePlatformDataPrefix))
    if (!(platformData && typeof (platformData) != "undefined" && platformData != 0 && platformData.length < 3)) {
        /*ajax获取*/
        $.ajax({
            url: "/platform/getAllPlatformData/" + platformId,
            type: 'GET',
            async: false,
            success: function (ajaxdata) {
                if (ajaxdata.code == 200) {
                    platformData = ajaxdata.data
                    sessionStorage.setItem(localStorePlatformDataPrefix, JSON.stringify(platformData))
                }
            }
        })
    }
    dealPlatformData(platformData)
}

/*处理平台数据*/
function dealPlatformData(platformData) {
    let allFanAndFalseFanData = []
    let allFanAndVideoNumData = []
    let allFanAndPriceData = []
    let allFanAndInteractionRateData = []
    let playNumAndAvgLikeData = []
    let playNumAndAvgCommentData = []
    let playNumAndAvgShareData = []
    for (let i = 0; i < platformData.length; i++) {
        allFanAndFalseFanData.push([platformData[i].allFansNum, platformData[i].realFansNum])
        allFanAndVideoNumData.push([platformData[i].allFansNum, platformData[i].avgVideoPlayNum])
        allFanAndPriceData.push([platformData[i].allFansNum, platformData[i].price])
        allFanAndInteractionRateData.push([platformData[i].allFansNum, platformData[i].interactionRate])
        let temp = platformData[i].predictVideoPlayNum / platformData[i].realFansNum
        temp = parseInt(temp) * 10000
        playNumAndAvgLikeData.push([platformData[i].avgLikeNum, temp])
        playNumAndAvgCommentData.push([platformData[i].avgCommentNum, temp])
        playNumAndAvgShareData.push([platformData[i].avgShareNum, temp])
    }
    drawAllFanAndFalseFan(allFanAndFalseFanData, "allFan_And_falseFan_panel")
    drawAllFanAndVideoNum(allFanAndVideoNumData, 'allFan_And_videoNum_panel')
    drawAllFanAndprice(allFanAndPriceData, 'allFan_And_price_panel')
    drawplayNumAndAvgLike(playNumAndAvgLikeData, "playNum_And_avgLike_panel")
    drawplayNumAndComment(playNumAndAvgCommentData, "playNum_And_avgComment_panel")
    drawplayNumAndShare(playNumAndAvgShareData, "playNum_And_avgShare_panel")
    console.log("--平台数据---")
    console.log(platformData)
}


/*单位播放量和平均点赞*/
function drawplayNumAndAvgLike(data, tagid) {
    let structDrawData = new Object()
    structDrawData.tagid = tagid
    structDrawData.text = "单位播放量与平均点赞数"
    structDrawData.xtext = "点赞数/视频"
    structDrawData.ytext = '单位播放量（次）'
    structDrawData.pointFormat = '点赞数：{point.x} <br/>单位播放量：{point.y}'
    structDrawData.data = data
    return draw(structDrawData)
}

function drawplayNumAndComment(data, tagid) {
    let structDrawData = new Object()
    structDrawData.tagid = tagid
    structDrawData.text = "单位播放量与平均评论数"
    structDrawData.xtext = "评论数/视频"
    structDrawData.ytext = '单位播放量（次）'
    structDrawData.pointFormat = '评论数：{point.x} <br/>单位播放量：{point.y}'
    structDrawData.data = data
    return draw(structDrawData)
}

function drawplayNumAndShare(data, tagid) {
    let structDrawData = new Object()
    structDrawData.tagid = tagid
    structDrawData.text = "单位播放量与平均分享数"
    structDrawData.xtext = "分享数/视频"
    structDrawData.ytext = '单位播放量（次）'
    structDrawData.pointFormat = '分享数：{point.x} <br/>单位播放量：{point.y}'
    structDrawData.data = data
    return draw(structDrawData)
}

/*粉丝数与假粉数关系*/
function drawAllFanAndFalseFan(data, tagid) {
    let structDrawData = new Object()
    structDrawData.tagid = tagid
    structDrawData.text = "平台达人总粉丝数与假粉丝数"
    structDrawData.xtext = "总粉丝数/人"
    structDrawData.ytext = '假粉数/人'
    structDrawData.pointFormat = '总粉丝数：{point.x} <br/>假粉数：{point.y}'
    structDrawData.data = data
    return draw(structDrawData)
}

function draw(structDrawData) {
    var chart = Highcharts.chart(structDrawData.tagid, {
        credits: {
            enabled: false
        },
        chart: {
            type: 'scatter',
            zoomType: 'xy'
        },
        title: {
            text: structDrawData.text
        },
        exporting: {
            enabled: false  //设置导出按钮不可用
        },
        xAxis: {
            title: {
                enabled: true,
                text: structDrawData.xtext
            },
            startOnTick: true,
            endOnTick: true,
            showLastLabel: true
        },
        yAxis: {
            title: {
                text: structDrawData.ytext
            }
        },
        legend: {
            enabled: false
        },
        plotOptions: {
            scatter: {
                tooltip: {
                    /*headerFormat: '<b>{series.name}</b><br>',*/
                    headerFormat: '',
                    pointFormat: structDrawData.pointFormat
                }
            }
        },
        series: [{
            color: 'rgba(119, 152, 191, .8)',
            data: structDrawData.data
        }]

    });
    return chart;
}


/*粉丝数与视频播放量散点图*/
function drawAllFanAndVideoNum(data, tagid) {
    var chart = Highcharts.chart(tagid, {
        credits: {
            enabled: false
        },
        chart: {
            type: 'scatter',
            zoomType: 'xy'
        },
        title: {
            text: '平台达人总粉丝数与播放量'
        },
        exporting: {
            enabled: false  //设置导出按钮不可用
        },
        xAxis: {
            title: {
                enabled: true,
                text: '总粉丝数/人'
            },
            startOnTick: true,
            endOnTick: true,
            showLastLabel: true
        },
        yAxis: {
            title: {
                text: '播放量/次'
            }
        },
        legend: {
            enabled: false
        },
        plotOptions: {
            scatter: {
                tooltip: {
                    /*headerFormat: '<b>{series.name}</b><br>',*/
                    headerFormat: '',
                    pointFormat: '总粉丝数：{point.x} <br/>播放量：{point.y}'
                }
            }
        },
        series: [{
            color: 'rgba(119, 152, 191, .8)',
            data: data
        }]
    });
    return chart;
}

/*粉丝数与价格散点图*/
function drawAllFanAndprice(data, tagid) {
    var chart = Highcharts.chart(tagid, {
        credits: {
            enabled: false
        },
        chart: {
            type: 'scatter',
            zoomType: 'xy'
        },
        title: {
            text: '平台达人总粉丝数与达人价格'
        },
        exporting: {
            enabled: false  //设置导出按钮不可用
        },
        xAxis: {
            title: {
                enabled: true,
                text: '总粉丝数/人'
            },
            startOnTick: true,
            endOnTick: true,
            showLastLabel: true
        },
        yAxis: {
            title: {
                text: '￥'
            }
        },
        legend: {
            enabled: false
        },
        plotOptions: {
            scatter: {
                tooltip: {
                    /*headerFormat: '<b>{series.name}</b><br>',*/
                    headerFormat: '',
                    pointFormat: '总粉丝数：{point.x} <br/>价格：{point.y}￥'
                }
            }
        },
        series: [{
            color: 'rgba(119, 152, 191, .8)',
            data: data
        }]
    });
    return chart;
}


/*获取行业内容类型有效用户数据*/
var platformId = 1

function getPlatformDataTypeUser() {
    let typeName = $("#type_property_btn").attr("data")
    if (!typeName || typeof (typeName) == "undefined") {
        $("#type_all_user_num").text("请选择一个内容类型")
    } else {
        let platformDataTypeUser = JSON.parse(sessionStorage.getItem(localStorePlatformDataTypeUserPrefix + platformId + typeName))
        if (!platformDataTypeUser && typeof (platformDataTypeUser) != "undefined" && platformDataTypeUser != 0) {
            /*ajax获取*/
            $.ajax({
                url: "/platform/getAllPlatformTypeUserData/" + platformId + "/" + typeName,
                type: 'GET',
                async: false,
                success: function (ajaxdata) {
                    if (ajaxdata.code == 200) {
                        platformDataTypeUser = ajaxdata.data
                        sessionStorage.setItem(localStorePlatformDataTypeUserPrefix + platformId + typeName, JSON.stringify(platformDataTypeUser))
                    }
                }
            })
        }
        console.log("drawTypeUserPanel")
        console.log(platformDataTypeUser)
        let typeAllUserData = []
        for (let i = 0; i < platformDataTypeUser.length; i++) {
            typeAllUserData.push([platformDataTypeUser[i].checkTime, platformDataTypeUser[i].allUserNum])
        }
        let typeRealUserData = []
        for (let i = 0; i < platformDataTypeUser.length; i++) {
            typeRealUserData.push([platformDataTypeUser[i].checkTime, platformDataTypeUser[i].realAllUserNum])
        }
        // drawTypeUserPanel(typeAllUserData, typeRealUserData, typeName)
    }
}

function drawTypeUserPanel(typeAllUserData, typeRealUserData, typeName) {
    var chart = Highcharts.chart('type_all_user_num', {
        credits: {
            enabled: false
        },
        chart: {
            type: 'line'
        },
        title: {
            text: typeName + '类型的用户量变化'
        },
        xAxis: {
            allowDecimals: false,
            type: 'datetime',
            dateTimeLabelFormats: {
                millisecond: '%Y-%m',
                second: '%Y-%m',
                minute: '%Y-%m',
                hour: '%Y-%m',
                day: '%Y-%m',
                week: '%Y-%m',
                month: '%Y-%m',
                year: '%Y'
            },
        },
        yAxis: {
            title: {
                text: '用户数'
            }
        },
        exporting: {
            enabled: false  //设置导出按钮不可用
        },
        plotOptions: {
            line: {
                dataLabels: {
                    // 开启数据标签
                    enabled: true
                },
                // 关闭鼠标跟踪，对应的提示框、点击事件会失效
                enableMouseTracking: false
            }
        },
        series: [{
            name: typeName + '类型所有用户',
            data: typeAllUserData
        }, {
            name: typeName + '类型有效用户',
            data: typeRealUserData
        }]
    });
}

$(document).on("click", "#switch_platform_btn1", function (event) {
    if ($(this).hasClass("btn-default")) {
        $(this).removeClass("btn-default")
        $(this).addClass("btn-primary")
        $("#switch_platform_btn2").removeClass("btn-primary")
        $("#switch_platform_btn2").addClass("btn-default")
    }
})
$(document).on("click", "#switch_platform_btn2", function (event) {
    if ($(this).hasClass("btn-default")) {
        $(this).removeClass("btn-default")
        $(this).addClass("btn-primary")
        $("#switch_platform_btn1").removeClass("btn-primary")
        $("#switch_platform_btn1").addClass("btn-default")
    }
})

function resizeImgX(img) {
    let w = $("#myshowback").css("width")
    let imgs = $("#xiangxi_panel").find("img")
    w = w.replace("px", "")
    let iwidth = parseInt(w) - 50
    for (let i = 0; i < imgs.length; i++) {
        imgs[i].height = (imgs[i].height / imgs[i].width) * iwidth
        imgs[i].width = iwidth
    }
}

$(window).scroll(function () {
    //为了保证兼容性，这里取两个值，哪个有值取哪一个
    //scrollTop就是触发滚轮事件时滚轮的高度
    var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
    // nav_plat
    if (scrollTop > 210) {
        $("#nav_plat").css("top", scrollTop - 210)
    } else {
        $("#nav_plat").css("top", 0)
    }
})

/*平台源切换*/
function switch_platform(obj, platformid) {
    if (!$(obj).hasClass("active")) {
        let itemls = $(obj).parent().children();
        for (let i = 0; i < itemls.length; i++) {
            $(itemls[i]).removeClass("active")
            $(itemls[i]).removeClass("default_active_font")
        }
        $(obj).addClass("active")
        $(obj).addClass("default_active_font")
        mutilSearchReset()
        mutilSearchSetPlatform(platformid)
        refreshUserTabel()
    }
}

/*刷新tab按鈕激活*/
function updateActivePlatformTab() {
    let platform = mutilSearchGetPlatform()
    let itemls = $("#platform_tab").children();
    console.log(itemls)
    for (let i = 0; i < itemls.length; i++) {
        $(itemls[i]).removeClass("active")
        $(itemls[i]).removeClass("default_active_font")
    }
    console.log(platform)
    $(itemls[platform - 1]).addClass("active")
    $(itemls[platform - 1]).addClass("default_active_font")
}


/*綁定图表缩放事件*/
function initZoomEvent() {
    var mychart
    $(document).on("click", ".zoom_control", function (e) {
        console.log(11)
        if ($(".wrapper").css("display") == "inline-block") {
            let parentWidth = $("#main-content").width()
            let parentHeight = window.screen.availHeight

            let startWidth = $(this).width()
            let startheight = $(this).height()
            let endWidth = parentWidth * 0.75

            let endHeight = endWidth * startheight / startWidth
            let endLeft = parentWidth / 2 - endWidth / 2
            let endTop = parentHeight / 2 - endHeight / 2
            let elementId = $(this).attr("id")

            $(".wrapper").css("display", "none")
            $("#zoomPlace").parent().css("display", "flex")
            // $("#zoomPlace").parent().css("height", document.body.clientHeight)
            mychart = showChartTable(elementId)
            mychart.setSize(startWidth, startheight, false)
            $("#zoomPlace").css({"margin-top": endTop, "margin-left": endLeft});
            // $("#zoomPlace").parent().attr("height", document.body.clientHeight)

            let obj = {num1: startWidth};
            TweenMax.to(obj, 0.5, {
                num1: endWidth, onUpdate: function () {
                    let temp = obj.num1 * startheight / startWidth
                    mychart.setSize(obj.num1, temp, false)
                }
            })
        }
    })
    $(document).on("click", "#zoomPlaceParent", function (e) {
        console.log("okok23", document.body.clientHeight)
        let startWidth = $(this).width()
        let startheight = $(this).height()
        let endWidth = startWidth * 0.5
        let obj = {num1: startWidth};
        TweenMax.to(obj, 0.2, {
            num1: endWidth,
            opacity: 0,
            onUpdate: function () {
                let temp = obj.num1 * startheight / startWidth
                mychart.setSize(obj.num1, temp, false)
            },
            onComplete: function () {
                console.log("fin")
                $("#zoomPlace").parent().css("display", "none")
                $(".wrapper").css("display", "inline-block")
            }
        })
    })
}

function showChartTable(elementId) {
    console.log(elementId)
    let platformData = JSON.parse(sessionStorage.getItem(localStorePlatformDataPrefix))
    console.log("platformData", platformData)
    let allFanAndFalseFanData = []
    let allFanAndVideoNumData = []
    let allFanAndPriceData = []
    let allFanAndInteractionRateData = []
    let playNumAndAvgLikeData = []
    let playNumAndAvgCommentData = []
    let playNumAndAvgShareData = []
    for (let i = 0; i < platformData.length; i++) {
        allFanAndFalseFanData.push([platformData[i].allFansNum, platformData[i].realFansNum])
        allFanAndVideoNumData.push([platformData[i].allFansNum, platformData[i].avgVideoPlayNum])
        allFanAndPriceData.push([platformData[i].allFansNum, platformData[i].price])
        allFanAndInteractionRateData.push([platformData[i].allFansNum, platformData[i].interactionRate])
        let temp = platformData[i].predictVideoPlayNum / platformData[i].realFansNum
        temp = parseInt(temp) * 10000
        playNumAndAvgLikeData.push([platformData[i].avgLikeNum, temp])
        playNumAndAvgCommentData.push([platformData[i].avgCommentNum, temp])
        playNumAndAvgShareData.push([platformData[i].avgShareNum, temp])
    }
    let tagid = "zoomPlace"
    let chart
    if (elementId == "allFan_And_falseFan_panel") {
        chart = drawAllFanAndFalseFan(allFanAndFalseFanData, tagid)
    } else if (elementId == "allFan_And_videoNum_panel") {
        chart = drawAllFanAndVideoNum(allFanAndVideoNumData, tagid)
    } else if (elementId == "allFan_And_price_panel") {
        chart = drawAllFanAndprice(allFanAndPriceData, tagid)
    } else if (elementId == "playNum_And_avgLike_panel") {
        chart = drawplayNumAndAvgLike(playNumAndAvgLikeData, tagid)
    } else if (elementId == "playNum_And_avgComment_panel") {
        chart = drawplayNumAndComment(playNumAndAvgCommentData, tagid)
    } else if (elementId == "playNum_And_avgShare_panel") {
        chart = drawplayNumAndShare(playNumAndAvgShareData, tagid)
    } else {
        chart = null
    }
    return chart

}