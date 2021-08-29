/*更新按钮状态*/
function updateBtnState() {
    let id = $(".add_candidate_btn").attr("data")
    if (isInCandidate(id, candidateField)) {
        $(".add_candidate_btn").text("移除候选")
        $(".add_candidate_btn").removeClass("btn-primary")
        $(".add_candidate_btn").addClass("btn-danger")
    } else {
        $(".add_candidate_btn").text("添加候选")
        $(".add_candidate_btn").removeClass("btn-danger")
        $(".add_candidate_btn").addClass("btn-primary")
    }
}

updateBtnState()
/*添加候选*/
$(document).on("click", ".add_candidate_btn", function () {
    let id = $(this).attr("data")
    let tempthis = this
    console.log($(tempthis).text().trim() == "添加候选")
    if ($(tempthis).text().trim() == "添加候选") {
        if (addCandidate(id, candidateField)) {
            $(tempthis).text("移除候选")
            $(tempthis).removeClass("btn-primary")
            $(tempthis).addClass("btn-danger")
        }
    } else if ($(tempthis).text().trim() == "移除候选") {
        if (subCandidate(id, candidateField)) {
            $(tempthis).text("添加候选")
            $(tempthis).removeClass("btn-danger")
            $(tempthis).addClass("btn-primary")
        }
    }
    update_candidate_show_num()
})
let thisid = $(".add_candidate_btn").attr("data")

/*粉丝增长趋势*/
$.ajax({
    url: "/profile/getFansChange/" + thisid,
    type: "GET",
    success: function (ajaxdata) {
        console.log(ajaxdata)
        if (ajaxdata.code == 200) {
            let data = ajaxdata.data
            let mydate = []
            for (let i = 0; i < data.length; i++) {
                mydate.push([data[i].checkTime, data[i].fanNum])
            }
            drawFanChange(mydate)
        }
    }
})

function drawFanChange(mydata) {
    var chart = Highcharts.chart('fans_incre_panel', {
        chart: {
            type: 'area'
        },
        title: {
            text: '粉丝增长趋势'
        },
        exporting: {
            enabled: false  //设置导出按钮不可用
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
                text: '粉丝人数'
            },
            labels: {
                formatter: function () {
                    return this.value / 10000 + 'w';
                }
            }
        },
        tooltip: {
            pointFormat: '粉丝：{point.y:,.0f}</b>人',
            dateTimeLabelFormats: {
                millisecond: '%Y-%m-%d',
                second: '%Y-%m-%d',
                minute: '%Y-%m-%d',
                hour: '%Y-%m-%d',
                day: '%Y-%m-%d',
                week: '%m-%d',
                month: '%Y-%m',
                year: '%Y'
            }
        },
        plotOptions: {},
        series: [{
            data: mydata
        }]
    });
}

/*最近播放量*/
$.ajax({
    url: "/profile/getVideoNum/" + thisid,
    type: "GET",
    success: function (data) {
        console.log(data)
        if (data.code == 200) {
            data = data.data
            mydata = []
            for (let i = 0; i < data.videoEntities.length; i++) {
                mydata.push([data.videoEntities[i].createTime * 1000, data.videoEntities[i].playNum])
            }
            drawVideoPlayNum(mydata, data.mid, data.standardDeviation)
        } else {

        }
    }
})

function drawVideoPlayNum(mydata, mid, standardDeviation) {
    standardDeviation = formatNumber(standardDeviation, 2, false, false)
    standardDeviation = formatToW(standardDeviation)
    var chart = Highcharts.chart('play_num_panel', {
        title: {
            text: '近15个视频播放量'
        },
        subtitle: {
            text: '标准差：' + standardDeviation
        },
        credits: {
            enabled: false
        },
        xAxis: {
            type: 'datetime',
            dateTimeLabelFormats: {
                millisecond: '%m-%d',
                second: '%m-%d',
                minute: '%m-%d',
                hour: '%m-%d',
                day: '%m-%d',
                week: '%m-%d',
                month: '%Y-%m',
                year: '%Y'
            },
        },
        tooltip: {
            dateTimeLabelFormats: {
                millisecond: '%Y-%m-%d',
                second: '%Y-%m-%d',
                minute: '%Y-%m-%d',
                hour: '%Y-%m-%d',
                day: '%Y-%m-%d',
                week: '%m-%d',
                month: '%Y-%m',
                year: '%Y'
            },
            formatter: function () {
                var s = "日期:" + formatDate(this.x) + '<br/> 播放量：' + formatToW(this.y);
                console.log(s)
                return s
            }
        },
        exporting: {
            enabled: false  //设置导出按钮不可用
        },
        yAxis: {
            title: {
                text: null
            },
            plotLines: [{   //一条延伸到整个绘图区的线，标志着轴中一个特定值。
                color: '#F45778',
                dashStyle: 'Dash', //Dash,Dot,Solid,默认Solid
                width: 1.5,
                value: mid,  //y轴显示位置
                zIndex: 5,
                label: {
                    text: '平均播放量:' + formatToW(mid),
                    align: 'right',
                    x: -10,
                    y: -15
                }
            }]
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle'
        },
        plotOptions: {
            series: {
                allowPointSelect: true
            },
            line: {
                dataLabels: {
                    // 开启数据标签
                    enabled: true
                },
                // 关闭鼠标跟踪，对应的提示框、点击事件会失效
                enableMouseTracking: true
            }
        },
        series: [{
            name: '播放量',
            data: mydata,
            marker: {//线上数据点
                radius: 2,
                lineWidth: 2,
                lineColor: '#fba845',
                fillColor: '#fba845',
                states: {
                    hover: {
                        enabled: false
                    }
                }
            }

        }],
        responsive: {
            rules: [{
                condition: {
                    maxWidth: 500
                },
                chartOptions: {
                    legend: {
                        layout: 'horizontal',
                        align: 'center',
                        verticalAlign: 'bottom'
                    }
                }
            }]
        }
    });
}

/*活跃度*/
$.ajax({
    url: "/profile/getActiveValue/" + thisid,
    type: "GET",
    success: function (ajaxdata) {
        console.log(ajaxdata)
        if (ajaxdata.code == 200) {
            data = ajaxdata.data
            drawActive(parseInt(data.fansCount), parseInt(data.realFansCount))
        }
    }
})

function drawActive(followerCount, realFollowerCount) {
    // 创建渐变色
    Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function (color) {
        return {
            radialGradient: {cx: 0.5, cy: 0.3, r: 0.7},
            stops: [
                [0, color],
                [1, Highcharts.Color(color).brighten(-0.3).get('rgb')] // darken
            ]
        };
    });
    // 构建图表
    var chart = Highcharts.chart('active_info', {
        chart: {
            height: 250,
        },
        title: {
            text: '粉丝活跃度分布'
        },
        exporting: {
            enabled: false  //设置导出按钮不可用
        },
        credits: {
            enabled: false
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%  </b>',
            formatter: function () {
                return this.series.name + ":" + formatNumber(this.percentage, 2, false, false) + '%  <br/>共' + formatToW(this.y * followerCount) + ' 人';
            }
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    },
                    connectorColor: 'silver'
                }
            }
        },
        series: [{
            type: 'pie',
            name: '比重',
            data: [
                {
                    name: '活跃',
                    y: realFollowerCount / followerCount,
                    sliced: true,
                    selected: true
                },
                ['非活跃', 1 - realFollowerCount / followerCount]
            ]
        }]
    });
}

