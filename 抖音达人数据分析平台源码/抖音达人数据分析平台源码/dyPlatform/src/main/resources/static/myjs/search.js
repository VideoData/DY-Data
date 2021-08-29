(function ($, window, document, undefined) {
    let tempopt
    $.fn.SEarch = function (opt) {
        tempopt = opt
        var mymydata
        $.ajax({
            url: "/multiSearch/getall",
            type: "get",
            async: false,
            success: function (mydata) {
                if (mydata.code == 200) {
                    mymydata = mydata.data
                    console.log("-----高级选项----")
                    console.log(mydata.data)
                } else {
                    alert("获取删选数据错误")
                }
            }
        })
        var argument = {
            //数据地址
            url: '',
            data: mymydata,
            searfunc: searfunc
        };
        //Selecty实列化
        var selecty = new SElecty(this, opt);
        if (opt && $.isEmptyObject(opt) == false) {
            selecty.options = $.extend(argument, opt);
        } else {
            selecty.options = argument;
        }

        function searfunc(arr) {

        }

        selecty.render();
    }

    function initShow() {

    }

    /*查询数据，刷新列表*/
    function refreshTabel(data) {
        /*搜索插件 [{"val":["美食","汽车"],"key":"内容类型"},{"val":["1w-5w"],"key":"价值"}]*/
        mutilSearchClear()
        for (let i = 0; i < data.length; i++) {
            let val = ''
            if (data[i].key == "内容类型") {
                val = data[i].val
                for (let j = 0; j < val.length; j++) {
                    mutilSearchSetAdd(val[j], mutilSearchType)
                }
            }
            if (data[i].key == "价值") {
                val = data[i].val
                for (let j = 0; j < val.length; j++) {
                    mutilSearchSetAdd(val[j], mutilSearchValue)
                }
            }
            if (data[i].key == "粉丝数") {
                val = data[i].val
                for (let j = 0; j < val.length; j++) {
                    mutilSearchSetAdd(val[j], mutilSearchFans)
                }
            }
        }

        for (let i = 0; i < data.length; i++) {
            if (data[i].key.indexOf("内容类型") != -1) {
                $("#type_property_btn").attr("data", data[i].val[0])
                getPlatformDataTypeUser()
            }
        }
        refreshUserTabel()
    }

    function pushSearchcondi(key, val) {
        self.searchcondi.push(key, val)
    }

    //依赖构造函数
    var SElecty = function (vessel, opt) {
        this.$vessel = vessel;
        this.options = opt;
    };
    SElecty.prototype = {
        render: function () {
            var self = this;
            this.lastmore = "";
            self.lastmore = this.lastmore;
            self.wrap = this.$vessel;
            $(self.wrap).html("<div class='w'></div>");
            this.searcon = $(self.wrap).children(".w");
            this.searcon.append("<div class='searchcon-w'></div>");
            this.seartextcon = this.searcon.children(".searchcon-w");
            self.navrende();
            self.advanrender();
            self.moremulti();
            self.searchcondi = tempopt.searchcondimm;

            $(".w").on("click", ".selecbaseul li", function () {
                var obj = {};
                obj.val = [];
                if ($(this).parent().hasClass("selector")) {
                    return false;
                } else {
                    var inds = $(this).parent().parent().index();
                    var key = $(this).parent().parent().parent().siblings(".con-value").children(".sele-adve-tab").children(".seleadve-itemwrap").children("a").eq(inds).attr("title");
                    var val = $(this).children("a").attr("title");
                    var arr = self.searchcondi;
                    var repetkey = 0;
                    var repetval = 0;
                    for (var i = 0; i < arr.length; i++) {
                        if (arr[i].key == key) {
                            repetkey = 1;
                            for (var j = 0; j < arr[i].val.length; j++) {
                                if (arr[i].val[j] == val) {
                                    repetval = 1;
                                    break;
                                }
                            }
                            if (repetval == 1) {
                                alert("条件已选")
                            } else {
                                self.searchcondi[i].val.push(val);
                                refreshTabel(self.searchcondi)

                                $(".crumb").children(".crumbcondiwrap").children("span").each(function () {
                                    var datake = $(this).children("b").attr("data-key");
                                    if (datake == key) {
                                        var orht = $(this).children("em").html();
                                        $(this).children("em").html(orht + "、" + val)
                                    }
                                })
                            }
                            break;

                        }


                    }
                    if (repetkey == 0 && repetval == 0) {
                        obj.key = key;
                        obj.val.push(val);
                        self.searchcondi.push(obj);
                        refreshTabel(self.searchcondi)
                        $(".crumb").children(".crumbcondiwrap").append("<span class='chosexuanxiang'><b data-key=" + key + ">" + key + "：</b><em>" + val + "</em><i></i></span>");
                    }

                    var navaa = self.searchcondi;

                    // self.options.callback.abiqiancli(navaa);
                }

            })
            $(".w").on("click", ".chosexuanxiang i", function () {
                var key = $(this).siblings("b").attr("data-key");
                $.each(self.searchcondi, function (i, og) {
                    if (self.searchcondi[i].key == key) {
                        self.searchcondi.splice(i, 1);
                        refreshTabel(self.searchcondi)
                        return false;
                    }
                })
                $(this).parent("span").remove();

            })

        },
        datatalke: function () {
            var self = this;
            var url = self.options.url;
            $.ajax({
                type: "GET",
                url: url,
                dataType: "json",
                success: function (data) {
                    var musjsdata = JSON.stringify(data);
                    var desjsdata = jQuery.parseJSON(musjsdata);
                    var key = "rootconditions";
                    var keyb = "childconditions";
                    var keyc = "advancecondition"
                    self.options.data = {};
                    self.options.data.rootconditions = desjsdata[key];
                    self.options.data.childconditions = desjsdata[keyb];
                    self.options.data.advancecondition = desjsdata[keyc];
                    console.log("test", self.options.data)
                    if (self.options.data) {
                        self.render();
                    }

                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    // 状态码
                    console.log(XMLHttpRequest.status);
                    // 状态
                    console.log(XMLHttpRequest.readyState);
                    // 错误信息   
                    console.log(textStatus);
                }

            });
        },
        navrende: function () {
            var self = this;
            self.wrap = this.$vessel;
            var $navsr = $("<div class='crumbs-nav'></div>");
            var olstr = "<ol class='crumb'>"
            //<a class='allsubmit'>查询</a>
            olstr += "<li class='crumbcondiwrap'></li></ol>"
            $navsr.append(olstr);
            /*todo   注意修改css，位置有问题*/
            self.searcon.prepend($navsr);
            // self.searcon.append($navsr);
            $(".allsubmit").on("click", function () {
                var arr = self.searchcondi;
                self.options.searfunc(arr);
            });

        },


        advanrender: function () {
            var self = this;
            var advancecondition = this.options.data.advancecondition;
            var $div = $("<div class='yseach sele-advencesele'></div>");
            var $conwe = $("<div class='con-wrap ovefl-visi'></div>");
            $conwe.append("<div style='font-weight: bold' class='con-key' >" + advancecondition.title + "</div>")
            var conva = $("<div class='con-value'></div>");
            var nomust = $("<div class='sele-adve-tab'></div>")
            var $triggxuwr = $("<div class='seleadve-itemwrap'></div>");
            var $traggconwrap = $("<div class='sele-adve-con'></div>")
            var advancedata = advancecondition.val;
            for (var i = 0; i < advancedata.length; i++) {
                var title = advancedata[i].value.title;
                $triggxuwr.append("<a class='seleadve-itemaaa' href='#' title=" + title + ">" + title + "<i class='arrow'></i></a>");

                var str = "<div class='seleadvecon-item' data-title=" + title + "><ul class='selecbaseul'>"
                var subdataadve = advancedata[i].value.val;
                for (var j = 0; j < subdataadve.length; j++) {
                    str += "<li>" +
                        "<a href='#' title=" + subdataadve[j] + ">" +
                        "<i></i>" + subdataadve[j] + "</a>" +
                        "</li>"
                }
                str += "</ul>";

                if (advancedata[i].multiselect || advancedata[i].multiselect == undefined) {
                    str += "<div class='yseah-ext'>" +
                        "<a href='#'class='ys-e-multi multiposition single'>多选<i></i>" + "</a></div>";
                    str += "<div class='ybtnwrap'>" +
                        "<button type='button' class='ybtn ybtn-sure'>确定</button>" +
                        "<button type='button' class='ybtn snb ybtncancel'>取消</button></div>"
                } else {

                }
                $traggconwrap.append(str + "</div> ");
            }

            nomust.append($triggxuwr);
            conva.append(nomust);
            $conwe.append(conva);
            $conwe.append($traggconwrap);
            $div.append($conwe);
            self.seartextcon.append($div);
            advcustom();

            function advcustom() {
                var t, t1;
                $(".seleadve-itemwrap a").hover(function () {
                    clearTimeout(t);
                    clearTimeout(t1);
                    $(this).addClass("tre-acrr")
                    $(this).siblings("a").removeClass("tre-acrr");
                    var title = $(this).attr("title");
                    $(".sele-adve-con .seleadvecon-item").each(function () {
                        $(this).hide();
                        if ($(this).attr("data-title") == title) {
                            $(this).show();
                        }
                    })
                }, function () {
                    var sea;
                    var title = $(this).attr("title");
                    $(".sele-adve-con .seleadvecon-item").each(function () {
                        if ($(this).attr("data-title") == title) {
                            sea = $(this);
                        }
                    })
                    var se = $(this);

                    $(sea).children(".ybtnwrap").children(".ybtncancel").trigger("click");

                    function settim(op, opa) {
                        var opl = op;
                        t = setTimeout(function () {
                            $(opl).removeClass("tre-acrr");
                            $(opa).hide();
                        }, 500);
                    }

                    settim(se, sea)

                })
                $(".sele-adve-con .seleadvecon-item").hover(function () {
                    clearTimeout(t);
                    var title = $(this).attr("data-title");
                    $(".seleadve-itemwrap .seleadve-itemaaa").each(function () {
                        if ($(this).attr("title") == title) {
                            $(this).addClass("tre-acrr");
                        }
                    })
                }, function () {
                    var sea;
                    var title = $(this).attr("data-title");
                    $(".seleadve-itemwrap .seleadve-itemaaa").each(function () {
                        if ($(this).attr("title") == title) {
                            sea = $(this);
                        }
                    })
                    var se = $(this);
                    $(se).children(".ybtnwrap").children(".ybtncancel").trigger("click");

                    function setbbbtime(op, opa) {
                        t1 = setTimeout(function () {
                            $(op).removeClass("tre-acrr");
                            $(opa).hide();
                        }, 500);
                    }

                    setbbbtime(sea, se);

                })

            }
        },
        moremulti: function () {
            var self = this;
            $(".ys-e-multi").on("click", function () {
                if ($(this).hasClass("single")) {
                    $(this).parent().siblings(".ybtnwrap").show();
                    $(this).parent().siblings(".selecbaseul").addClass("selector");
                    nlliselcli();
                    $(this).parent().hide();
                }
            })
            btn();

            function nlliselcli() {
                self.temobj = [];
                $(".selector li").on("click", function () {
                    if ($(this).hasClass("selected")) {
                        $(this).removeClass("selected");
                        var title = $(this).children("a").attr("title");
                        $.each(self.temobj, function (i, og) {
                            if (title == og) {
                                self.temobj.splice(i, 1);
                            }
                        })
                    } else {
                        var title = $(this).children("a").attr("title");
                        self.temobj.push(title);
                        $(this).addClass("selected");
                    }
                })

            }

            function btn() {
                $(".ybtn-sure").on("click", function () {
                    var inds = $(this).parent().parent().index();
                    var key = $(this).parent().parent().parent().siblings(".con-value").children(".sele-adve-tab").children(".seleadve-itemwrap").children("a").eq(inds).attr("title");
                    var arr = self.searchcondi;
                    var keyexist = 0;
                    if (arr.length > 0) {
                        for (var i = 0; i < arr.length; i++) {
                            if (arr[i].key == key) {
                                keyexist = 1;
                                self.searchcondi[i].val = self.temobj;
                                $(".crumb").children(".crumbcondiwrap").children("span").each(function () {
                                    var datake = $(this).children("b").attr("data-key");
                                    if (datake == key) {
                                        var str = "";
                                        $(this).children("em").html("");
                                        for (var i = 0; i < self.temobj.length; i++) {
                                            if (i < self.temobj.length - 1) {
                                                str += self.temobj[i] + "、";
                                            } else {
                                                str += self.temobj[i];
                                            }
                                        }
                                        $(this).children("em").html(str);
                                        return false;

                                    }
                                })
                            }

                        }
                        if (keyexist == 0) {
                            var str = '';
                            for (var i = 0; i < self.temobj.length; i++) {
                                if (i < self.temobj.length - 1) {
                                    str += self.temobj[i] + "、";
                                } else {
                                    str += self.temobj[i];
                                }
                            }
                            var obj = {};
                            obj.key = key;
                            obj.val = self.temobj;
                            self.searchcondi.push(obj)
                            refreshTabel(self.searchcondi)
                            $(".crumb").children(".crumbcondiwrap").append("<span class='chosexuanxiang'><b data-key=" + key + ">" + key + "：</b><em>" + str + "</em><i></i></span>");
                        }
                    } else {
                        var str = '';
                        for (var i = 0; i < self.temobj.length; i++) {
                            if (i < self.temobj.length - 1) {
                                str += self.temobj[i] + "、";
                            } else {
                                str += self.temobj[i];
                            }

                            console.log(str);
                        }
                        var obj = {};
                        obj.key = key;
                        obj.val = self.temobj;
                        self.searchcondi.push(obj)
                        refreshTabel(self.searchcondi)
                        $(".crumb").children(".crumbcondiwrap").append("<span class='chosexuanxiang'><b data-key=" + key + ">" + key + "：</b><em>" + str + "</em><i></i></span>");
                    }
                    self.temobj = [];
                    $(this).siblings(".ybtncancel").trigger("click");

                })
                $(".ybtncancel").on("click", function () {
                    self.temobj = [];
                    if ($(this).hasClass("snb")) {
                        $(this).parent().hide();
                        $(this).parent().siblings('.yseah-ext').show();
                        $(".selector li").each(function () {
                            $(this).unbind("click");
                        })
                        $(this).parent().siblings(".selecbaseul").removeClass("selector");

                        $(this).parent().siblings(".selecbaseul").children("li").each(function () {
                            $(this).removeClass("selected");
                        })
                    }


                })


            }
        }

    }
})(jQuery, window, document);