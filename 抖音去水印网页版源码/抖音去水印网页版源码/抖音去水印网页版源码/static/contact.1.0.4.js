// 页面高度
$('.loading').height($(window).height() - $('.home-logo').height());
$('#content').click(function () {
    $('#content').val('');
});
// 下载
new Vue({
    el: '#download',
    methods: {
        download() {
            let $ele = this;
            $('.loading').css('display', 'block');
            let content = $("#content").val().trim();
            $.ajax({
                type: "POST",
                dataType: "text",
                url: '/api/douyin',
                // url: 'https://dy.helloxjn.com/api/douyin',
                data: {
                    "video_url_share": content,
                },
                success: function (msg) {
                    msg = JSON.parse(msg)
                    if (!msg.error) {
                        $('.loading').css('display', 'none');
                        let aweme_type = msg.data['aweme_type'];
                        // 视频
                        if (aweme_type === 4) {
                            let video_url = msg.data['video_url_web'];
                            let video_name = msg.data['video_name'];
                            window.open(`https://dy.helloxjn.com/download?video_url_web=${video_url}&video_name=${video_name}`, "_self");
                        }
                        //图集
                        else if (aweme_type === 2) {
                            image_show(msg.data['image_url_list']);
                        }
                    } else {
                        $('.loading').css('display', 'none');
                        $('.el-message__closeBtn').click();
                        $ele.$message({
                            message: '无效链接',
                            type: 'info',
                            center: true,
                            offset: 4,
                            showClose: true,
                            duration: 2000,
                        });
                        setTimeout(function () {
                            $('#error').text('');
                        }, 1000)
                    }
                },
            });
        },
    }
})
// 预览
new Vue({
    el: '#watch',
    methods: {
        watch() {
            let $ele = this;
            $('.loading').css('display', 'block');
            let content = $("#content").val().trim();
            $.ajax({
                type: "POST",
                dataType: "text",
                // url: 'api/douyin',
                url: 'https://dy.helloxjn.com/api/douyin',
                data: {
                    "video_url_share": content,
                },
                success: function (msg) {
                    msg = JSON.parse(msg)
                    if (!msg.error) {
                        $('.loading').css('display', 'none');
                        let aweme_type = msg.data['aweme_type'];
                        // 视频
                        if (aweme_type === 4) {
                            let video_url = msg.data['video_url_web'];
                            $('#video_url').attr("href", video_url);
                            $('#error').text('');
                            document.getElementById("video_url").click();
                        }
                        //图集
                        else if (aweme_type === 2) {
                            image_show(msg.data['image_url_list']);
                        }

                    } else {
                        $('.loading').css('display', 'none');
                        $('.el-message__closeBtn').click();
                        $ele.$message({
                            message: '无效链接',
                            type: 'info',
                            center: true,
                            offset: 4,
                            showClose: true,
                            duration: 2000,
                        });
                        setTimeout(function () {
                            $('#error').text('');
                        }, 1000)
                    }
                },
            });
        },
    }
})

// 渲染图集
function image_show(image_url_list) {
    let image_html = `<div class="col-md-12">
                        <div class="form-group">
                            <h5 style="text-align: center; color: #67C23A">视频类型为图集，图片提取成功！</h5>
                        </div>
                    </div>`;
    image_url_list.forEach(function (image_url, i) {
        image_html += `
                    <div index=${i} class="image-li">
                        <div class="col-md-6">
                            <img src=${image_url} alt="">
                        </div>
                    </div>
                `
    });
    $('.row .douyin_form').html('');
    $('.readme').html('');
    $('.copyrights').remove();
    $('.image_list').html(image_html);
}

console.log(`
GitHub: https://github.com/xiangjianan

Email: xiang9872@gmail.com

Page: www.helloxjn.com

`);

