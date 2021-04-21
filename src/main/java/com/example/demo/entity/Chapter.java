package com.example.demo.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *  小滴课堂 章对象
 *
 *  `iFd` int(11) unsigned NOT NULL AUTO_INCREMENT,
 *  *   `video_id` int(11) DEAULT NULL COMMENT '视频主键',
 *   `title` varchar(128) DEFAULT NULL COMMENT '章节名称',
 *   `ordered` int(11) DEFAULT NULL COMMENT '章节顺序',
 *   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
 */

@Data
public class Chapter implements Serializable {

    private static final long serialVersionUID = 264983927948275316L;

    private Integer id;

    private String videoId;

    private String title;

    private Integer ordered;

    private Date createTime;

    private Date updateTime;

    private List<Episode> episodeList;

    @Override
    public String toString() {
        return "chapter{" +
                "id=" + id +
                ", videoId='" + videoId + '\'' +
                ", title='" + title + '\'' +
                ", ordered=" + ordered +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
