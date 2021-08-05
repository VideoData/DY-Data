package com.haowen.bare.result;

import com.haowen.bare.parse.enums.MediaType;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BareResult {

    @ApiModelProperty(value = "类型：video->视频；image->图片集；")
    private MediaType type;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "视频封面")
    private Image cover;

    @ApiModelProperty(value = "视频信息集合（type=video）")
    private List<Video> videos;

    @ApiModelProperty(value = "图片信息集合（type=image）")
    private List<Image> images;

    public BareResult(MediaType type) {
        this.type = type;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Video {

        public Video(String url) {
            this.url = url;
        }

        @Deprecated
        public Video(String url, String cover) {
            this.url = url;
        }

        @ApiModelProperty(value = "视频地址")
        private String url;

        @ApiModelProperty(value = "清晰度")
        private String quality;

        @ApiModelProperty(value = "视频宽")
        private Integer width;

        @ApiModelProperty(value = "视频高")
        private Integer height;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Image {

        public Image(String url) {
            this.url = url;
        }

        @ApiModelProperty(value = "图片地址")
        private String url;

        @ApiModelProperty(value = "图片宽")
        private Integer width;

        @ApiModelProperty(value = "图片高")
        private Integer height;
    }
}
