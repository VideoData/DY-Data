package com.lida.dy.cal;

import com.lida.dy.cal.spiderDy.Comment;
import com.lida.dy.cal.spiderDy.Video;
import com.lida.dy.cal.temp.FixPriceMain;
import com.lida.dy.cal.track.TrackMgm;
import com.lida.dy.cal.track.TrackMinute;
import com.lida.dy.cal.track.TrackVideo;
import com.spring4all.mongodb.EnableMongoPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication()
@EnableMongoPlus
@EnableScheduling
public class CalApplication implements ApplicationRunner {
    @Autowired
    FixPriceMain fixPriceMain;
    @Autowired
    Comment comment;
    @Autowired
    Video video;
    @Autowired
    TrackVideo trackVideo;
    @Autowired
    TrackMgm trackMgm;
    @Autowired
    TrackMinute trackMinute;
    public static void main(String[] args) {
        new SpringApplicationBuilder(CalApplication.class)
                .web(WebApplicationType.NONE) // .REACTIVE, .SERVLET
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
//        video.start();
        trackMinute.start();
    }
}
