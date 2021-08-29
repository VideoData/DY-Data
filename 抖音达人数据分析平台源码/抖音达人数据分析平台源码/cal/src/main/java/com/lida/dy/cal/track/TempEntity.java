package com.lida.dy.cal.track;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class TempEntity implements Serializable {

    private Integer id;
    private String vid;
    private String uid;
    private Integer myuid;
}
