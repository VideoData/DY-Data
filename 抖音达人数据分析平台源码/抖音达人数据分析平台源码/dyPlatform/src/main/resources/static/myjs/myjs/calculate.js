$(document).ready(function () {
    updateAllCandidatePanel(true)
    // todo 正确显示激活的候选列表导航快
    showResult(1)
    // showActiveNav()
})
/*候选区域的导航条点击事件*/
$(document).on("click", "#mynavs div", function () {
    if ($(this).attr("class") == "mynavAcitve") {
        return
    }
    setCandidateListControlCurrentNum($(this).attr("data-index"), $(this).attr("data-type"))
    updateCandidatePanel(true)
})
/*候选区域的导航条点击刪除X事件*/
$(document).on("click", "#mynavs span", function (e) {
    console.log("#mynavs span 点击了")
    e.preventDefault()
    let uniqueid = $(this).parent().attr("data-index")
    let type = $(this).parent().attr("data-type")
    removeFromMyNav(uniqueid, type)
})

//正确显示激活的候选列表导航快
function showActiveNav() {
    let mynav = $("#mynavs")
    mynav.empty()
    let html = ""
    let isFirst = true
    let alldata = getCandidateListControl()
    if (alldata && alldata.num > 0) {
        let indata = alldata.data
        let isShowOverAllHtml = "<span class='overall_label'>全局</span>"
        for (let i = 0; i < indata.length; i++) {
            let isShowOverAll = indata[i].isOverAll ? isShowOverAllHtml : ""
            if (indata[i].uniqueid == alldata.currentNum && indata[i].type == alldata.currentType) {
                html += "<div class='mynavAcitve' data-type='" + indata[i].type + "' data-index='" + indata[i].uniqueid + "'>" + isShowOverAll + "第" + indata[i].uniqueid + "达人<span style='color: #f45778' class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></div>"
                isFirst = false
            } else {
                html += "<div data-type='" + indata[i].type + "' data-index='" + indata[i].uniqueid + "'>" + isShowOverAll + "第" + indata[i].uniqueid + "达人<span style='color: #f45778' class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></div>"
            }
        }
    }
    let firstHtml = ""
    if (isFirst) {
        firstHtml = "<div class='mynavAcitve' data-index='0'  style='padding-left: 10px'>候选达人</div>"
    } else {
        firstHtml = "<div data-index='0' style='padding-left: 10px'>候选达人</div>"
    }
    html = firstHtml + html
    mynav.append(html)
}

function updateAllCandidatePanel(isFirst) {
    if (isFirst) {
        sessionStorage.removeItem(lastCandidatePageField)
        sessionStorage.removeItem(candidatePageField)
    }
    console.log("updateAllCandidatePanel")
    dataLast = getCandidateData(lastCandidateField)
    dataAutoLast = getCandidateData(lastCandidateAutoField)
    if (dataLast && dataAutoLast) {
        for (let i = 0; i < dataAutoLast.length; i++) {
            dataLast.push(dataAutoLast[i])
        }
    } else if (dataAutoLast) {
        dataLast = dataAutoLast
    }
    let candidateData = getCandidateDataExtern()
    if (dataLast) {
        dataLast = getSplitePageData(dataLast, lastCandidatePageField)
    }
    console.log("candidatedata", candidateData)
    if (candidateData || dataLast) {
        console.log("data")
        console.log("candidatedata", candidateData)
        let fd = new FormData()
        fd.append("data", candidateData)
        fd.append("dataLast", dataLast)
        $.ajax({
            url: "/calculate/updateAllCandidate",
            type: "POST",
            data: fd,
            async: false,
            processData: false,  // 不处理数据
            contentType: false,   // 不设置内容类型
            success: function (ajaxdata) {
                $("#main_right").replaceWith(ajaxdata)
                // 正确显示激活的候选列表导航快
                showActiveNav()
                updateBtnState()
                getCandidateTotalPrice(1)
                getCandidateTotalPrice(2)

            }
        })
    } else {
        showActiveNav()
    }
}


/*计算本地分页的请求id列表*/
function getSplitePageData(data, field) {
    let size = getPageSize(field)
    let page = getpage(field)
    console.log("page size", page, size)
    if (data.length > size) {
        let temp = []
        if (data.length > (page - 1) * size) {
            let end = data.length > page * size ? page * size : data.length
            for (let i = (page - 1) * size; i < end; i++) {
                temp.push(data[i])
            }
        } else {
            sessionStorage.removeItem(field)
            for (let i = 0; i < size; i++) {
                temp.push(data[i])
            }
        }
        return temp;
    } else {
        return data
    }
}

function updateCandidatePanel(isFirst) {
    console.log("updateCandidatePanel")
    let data = getCandidateDataExtern(getCandidateListControl())
    if (!data || data.length < 1) {
        $("#candidatePanel").empty()
        return
    }
    if (isFirst) {
        sessionStorage.removeItem(candidatePageField)
    }
    let fd = new FormData()
    fd.append("data", data)
    $.ajax({
        url: "/calculate/updateCandidate",
        type: "POST",
        data: fd,
        processData: false,  // 不处理数据
        contentType: false,   // 不设置内容类型
        success: function (ajaxdata) {
            $("#candidatePanel").replaceWith(ajaxdata)
            showActiveNav()
            updateBtnState()
            getCandidateTotalPrice(2)
        }
    })
}


function updateLastCandidatePanel(isFirst) {
    if (isFirst) {
        sessionStorage.removeItem(lastCandidatePageField)
    }
    console.log("updateCandidatePanel")
    dataLast = getCandidateData(lastCandidateField)
    dataAutoLast = getCandidateData(lastCandidateAutoField)
    if (dataLast && dataAutoLast) {
        for (let i = 0; i < dataAutoLast.length; i++) {
            dataLast.push(dataAutoLast[i])
        }
    } else if (dataAutoLast) {
        dataLast = dataAutoLast
    }
    if (dataLast) {
        dataLast = getSplitePageData(dataLast, lastCandidatePageField)
        let fd = new FormData()
        fd.append("data", dataLast)
        $.ajax({
            url: "/calculate/updateLastCandidate",
            type: "POST",
            data: fd,
            processData: false,  // 不处理数据
            contentType: false,   // 不设置内容类型
            success: function (ajaxdata) {
                $("#lastCandidatePanels").replaceWith(ajaxdata)
                updateBtnState()
                getCandidateTotalPrice(1)
            }
        })
    }
}

/*装配总计价格*/
function loadTotalPrice(data, str) {
    let fd = new FormData()
    fd.append("data", data)
    console.log(data)
    $.ajax({
        url: "/calculate/getTotalPrice",
        type: "POST",
        data: fd,
        processData: false,  // 不处理数据
        contentType: false,   // 不设置内容类型
        success: function (ajaxdata) {
            if (ajaxdata.code == 200) {
                $("#" + str).text(ajaxdata.data)
            }
        }
    })
}

/**
 * 获取候选达人的价格总计
 * @param index 1:获取选定大人区域的     2：获取候选大人区域的
 */
function getCandidateTotalPrice(index) {
    if (index == 1) {
        let dataAuto = getCandidateData(lastCandidateAutoField)
        let data = getCandidateData(lastCandidateField)
        if (data && dataAuto) {
            for (let i = 0; i < dataAuto.length; i++) {
                data.push(dataAuto[i])
            }
        } else if (dataAuto) {
            data = dataAuto
        }
        if (data) {
            loadTotalPrice(data, "lastcandidate_total_price_span")
        }
    } else if (index = 2) {
        let data = getCandidateActiveIds()
        if (data) {
            loadTotalPrice(data, "candidate_total_price_span")
        }
    }
}

/**
 * 获取候选区域激活的nav对应的id列表
 */
function getCandidateActiveIds() {
    let divs = $("#mynavs div")
    let uniqueid = ""
    let type = ""
    for (let i = 0; i < divs.length; i++) {
        if ($(divs[i]).attr('class') == "mynavAcitve") {
            uniqueid = $(divs[i]).attr('data-index')
            if (uniqueid == '0') {
                type = $(divs[i]).attr('data-type')
            }
            break
        }
    }
    if (uniqueid !== "") {
        uniqueid = parseInt(uniqueid)
        if (uniqueid == 0) {
            return getCandidateData(candidateField)
        } else {
            type = parseInt(type)
            return getCandidateListControlIds(uniqueid, type)
        }
    }
    return null
}

/**
 * 更新达人列表按钮状态，并添加分页数据
 */
function updateBtnState() {
    console.log($(".chonghe_btn"))
    console.log($(".chonghe_btn").length)
    $(".chonghe_btn").each((index, item) => {
        let id = $(item).attr("data")
        if (isInOverlap(id, overlapField)) {
            $(item).removeClass('btn-primary')
            $(item).addClass("btn-danger")
            $(item).text("已添加")
        }
    })
    $(".inbox-started").each((index, item) => {
        let id = $(item).attr("data")
        if (isInCandidate(id, lastCandidateField)) {
            $(item).css("color", "#d9534f")
        }
    })
    //选定列表的分页逻辑装填
    let num = getCandidateNum(lastCandidateField)
    num += getCandidateNum(lastCandidateAutoField)
    let size = getPageSize(lastCandidatePageField)
    if (num <= size) {
        $("#lastCandidateNumSpan").text("共 " + num + " 位达人")
        $("#lastCandidate_lastPage_btn").css("display", "none")
        $("#lastCandidate_nextPage_btn").css("display", "none")
    } else {
        let page = getpage(lastCandidatePageField)
        let start = (page - 1) * size
        let end = start + size
        end = end > num ? num : end
        console.log(page, size)
        console.log(start + "-" + end + "osdff" + num + " 位达人")
        $("#lastCandidateNumSpan").text(start + "-" + end + " of " + num + " 位达人")
        $("#lastCandidate_lastPage_btn").css("display", "block")
        $("#lastCandidate_nextPage_btn").css("display", "block")
    }

    //候选区域的分页逻辑数据装填
    num = getCandidateActiveIdsNum()
    size = getPageSize(candidatePageField)
    if (num <= size) {
        $("#candidateNumSpan").text("共 " + num + " 位达人")
        $("#candidate_lastPage_btn").css("display", "none")
        $("#candidate_nextPage_btn").css("display", "none")
    } else {
        let page = getpage(candidatePageField)
        let start = (page - 1) * size
        let end = start + size
        end = end > num ? num : end
        $("#candidateNumSpan").text(start + "-" + end + " of " + num + " 位达人")
        $("#candidate_lastPage_btn").css("display", "block")
        $("#candidate_nextPage_btn").css("display", "block")
    }
}

/**
 * 获取候选激活区域的ids数量
 * @returns {boolean}
 */
function getCandidateActiveIdsNum() {
    let divs = $("#mynavs div")
    let uniqueid = ""
    let type = ""
    for (let i = 0; i < divs.length; i++) {
        if ($(divs[i]).attr('class') == "mynavAcitve") {
            uniqueid = $(divs[i]).attr('data-index')
            if (uniqueid != '0') {
                type = $(divs[i]).attr('data-type')
            }
            break
        }
    }
    if (uniqueid !== "") {
        uniqueid = parseInt(uniqueid)

        if (uniqueid == 0) {
            return getCandidateNum(candidateField)
        } else {
            type = parseInt(type)
            return getCandidateListControlIdsNum(uniqueid, type)
        }
    }
}

/**
 *选定区域达人分页上一页
 */
$(document).on("click", "#lastCandidate_lastPage_btn", function () {
    let page = getpage(lastCandidatePageField)
    if (page > 1) {
        page = page - 1
        savePage(page, lastCandidatePageField)
        updateLastCandidatePanel(false)
    }
})
/**
 *选定区域达人分页下一页
 */
$(document).on("click", "#lastCandidate_nextPage_btn", function () {
    let page = getpage(lastCandidatePageField)
    let size = getPageSize(lastCandidatePageField)
    let num = getCandidateNum(lastCandidateAutoField)
    num = num + getCandidateNum(lastCandidateField)
    if (num > (page - 1) * size) {
        page = page + 1
        savePage(page, lastCandidatePageField)
        updateLastCandidatePanel(false)
    }
})
/**
 * 候选区域分页上一页
 */
$(document).on("click", "#candidate_lastPage_btn", function () {
    let page = getpage(candidatePageField)
    if (page > 1) {
        page = page - 1
        savePage(page, candidatePageField)
        updateCandidatePanel(false)
    }
})
$(document).on("click", "#candidate_nextPage_btn", function () {
    console.log("candidate_nextPage_btn")
    let page = getpage(candidatePageField)
    let size = getPageSize(candidatePageField)
    let num = getCandidateNum(candidateField)
    if (num > (page - 1) * size) {
        page = page + 1
        savePage(page, candidatePageField)
        updateCandidatePanel(false)
    }
})

/*
    将fromField的id移动到toField
 */
function switchIdToCandidate(id, fromField, toField, isUpdatePanel) {
    if (subCandidate(id, fromField)) {
        if (addCandidate(id, toField)) {
            if (isUpdatePanel) {
                updateAllCandidatePanel(true)
            }
        } else {
            addCandidate(id, fromField)
        }
        return true
    }
    return false
}

/*选定*/
$(document).on("click", ".add_choose_btn", function (event) {
    event.preventDefault()
    let id = $(this).attr("data")
    switchIdToCandidate(id, candidateField, lastCandidateField, true)
})
/*移除选定*/
$(document).on("click", ".remove_choose_btn", function () {
    let id = $(this).attr("data")
    if (!switchIdToCandidate(id, lastCandidateField, candidateField, true)) {
        switchIdToCandidate(id, lastCandidateAutoField, candidateField, true)
    }
})
/*移除候选*/
$(document).on("click", ".remove_condidate_btn", function () {
    let id = $(this).attr("data")
    if (subCandidate(id, candidateField)) {
        updateCandidatePanel(false)
    }
})
/*处理折叠展开*/
$(document).on("click", "#zhe1", function () {
    text = $("#zhe1").text()
    if (text.trim() === "折叠") {
        $("#zhe1").text("展开")

        $("#panel1").css("display", "none")
    } else {
        $("#zhe1").text("折叠")
        $("#panel1").css("display", "block")
    }
})
$(document).on("click", "#zhe2", function () {
    text = $("#zhe2").text()
    if (text.trim() === "折叠") {
        $("#zhe2").text("展开")
        $("#panel2").css("display", "none")
    } else {
        $("#zhe2").text("折叠")
        $("#panel2").css("display", "block")
    }
})
/*显示计算帮助*/
$(".show_calculate_help").hover(function () {
    $(this).parent().next().css("display", "block")
}, function () {
    $(this).parent().next().css("display", "none")
})
/*全选检查框*/
$(document).on("click", ".select_all", function () {
    if ($(this).children()[0].checked) {
        $(this).parent().parent().next().find(".selected-mail-checkbox").each((index, e) => {
            e.checked = true
        })
    } else {
        $(this).parent().parent().next().find(".selected-mail-checkbox").each((index, e) => {
            e.checked = false
        })
    }
})
$(document).on("click", ".panel", function (e) {
    let name = e.target.className
    if (name.indexOf("selected-mail-checkbox") > -1) {
        let num = 0;
        let sum = 0;
        $(this).find(".selected-mail-checkbox").each((index, e) => {
            num += 1
            if (e.checked) {
                sum += 1
            }
        })
        if (sum == num && sum > 0) {
            $(this).find(".select_all").children()[0].checked = true
        } else {
            $(this).find(".select_all").children()[0].checked = false
        }
    }
})
/*选定多选的候选人*/
$(document).on("click", "#choose_all_candidate_btn", function () {
    let items = $(".select_checkbox_candidate_item")
    items.each((index, e) => {
        if ($(e).is(':checked')) {
            switchIdToCandidate($(e).attr("data"), candidateField, lastCandidateField, false)
        }
    })
    updateAllCandidatePanel(true)
})
/*移除多选的候选人*/
$(document).on("click", "#remove_all_candidate_btn", function () {
    let items = $(".select_checkbox_candidate_item")
    items.each((index, e) => {
        if ($(e).is(':checked')) {
            subCandidate($(e).attr("data"), candidateField)
        }
    })
    updateCandidatePanel(true)
})
/*移除多个选定的人到候选列表*/
$(document).on("click", "#remove_all_choosed_candidate_btn", function () {
    let items = $(".select_checkbox_choosed_candidate_item")
    items.each((index, e) => {
        console.log(e)
        console.log($(e).is(':checked'))
        if ($(e).is(':checked')) {
            switchIdToCandidate($(e).attr("data"), lastCandidateField, candidateField, false)
            switchIdToCandidate($(e).attr("data"), lastCandidateAutoField, candidateField, false)
        }
    })
    updateAllCandidatePanel(true)
})
/*背包自动选择*/
$(document).on("click", "#calculate_btn", function () {
    let ids = getCandidateData(candidateField)
    let money = $("#pre_money_input").val()
    let num = $("#max_talent_num_input").val()
    let fm = new FormData()
    let video_length = $("#video_length").val()
    fm.append("limitNum", num)
    fm.append("ids", ids)
    fm.append("limitMony", money * 1000)
    fm.append("videoLength", video_length)
    $.ajax({
            url: "/calculate/calculate",
            type: "POST",
            data: fm,
            contentType: false,
            processData: false,
            success: function (data) {
                if (data.code == 200) {
                    //该次计算是否加入到选定列表中
                    data.data.isJoin = false
                    data.data.isOverAll = false
                    let uniqueid = addHistoryBag(data.data)
                    if (uniqueid) {
                        removeFromMyNav(uniqueid)
                    }
                    showResult(1)
                }
            }
        }
    )
})

/*从导航条中移除指定uniqueid的大人列表*/
function removeFromMyNav(uniqueid, type) {
    let result = removeCandidateListControl(uniqueid, type)
    if (result) {
        updateCandidatePanel(true)
    }
}

/*展示第几个背包计算历史结果*/
function showResult(index) {
    let historyData = getHistoryBag()
    if (historyData == null || historyData.num == 0) {
        $("#show_normal_result").css("display", "none")
        $("#show_place_holder").css("display", "block")
        return
    } else {
        $("#show_place_holder").css("display", "none")
        $("#show_normal_result").css("display", "block")
    }
    let data = historyData.data[index - 1]
    $("#result_preMoney").text(formatToMoney(data.maxPlayNum.limitMony, 0) + "￥")
    $("#result_perplay").text(formatToW(data.maxPlayNum.totalPlayNum))
    $("#result_talent_num").text(data.maxPlayNum.talentNum)
    $("#result_pay").text(formatToMoney(data.maxPlayNum.totalPrice, 0) + "￥")
    $("#result_type").text(data.maxPlayNum.videoLength)
    $("#real_fan").text(formatToW(data.maxPlayNum.realFans))
    let temp = historyData.lastNum - index + 1
    $("#show_talent_btn_play").attr("data-index", temp)
    let menu = $("#result_menu_item")
    menu.empty()
    let html = ""
    let isShowOverAllHtml = "<span class='overall_label'>全局</span>"
    for (let i = 0; i < historyData.num; i++) {
        let isShowOverAll = historyData.data[i].isOverAll ? isShowOverAllHtml : ""
        html = html + "<li onclick='showResult(" + (i + 1) + ")'>" + isShowOverAll + "第" + (historyData.lastNum - i) + "次计算</li>"
    }
    menu.append(html)
    $("#cal_result_select a").text(`第${temp}次计算`)
    $("#show_optimization_result").css("display", "block")
    showOptimizationResult(data, temp)
}

function showOptimizationResult(data, temp) {
    let optimizationMoney = data.maxPriceOptimization.limitMony
    let optimizationValue = data.maxPriceOptimization.resultValue
    $("#optimization_result_talent_num").text(data.maxPriceOptimization.talentNum)
    $("#optimization_result_pay").text(formatToMoney(data.maxPriceOptimization.totalPrice,0)+"￥")
    $("#optimization_result_perplay").text(formatToW(data.maxPriceOptimization.totalPlayNum) )
    $("#optimization_real_fan").text(formatToW(data.maxPriceOptimization.realFans))
    $("#optimization_show_talent_btn").attr("data-index", temp)
}

/*进入个人信息列表*/
$(document).on("click", ".my_item_btn", function (event) {
    if (event.target.className.indexOf("checkbox") > -1) {
        return
    }
    if (event.target.className.indexOf("btn") > -1) {
        return
    }
    let id = $(this).attr("data")
    window.open("/talentInfo/" + id)
})
$(document).on('mouseenter', ".inbox-started", function (event) {
    // let i = $(this).children()[0]
    if ($(this).css("color").indexOf("217") > -1) {
        $(this).parent().attr("data-content", "手动指定的达人")
    } else {
        $(this).parent().attr("data-content", "算法选择的达人")
    }
    $($(this).parent()).popover("show", {
        animation: true,
        trigger: "hover",
        delay: {show: 500, hide: 100},
        container: 'body'
    });
})
$(document).on('mouseout', ".inbox-started", function (event) {
    // let i = $(this).children()[0]
    $($(this).parent()).popover("hide")
})
$(document).on('mouseenter', "#help_pre_price", function (event) {
    // let i = $(this).children()[0]
    $(this).attr("data-content", "自动计算所需指定的预算，以千为单位")
    $(this).popover("show", {
        animation: true,
        trigger: "hover",
        placement: "top",
        delay: {show: 500, hide: 100},
        container: 'body'
    });
})
$(document).on('mouseout', "#help_pre_price", function (event) {
    $(this).popover("hide")
})

/*切换计算面板*/
function swicthCalcPanel(thi, index) {
    if ($(thi).hasClass("active")) {
        return
    } else {
        $(thi).addClass("active")
        if (index == 2) {
            $(thi).prev().removeClass("active")
            $("#calc_panel_1").css("display", "none")
            $("#calc_panel_2").css("display", "block")
            showCandidateTalentType()
        } else if (index == 1) {
            $(thi).next().removeClass("active")
            $("#calc_panel_2").css("display", "none")
            $("#calc_panel_1").css("display", "block")
        }
    }
}

/*为下拉菜单添加达人类型*/
function showCandidateTalentType() {
    if ($("#talent_type").children().length < 2) {
        $.ajax({
            url: "/calculate/getAllTalentType",
            type: "GET",
            success: function (data) {
                console.log(data)
                if (data.code == 200) {
                    data = data.data
                    for (let i = 0; i < data.length; i++) {
                        let html = "<option value=\"" + data[i] + "\">" + data[i] + "</option>"
                        $("#talent_type").append(html)
                    }
                }
            }
        })
    }
}

$(document).on("click", "#calculate_overall_btn", function () {
    let type = $("#talent_type").val()
    let money = $("#overall_pre_money_input").val()
    let video_length = $("#overall_video_length").val()
    let fm = new FormData()
    fm.append("type", type)
    fm.append("limitMony", money * 1000)
    fm.append("videoLength", video_length)
    $.ajax({
        url: "/calculate/calculate/all",
        type: "POST",
        data: fm,
        contentType: false,
        processData: false,
        success: function (data) {
            data.data.isJoin = false
            data.data.isOverAll = true
            let uniqueid = addHistoryBag(data.data)
            if (uniqueid) {
                removeFromMyNav(uniqueid)
            }
            showResult(1)
        }
    })
})

/*整合候选人和背包计算达人后获取数据*/
function getCandidateDataExtern() {
    let data = getCandidateListControl()
    let candidateData = null
    if (!data || data.currentNum == 0) {
        candidateData = getCandidateData(candidateField)
    } else {
        candidateData = getCandidateListControlIds(data.currentNum, data.currentType)
    }
    if (candidateData) {
        candidateData = getSplitePageData(candidateData, candidatePageField)
        return candidateData
    }
    return null
}


/*计算结果里显示达人列表按钮事件*/
$(document).on("click", "#show_talent_btn_play", function () {
    let index = $(this).attr('data-index')
    let div = $("#mynavs div")
    for (let i = 0; i < div.length; i++) {
        if ($(div[i]).attr('data-index') == index && $(div[i]).attr('data-type') == 1) {
            if ($(div[i]).attr('class') != "mynavAcitve") {
                console.log("show_talent_btn_play", $(div[i]).attr('data-index'))
                console.log($(div[i]).className)
                setCandidateListControlCurrentNum(index, 1)
                updateCandidatePanel(true)
                return
            }
        }
    }
    let data = getHistoryBagIndex(index)
    let ids = data.maxPlayNum.resultIds
    addCandidateListControl(index, ids, data.isOverAll, 1)
    updateCandidateControl(true)
})
/*计算结果里显示达人列表按钮事件 更好的效益比*/
$(document).on("click", "#optimization_show_talent_btn", function () {
    let index = $(this).attr('data-index')
    let div = $("#mynavs div")
    for (let i = 0; i < div.length; i++) {
        if ($(div[i]).attr('data-index') == index && $(div[i]).attr('data-type') == 2) {
            if ($(div[i]).attr('class') != "mynavAcitve") {
                console.log("optimization_show_talent_btn", $(div[i]).attr('data-index'))
                console.log($(div[i]).className)
                setCandidateListControlCurrentNum(index, 2)
                updateCandidatePanel(true)
                return
            }
        }
    }
    let data = getHistoryBagIndex(index)
    let ids = data.maxPriceOptimization.resultIds
    addCandidateListControl(index, ids, data.isOverAll, 2)
    updateCandidateControl(true)
})

function updateCandidateControl(isFirst) {
    updateCandidatePanel(isFirst)
    showActiveNav()
}