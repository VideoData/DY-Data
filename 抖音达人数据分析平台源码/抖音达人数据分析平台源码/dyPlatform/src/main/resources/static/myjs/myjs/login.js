$.backstretch("img/login-bg.jpg", {
    speed: 500
});
$("#myform").validate({
    //debug: true,//调试模式取消submit的默认提交功能
    submitHandler: function (form) {//验证通过后的执行方法
        savePasswd()
        //当前的窗体通过ajax方式提交（用到jQuery.Form文件）
        $(form).ajaxSubmit({
            dataType: "json",
            contentType: "application / x - www - form - urlencoded", //默认值为表单提交
            success: function () {
                if (jsondata.code = 200) {
                    alert("success");
                } else {
                    alert("fail");
                }
            }
        });
    },
    rules: {
        accountNumber: {
            required: true,
            /*           remote: {          //远程ajax验证
                           url: "../xxxx/checkaccount", //检查是否存在账号，存在则返回true
                           type: "GET",
                           dataType: "json",
                           data: {
                               account: function () {
                                   return $("#account").val(); //这个是取要验证的用户名
                               }
                           },
                           dataFilter: function (data) {  //判断控制器返回的内容
                               var notice = eval("(" + data + ")");
                               if (notice) {
                                   return false;
                               } else {
                                   return true;
                               }
                           }
                       }*/
        }
        ,
        passwd: {
            required: true
        }
    }
    ,
    messages: {
        accountNumber: {
            required: "必填"
        }
        ,
        passwd: {
            required: "必填"
        }
    }
})


//本地记住密码
function savePasswd() {
    if ($("#remember").is(':checked')) {
        let account = $("#accountNumber").val()
        let passwd = $("#passwd").val()
        localStorage.setItem("remember", account + "-" + passwd);
    }
}

fillPasswd()

//填充账户和密码
function fillPasswd() {
    let data = localStorage.getItem("remember");
    if (!(data && typeof (data) != "undefined" && data != 0 && data.length < 2)) {
        let splits = data.split("-")
        $("#accountNumber").val(splits[0])
        $("#passwd").val(splits[1])
        $("#remember").attr("checked", true)
    }
}


var check = [false, false, false, false];

//校验成功函数
function success(Obj, counter) {
    Obj.parent().parent().removeClass('has-error').addClass('has-success');
    $('.tips').eq(counter).hide();
    $('.glyphicon-ok').eq(counter).show();
    $('.glyphicon-remove').eq(counter).hide();
    check[counter] = true;

}

// 校验失败函数
function fail(Obj, counter, msg) {
    Obj.parent().parent().removeClass('has-success').addClass('has-error');
    $('.glyphicon-remove').eq(counter).show();
    $('.glyphicon-ok').eq(counter).hide();
    $('.tips').eq(counter).text(msg).show();
    check[counter] = false;
}

var regUsername = /^[a-zA-Z_][a-zA-Z0-9_]{4,19}$/;
var regPasswordSpecial = /[~!@#%&=;':",./<>_\}\]\-\$\(\)\*\+\.\[\?\\\^\{\|]/;
var regPasswordAlpha = /[a-zA-Z]/;
var regPasswordNum = /[0-9]/;
var regCheckCode = /[0-9]{6}/

// 手機、邮箱验证
var regPhoneNum = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/
$('#myModal').find('input').eq(0).change(function () {
    if (regPhoneNum.test($(this).val())) {
        success($(this), 0);
    } else {
        fail($(this), 0, '邮箱或手机格式错误');
    }
});


$('#myModal').find('input').eq(1).change(function () {
    if (regCheckCode.test($(this).val())) {
        success($(this), 1);
    } else {
        fail($(this), 1, '验证码输入错误');
    }
});

// 匹配字母、数字、特殊字符至少两种的函数
function atLeastTwo(password) {
    var a = regPasswordSpecial.test(password) ? 1 : 0;
    var b = regPasswordAlpha.test(password) ? 1 : 0;
    var c = regPasswordNum.test(password) ? 1 : 0;
    return a + b + c;

}

$('#myModal').find('input').eq(2).change(function () {
    password = $(this).val();
    if ($(this).val().length < 8) {
        fail($(this), 2, '密码太短，不能少于8个字符');
    } else {
        if (atLeastTwo($(this).val()) < 2) {
            fail($(this), 2, '密码中至少包含字母、数字、特殊字符的两种')
        } else {
            success($(this), 2);
        }
    }
});
// 再次输入密码校验
$('#myModal').find('input').eq(3).change(function () {
    if ($(this).val() == password) {
        success($(this), 3);
    } else {
        fail($(this), 3, '两次输入的密码不一致');
    }

});
key = "1"
$('#loadingButton').click(function (e) {
    if (check[0]) {
        let email = $('#myModal').find('input').eq(0).val()
        let result = sendCheckCode(email)
        if (result == "") {
            return
        } else {
            key = result.key
        }
        $(this).removeClass('btn-primary').addClass('disabled');
        $(this).html('<span class="red">59</span> 秒后重新获取');
        var secondObj = $('#loadingButton').find('span');
        var secondObjVal = secondObj.text();

        function secondCounter() {
            var secondTimer = setTimeout(function () {
                secondObjVal--;
                secondObj.text(secondObjVal);
                secondCounter();
            }, 1000);
            if (secondObjVal == 0) {
                clearTimeout(secondTimer);
                $('#loadingButton').text('重新获取校验码');
                $('#loadingButton').removeClass('disabled').addClass('btn-primary');

            }
        }

        secondCounter();
    } else {
        $('.container').find('input').eq(4).parent().parent().removeClass('has-success').addClass('has-error');
    }

})

/*发送邮箱验证码*/
function sendCheckCode(email) {
    let fd = new FormData()
    fd.append("data", email)
    let key = ""
    $.ajax({
        url: "/login/findPasswd/inputInfo",
        type: "POST",
        async: false,
        data: fd,
        processData: false,  // 不处理数据
        contentType: false,   // 不设置内容类型
        success: function (ajaxdata) {
            console.log(ajaxdata)
            if (ajaxdata.code == 200) {
                key = ajaxdata.data
            } else {
                alert(ajaxdata.message)
            }
        }
    })
    return key
}

$("#find_passwd_btn").click(function (e) {
    e.preventDefault();
    if (!check.every(function (value) {
        return value == true
    })) {
        e.preventDefault();
        for (key in check) {
            if (!check[key]) {
                $('.container').find('input').eq(key).parent().parent().removeClass('has-success').addClass('has-error')
            }
        }
    } else {
        let fd = new FormData()
        let email = document.getElementById("phoneNum").value
        let code = document.getElementById("idcode-btn").value
        let passwd = document.getElementById("password").value
        fd.append("email", email)
        fd.append("code", code)
        fd.append("passwd", passwd)
        fd.append("key", key)
        $.ajax({
            url: "/login/findPasswd/verificate",
            data: fd,
            type: "POST",
            processData: false,  // 不处理数据
            contentType: false,   // 不设置内容类型
            success: function (ajaxdata) {
                console.log(ajaxdata)
                if (ajaxdata.code == 200) {
                    $("#myModal").modal('hide')
                } else {
                    alert("验证码错误！！")
                }
            }
        })
    }
})