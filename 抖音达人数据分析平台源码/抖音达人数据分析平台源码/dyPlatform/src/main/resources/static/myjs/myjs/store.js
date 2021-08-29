const defaultPage = 1
const defaultPagesize = 10

/*========达人列表相关=========*/
function addCandidate(id, field) {
    candidates = sessionStorage.getItem(field)
    if (!candidates) {
        candidates = {"num": 1, "ids": [id]}
        sessionStorage.setItem(field, JSON.stringify(candidates))
        return true
    } else {
        candidates = JSON.parse(candidates)
        flag = false
        for (let i = 0; i < candidates.ids.length; i++) {
            if (candidates.ids[i] == id) {
                flag = true
                break
            }
        }
        if (!flag) {
            candidates.num = candidates.num + 1
            candidates.ids.push(id)
            sessionStorage.setItem(field, JSON.stringify(candidates))
            return true
        }
    }
    return false
}

/*从数据中移除所选id*/
function subCandidate(id, field) {
    candidates = sessionStorage.getItem(field)
    if (!candidates) {
        return false
    } else {
        candidates = JSON.parse(candidates)
        candidates.num = candidates.num - 1
        length = candidates.ids.length
        candidates.ids = candidates.ids.filter(function (item) {
            return item != id
        });
        if (candidates.num > 0) {
            sessionStorage.setItem(field, JSON.stringify(candidates))
        } else {
            sessionStorage.removeItem(field)
        }
        return length != candidates.ids.length
    }
    return false
}

function getCandidateNum(field) {
    candidates = sessionStorage.getItem(field)
    if (!candidates) {
        return 0
    } else {
        candidates = JSON.parse(candidates)
        return candidates.num
    }
}

function isInCandidate(id, field) {
    candidates = sessionStorage.getItem(field)
    if (candidates) {
        candidates = JSON.parse(candidates)
        for (let i = 0; i < candidates.ids.length; i++) {
            if (id == candidates.ids[i]) {
                return true
            }
        }
    }
    return false
}

function getCandidateData(field) {
    candidates = sessionStorage.getItem(field)
    if (!candidates) {
        return false
    } else {
        candidates = JSON.parse(candidates)
        return candidates.ids
    }
}

/*========本地搜索分页相关=========*/
function savePage(num, field) {
    data = sessionStorage.getItem(field)
    if (!data) {
        data = {"size": pagesize, "page": num}
    } else {
        data = JSON.parse(data)
        data.page = num
    }
    sessionStorage.setItem(field, JSON.stringify(data))
}

function getpage(field) {
    data = sessionStorage.getItem(field)
    if (!data) {
        return 1
    } else {
        data = JSON.parse(data)
        return data.page
    }
}

function setPageSize(size, field) {
    data = sessionStorage.getItem(field)
    if (!data) {
        data = {"size": size, "page": 1}
    } else {
        data = JSON.parse(data)
        data.size = size
    }
    sessionStorage.setItem(field, JSON.stringify(data))
}

function getPageSize(field) {
    data = sessionStorage.getItem(field)
    if (!data) {
        return pagesize
    } else {
        data = JSON.parse(data)
        return data.size
    }
}

/*========重合度相关=========*/
function addOverlapData(id, link, nickname, field) {
    overlapData = sessionStorage.getItem(field)
    if (!overlapData) {
        overlapData = {
            "num": 1,
            "user": [{
                "id": id,
                "link": link,
                "nickname": nickname
            }
            ]
        }
        sessionStorage.setItem(field, JSON.stringify(overlapData))
        return true
    } else {
        overlapData = JSON.parse(overlapData)
        flag = false
        for (let i = 0; i < overlapData.user.length; i++) {
            if (overlapData.user[i].id == id) {
                flag = true
                break
            }
        }
        if (overlapData.num == 2) {
            return false
        }
        if (!flag) {
            overlapData.num = overlapData.num + 1
            overlapData.user.push({
                "id": id,
                "link": link,
                "nickname": nickname
            })
            sessionStorage.setItem(field, JSON.stringify(overlapData))
            return true
        }
    }
    return false
}

function subOverlap(id, field) {
    data = sessionStorage.getItem(field)
    if (!data) {
        return false
    } else {
        data = JSON.parse(data)
        data.num = data.num - 1
        length = data.user.length
        data.user = data.user.filter(function (item) {
            return item.id != id
        });
        if (data.num > 0) {
            sessionStorage.setItem(field, JSON.stringify(data))
        } else {
            sessionStorage.removeItem(field)
        }
        return length != data.user.length
    }
    return false
}

function getOverlapData(field) {
    data = sessionStorage.getItem(field)
    if (!data) {
        return false
    } else {
        return JSON.parse(data)
    }
}

function isInOverlap(id, field) {
    data = sessionStorage.getItem(field)
    if (data) {
        data = JSON.parse(data)
        for (let i = 0; i < data.num; i++) {
            if (id == data.user[i].id) {
                return true
            }
        }
    }
    return false
}

/*========复杂搜索相关=========*/
const mutilSearchField = "mutilSearchField"
const mutilSearchType = "type"
const mutilSearchValue = "value"
const mutilSearchFans = "fans"

function mutilSearchSetKeyword(Keyword) {
    data = sessionStorage.getItem(mutilSearchField)
    if (data) {
        data = JSON.parse(data)
        data.page = defaultPage
        data.size = defaultPagesize
        data.keyWord = Keyword
        sessionStorage.setItem(mutilSearchField, JSON.stringify(data))
    }
}

function mutilSearchSetpage(page) {
    data = sessionStorage.getItem(mutilSearchField)
    if (data) {
        data = JSON.parse(data)
        data.page = page
        sessionStorage.setItem(mutilSearchField, JSON.stringify(data))
    }
}

function mutilSearchSetSortwod(sortword) {
    data = sessionStorage.getItem(mutilSearchField)
    if (data) {
        data = JSON.parse(data)
        data.page = defaultPage
        data.size = defaultPagesize
        data.sortWord = sortword
        sessionStorage.setItem(mutilSearchField, JSON.stringify(data))
    }
}

function mutilSearchSetIsDESC(isDESC) {
    data = sessionStorage.getItem(mutilSearchField)
    if (data) {
        data = JSON.parse(data)
        data.page = defaultPage
        data.size = defaultPagesize
        data.isDESC = isDESC
        sessionStorage.setItem(mutilSearchField, JSON.stringify(data))
    }
}

function mutilSearchClear() {
    data = sessionStorage.getItem(mutilSearchField)
    if (data) {
        data = JSON.parse(data)
        data.page = defaultPage
        data.size = defaultPagesize
        data.fans = []
        data.value = []
        data.type = []
        sessionStorage.setItem(mutilSearchField, JSON.stringify(data))
    }
}

function mutilSearchSetAdd(item, type) {
    data = sessionStorage.getItem(mutilSearchField)
    if (data) {
        data = JSON.parse(data)
        data.page = defaultPage
        data.size = defaultPagesize
        if (type == mutilSearchFans) {
            fan = data.fans
            for (let i = 0; i < fan.length; i++) {
                if (fan[i] == item) {
                    return
                }
            }
            data.fans.push(item)
        } else if (type == mutilSearchType) {
            type = data.type
            for (let i = 0; i < type.length; i++) {
                if (type[i] == item) {
                    return
                }
            }
            data.type.push(item)
        } else if (type == mutilSearchValue) {
            value = data.value
            for (let i = 0; i < value.length; i++) {
                if (value[i] == item) {
                    return
                }
            }
            data.value.push(item)
        }

        sessionStorage.setItem(mutilSearchField, JSON.stringify(data))
    }
}

function mutilSearchSetSub(item, type) {
    data = sessionStorage.getItem(mutilSearchField)
    if (data) {
        data = JSON.parse(data)
        data.page = defaultPage
        data.size = defaultPagesize
        if (type == mutilSearchFans) {
            fan = data.fans
            for (let i = 0; i < fan.length; i++) {
                if (fan[i] == item) {
                    delete data.fans[i]
                    break
                }
            }
        } else if (type == mutilSearchType) {
            type = data.type
            for (let i = 0; i < type.length; i++) {
                if (type[i] == item) {
                    delete data.fans[i]
                    break
                }
            }
        } else if (type == mutilSearchValue) {
            value = data.value
            for (let i = 0; i < value.length; i++) {
                if (value[i] == item) {
                    delete data.fans[i]
                    break
                }
            }
        }
        sessionStorage.setItem(mutilSearchField, JSON.stringify(data))
    }
}

function mutilSearchGetData() {
    data = sessionStorage.getItem(mutilSearchField)
    if (data) {
        return JSON.parse(data)
    } else {
        return false
    }
}

function mutilSearchSetPlatform(platform) {
    data = sessionStorage.getItem(mutilSearchField)
    if (data) {
        data = JSON.parse(data)
        data.platform = platform
        sessionStorage.setItem(mutilSearchField, JSON.stringify(data))
    }
}

function mutilSearchGetPlatform(platform) {
    data = sessionStorage.getItem(mutilSearchField)
    if (data) {
        data = JSON.parse(data)
        return data.platform
    } else {
        return 1
    }
}

function mutilSearchReset() {
    sessionStorage.removeItem(mutilSearchField)
    data = {
        "keyWord:": null,
        "sortWord": null,
        "isDESC": true,
        "page": defaultPage,
        "size": defaultPagesize,
        "type": [],
        "value": [],
        "fans": [],
        "platform": 1,
    }
    sessionStorage.setItem(mutilSearchField, JSON.stringify(data))
}

/*根据本地复杂搜索数据刷新表*/
function refreshUserTabel(str = 1) {
    let data = mutilSearchGetData()
    let fd = new FormData();
    fd.append("data", JSON.stringify(data))
    if (data) {
        $.ajax({
            url: "/index/mutilSearch",
            data: fd,
            type: "POST",
            processData: false,  // 不处理数据
            contentType: false,   // 不设置内容类型
            success: function (data) {
                $('#data_panel').html(data);
                updateIndexBtnState()
                if (str != 1) {
                    activeSort(str)
                }
            }
        })
    }
}

/*处理添加是否已经添加或者重合度*/
function updateIndexBtnState() {
    $(".add_candidate_btn").each((index, item) => {
        let id = $(item).attr("data")
        if (isInCandidate(id, candidateField)) {
            $(item).text("移除")
            $(item).removeClass("btn-primary")
            $(item).addClass("btn-danger")
            $("#badge_num").text(getCandidateNum(candidateField))
        }
    })
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
    $(".chonghe_btn").each((index, item) => {
        let id = $(item).attr("data")
        if (isInOverlap(id, overlapField)) {
            $(item).removeClass('btn-primary')
            $(item).addClass("btn-danger")
            $(item).text("已添加")
        }
    })
}

/*修改排序按钮状态*/
function activeSort(str1) {
    $("#price_sort").css("color", "")
    $("#default_sort").css("color", "")
    $("#fans_sort").css("color", "")
    $("#" + str1).css("color", "#f45778")
}

/*结算页面的背包计算的历史数据存储*/
const historyBagPrefix = "historyBagPrefix"

/**
 *  添加历史记录，当存有超过5个的历史记录时，会返回移除的历史记录的uniqueid
 * @param indata
 * @returns {null}
 */
function addHistoryBag(indata) {
    let alldata = sessionStorage.getItem(historyBagPrefix)
    let result = false
    if (alldata) {
        alldata = JSON.parse(alldata)
        alldata.lastNum = alldata.lastNum + 1
        alldata.data.unshift(indata)
        if (alldata.num == 5) {
            result = alldata.lastNum - alldata.num
        } else {
            alldata.num = alldata.num + 1
        }
        sessionStorage.setItem(historyBagPrefix, JSON.stringify(alldata))
    } else {
        alldata = {
            lastNum: 1, //最新的次数
            num: 1, //保存的次数
            data: [indata],
        }
        sessionStorage.setItem(historyBagPrefix, JSON.stringify(alldata))
    }
    return result
}

function getHistoryBag() {
    let alldata = sessionStorage.getItem(historyBagPrefix)
    if (alldata) {
        return JSON.parse(alldata)
    } else {
        return null
    }
}

function getHistoryBagIndex(lastNum) {
    let alldata = sessionStorage.getItem(historyBagPrefix)
    if (alldata) {
        alldata = JSON.parse(alldata)
        lastNum = alldata.lastNum - lastNum
        return alldata.data[lastNum]
    } else {
        return null
    }
}

function setHistoryBagIsJoin(uniqueid, isJoin) {
    let alldata = sessionStorage.getItem(historyBagPrefix)
    if (alldata) {
        alldata = JSON.parse(alldata)
        uniqueid = alldata.lastNum - uniqueid
        alldata.data[uniqueid].isJoin = JSON
        sessionStorage.setItem(historyBagPrefix, JSON.stringify(alldata))
    }
}

/*候选列表控制*/
const candidateListControl = "Candidatelistcontrol"

function addCandidateListControl(uniqueid, ids, isOverAll, type) {
    let alldata = sessionStorage.getItem(candidateListControl)
    let indata = {
        isOverAll: isOverAll,
        uniqueid: uniqueid,
        ids: ids,
        type: type   //是不是自动最优的结果
    }
    if (alldata) {
        alldata = JSON.parse(alldata)
        for (let i = 0; i < alldata.data.length; i++) {
            if (alldata.data[i].uniqueid == uniqueid&&alldata.data[i].type == type) {
                return
            }
        }
        if (alldata.num > 5) {
            alldata.data[1]
        } else {
            alldata.num++;
        }
        alldata.data.push(indata)
        alldata.page = 1
        alldata.size = 5
        alldata.currentNum = uniqueid
        alldata.currentType = type
    } else {
        alldata = {
            num: 1,
            currentType: type,      // 1 是播放量最优，2是效益比最优
            currentNum: uniqueid,   //若是0,则表示显示获选达人
            page: 1,
            size: 5,
            data: [indata]
        }
    }
    sessionStorage.setItem(candidateListControl, JSON.stringify(alldata))
}

function getCandidateListControl() {
    let alldata = sessionStorage.getItem(candidateListControl)
    if (alldata) {
        return JSON.parse(alldata)
    } else {
        return null
    }
}

function setCandidateListControlCurrentNum(currentNum, type) {
    let alldata = sessionStorage.getItem(candidateListControl)
    if (alldata) {
        alldata = JSON.parse(alldata)
        alldata.currentNum = currentNum
        alldata.currentType = type
        sessionStorage.setItem(candidateListControl, JSON.stringify(alldata))
    }
}

/**
 * 从本地存储的候选达人区域的控制数据中删除指定uniqueid的ids
 * @param uniqueid
 * @returns {boolean}
 */
function removeCandidateListControl(uniqueid, type) {
    let alldata = sessionStorage.getItem(candidateListControl)
    if (alldata) {
        alldata = JSON.parse(alldata)
        for (let i = 0; i < alldata.data.length; i++) {
            if (alldata.data[i].uniqueid == uniqueid && alldata.data[i].type == type) {
                alldata.num = alldata.num - 1;
                alldata.data.splice($.inArray(alldata.data[i], alldata.data), 1);
                if (alldata.currentNum == uniqueid) {
                    alldata.currentNum = 0
                    alldata.currentType = 1
                    alldata.page = 1
                    alldata.size = 5
                }
                sessionStorage.setItem(candidateListControl, JSON.stringify(alldata))
                return true
            }
        }
    }
    return false
}

/**
 *从本地存储的候选达人区域的控制数据中返回指定uniqueid的ids
 * @param uniqueid
 * @returns {null|*}
 */
function getCandidateListControlIds(uniqueid, type) {
    let alldata = sessionStorage.getItem(candidateListControl)
    if (alldata) {
        alldata = JSON.parse(alldata)
        for (let i = 0; i < alldata.data.length; i++) {
            if (alldata.data[i].uniqueid == uniqueid && alldata.data[i].type == type) {
                return alldata.data[i].ids
            }
        }
    }
    return null
}

/**
 *从本地存储的候选达人区域的控制数据中返回指定uniqueid的ids的数量，长度
 * @param uniqueid
 * @returns {number|*}
 */
function getCandidateListControlIdsNum(uniqueid, type) {
    let alldata = sessionStorage.getItem(candidateListControl)
    if (alldata) {
        alldata = JSON.parse(alldata)
        for (let i = 0; i < alldata.data.length; i++) {
            if (alldata.data[i].uniqueid == uniqueid && alldata.data[i].type == type) {
                return alldata.data[i].ids.length
            }
        }
    }
    return 0
}