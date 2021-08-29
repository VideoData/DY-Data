const candidateField = "candidateFieldSession"
const lastCandidateField = "lastcandidateFieldSession"
const overlapField = "overlapField"
const lastCandidateAutoField = "lastCandidateAutoField"
const candidatePageField = "candidatePageField"
const lastCandidatePageField = "lastCandidatePageField"
const pagesize = 5
/*重合度面板逻辑*/
draw_chong_panel(0)

/*获取是否头像添加到重合度按钮*/
function updateChongAvatar() {
    data = getOverlapData(overlapField)
    if (data) {
        for (let i = 0; i < data.num; i++) {
            let user = data.user[i]
            addAvatarLink(user.link, user.nickname, user.id)
        }
    }
}

updateChongAvatar()
/*添加重合度*/
$(document).on("click", ".chonghe_btn", function (event) {
    event.stopPropagation()
    let tempthis = this
    event.preventDefault()
    let avatarLink = $(tempthis).next().text()
    let nickname = $(this).attr("data-id")
    let id = $(this).attr("data")
    if ($(this).attr('class').indexOf('btn-primary') >= 0) {
        let data = getOverlapData(overlapField)
        if (!data || data.num < 2) {
            if (addOverlapData(id, avatarLink, nickname, overlapField)) {
                $(tempthis).removeClass('btn-primary')
                $(tempthis).addClass("btn-danger")
                $(tempthis).text("已添加")
                addAvatarLink(avatarLink, nickname, $(this).attr("data"))
            }
        } else {
            alert("最多添加两位达人比较重合度")
        }
    } else {
        if (subOverlap($(this).attr("data"), overlapField)) {
            $(tempthis).removeClass("btn-danger")
            $(tempthis).addClass('btn-primary')
            $(tempthis).text("重合度")
            removeAvatarLink(avatarLink)
        }
    }
})

$(document).on('mouseenter', ".chong_author_img_div", function (event) {
    let nick = $(this).attr("data-contents")
    $("#show_nick_help").text(nick)
    $("#show_nick_help").css("display", "block")
})
$(document).on('mouseout', ".chong_author_img_div", function (event) {
    $("#show_nick_help").css("display", "none")
})

/*重合度按钮添加头像*/
function addAvatarLink(link, nickname, id) {
    console.log("addAvatarLink")
    $("#chong_btn_avatr").css("display", "block")
    let child = $("#chong_btn_avatr").children()
    let length = 0
    if (child) {
        length = child.length
    }
    let str = "<div style='background: url(" + link + ") no-repeat;background-size: cover;top: -5px;left: " + (length * 20 + 15) + "px;'  class=\"chong_author_img_div\" data-id=\"" + id + "\" data-contents=\"" + nickname + "\" data-src='" + link + "'></div>"
    let mstr = $("#chong_btn_avatr").html() + str
    $("#chong_btn_avatr").html(mstr)
}

/**
 * 从重合度中删除头像链接
 * @param link
 */
function removeAvatarLink(link) {
    $("#chong_btn_avatr>div").each((index, e) => {
        if (String($(e).css("background")).indexOf(link) > 0) {
            $(e).remove()
            return
        }
    })
    if ($("#chong_btn_avatr").children().length == 0) {
        $("#chong_btn_avatr").css("display", "none")
    }
}

$("#chong_btn").click((e) => {
    console.log("点击重合度面板")
    console.log(e.target.className)
    if (e.target.className == "chong_author_img_div") {
        return
    }
    let p = $("#chong_btn").parent()
    let right = parseInt(p.css("right"))
    console.log(right)
    if (right > 1) {
        p.css("right", "0px")
    } else {
        let data = getOverlapData(overlapField)
        if (data && data.num == 2) {
            let str = ''
            for (let i = 0; i < data.num; i++) {
                str = str + data.user[i].id + ","
            }
            str.substr(0, str.length - 1)
            // alert(str)
            let fd = new FormData()
            fd.append("data", str)
            /*获取重合度值*/
            $.ajax({
                url: "/userinfo/getOverlap",
                type: 'POST',
                data: fd,
                contentType: false,
                processData: false,
                success: function (data) {
                    if (data.code == 200) {
                        draw_chong_panel(data.data)
                    } else {
                        draw_chong_panel(0)
                    }
                }
            })
        } else {
            draw_chong_panel(0)
        }
        let width = $("#chong_btn").next().css("width")
        p.css("right", width)
    }
})

function draw_chong_panel(data) {
    if (data == 0) {
        /*默认粉丝重合韦恩图*/
        Highcharts.chart('fan_press_panel', {
            series: [{
                type: 'venn',
                name: '请选择达人来查看粉丝重合度分布',
                data: [{
                    sets: ['达人A'],
                    value: 2,
                    name: '达人A 50%'
                }, {
                    sets: ['达人B'],
                    value: 3,
                    name: '达人B 66%'
                }, {
                    sets: ['达人A', '达人B'],
                    value: 1,
                    name: '重合区域粉丝'
                }]
            }],
            title: {
                text: '<h2>达人A</h2>和达人B的粉丝重合度分布',
                style: {
                    fontSize: '12px'
                }
            },
            exporting: {
                enabled: false
            }
        });
    } else {
        let a = 100 - data.overlapValue * 100 / data.talendaFanNum
        let b = 100 - data.overlapValue * 100 / data.talendbFanNum
        a = a.toFixed(2).toString() + "%"
        b = b.toFixed(2).toString() + "%"
        Highcharts.chart('fan_press_panel', {
            series: [{
                type: 'venn',
                name: '粉丝重合度分布',
                data: [{
                    sets: [data.userInfoEntitya.nickName],
                    value: data.talendaFanNum,
                    name: data.userInfoEntitya.nickName + " " + a
                }, {
                    sets: [data.userInfoEntityb.nickName],
                    value: data.talendbFanNum,
                    name: data.userInfoEntityb.nickName + " " + b
                }, {
                    sets: [data.userInfoEntitya.nickName, data.userInfoEntityb.nickName],
                    value: data.overlapValue,
                    name: '重合区域粉丝'
                }]
            }],
            title: {
                text: data.userInfoEntitya.nickName + '和' + data.userInfoEntityb.nickName + '的粉丝重合度分布',
                style: {
                    fontSize: '12px'
                }
            },
            exporting: {
                enabled: false
            }
        });
    }
}

function update_candidate_show_num() {
    let num = getCandidateNum(candidateField)
    if (num == 0) {
        $("#badge_num").text("")
    } else {
        $("#badge_num").text(num)
    }
}

/*手动更新一次*/
update_candidate_show_num()

function timestampLoseHour(timestamp) {
    let beijing_datetime = new Date(parseInt(timestamp) * 1000).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
    let year_month_day = beijing_datetime.split(" ")[0]
    timestamp = new Date(Date.parse(year_month_day + " 00:00:00"));
    timestamp = timestamp.getTime();
    timestamp = timestamp / 1000;
    return timestamp
}


/*显示星图数据小工具*/
$(document).on('mouseenter', ".fans_show", function (event) {
    $(this).next().css("display", "block")
})
$(document).on('mouseout', ".fans_show", function (event) {
    $(this).next().css("display", "none")
})

/*重合度头像动画*/
initAnimalChongAvatar()

function initAnimalChongAvatar() {
    let startTop = -1
    let startLeft = -1
    let endX = -1
    let endY = -1
    //定义一个变量判断是否执行移动函数
    let mouseDown = false;
    let tempTarget
    $(document).on('mousedown', ".chong_author_img_div", function (e) {
        e.preventDefault()
        //按下时为ture,松开时为false，以判断是否执行执行mouveDiv
        mouseDown = true;
        startTop = $(this).css("top")
        startLeft = $(this).css("left")
        tempTarget = this
    })
    $(document).mousemove(function (e) {
            if (mouseDown) {
                let width = $(tempTarget).width();
                let height = $(tempTarget).height();
                endX = e.pageX - $("#chong_btn_avatr").offset().left;
                endY = e.pageY - $("#chong_btn_avatr").offset().top;
                tempTarget.style.left = (endX - width / 2) + "px";
                tempTarget.style.top = (endY - height / 2) + "px";
            }
        }
    )
    $(document).on('mouseup', ".chong_author_img_div", function (e) {
        console.log("鼠标放開")
        e.preventDefault()
        if (mouseDown) {
            let distance = Math.pow(Math.pow(endX, 2) + Math.pow(endY, 2), 0.5)
            console.log("distance", distance)
            if (distance > 50) {
                let id = $(this).attr("data-id")
                if (subOverlap(id, overlapField)) {
                    removeAvatarLink($(this).attr("data-src"))
                    $("#show_nick_help").css("display", "none")
                    let btns = $(".chonghe_btn")
                    for (let i = 0; i < btns.length; i++) {
                        if ($(btns[i]).attr("data") == id) {
                            $(btns[i]).removeClass("btn-danger")
                            $(btns[i]).addClass('btn-primary')
                            $(btns[i]).text("重合度")
                            break
                        }
                    }
                }
            } else {
                $(this).css("top", startTop)
                $(this).css("left", startLeft)
            }
        }
        mouseDown = false;
    })
}

function initAnimalChongAvatar2() {
    var divs = document.querySelector('#chong_btn_avatr>img');
    console.log("divs", divs)
    //元素的鼠标落下事件
    divs.onmousedown = function (ev) {
        //event的兼容性
        var ev = ev || event;

        //获取鼠标按下的坐标
        var x1 = ev.clientX;
        var y1 = ev.clientY;

        //获取元素的left，top值
        var l = divs.offsetLeft;
        var t = divs.offsetTop;

        //给可视区域添加鼠标的移动事件
        document.onmousemove = function (ev) {

            //event的兼容性
            var ev = ev || event;

            //获取鼠标移动时的坐标
            var x2 = ev.clientX;
            var y2 = ev.clientY;

            //计算出鼠标的移动距离
            var x = x2 - x1;
            var y = y2 - y1;

            //移动的数值与元素的left，top相加，得出元素的移动的距离
            var lt = y + t;
            var ls = x + l;

            //更改元素的left，top值
            divs.style.top = lt + 'px';
            divs.style.left = ls + 'px';
        }

        //清除
        document.onmouseup = function (ev) {
            document.onmousemove = null;
        }

    }
}