package com.lida.dy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/1/5 0005 10:25
 * @Version: 1.0
 */
@Data
public class TypeDataVo {
    private Advancecondition advancecondition;

    @Data
    public static class Advancecondition {
        private String title;
        private List<Val> val;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Val {
            private boolean multiselect;    //多选开关
            private Value value;

            @Data
            public static class Value {
                private String title;   //选择名字
                private List<String> val;   //选择item
            }
        }
    }
}





