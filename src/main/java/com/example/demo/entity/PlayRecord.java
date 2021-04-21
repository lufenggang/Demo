package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 小滴课堂  播放记录
 *
 *  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
 *   `user_id` int(11) DEFAULT NULL,
 *   `video_id` int(11) DEFAULT NULL,
 *   `current_num` int(11) DEFAULT NULL COMMENT '当前播放第几集',
 *   `episode_id` int(11) DEFAULT NULL COMMENT '当前播放第几集视频id',
 *   `create_time` datetime DEFAULT NULL,
 */

@Data
public class PlayRecord implements Serializable {

    private static final long serialVersionUID = 5614474564848551259L;

    private Integer id;

    private Integer userId;

    private Integer videoId;

    private Integer currentNum;

    private Integer episodeId;

    private Date createTime;

    @Override
    public String toString() {
        return "PlayRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", videoId=" + videoId +
                ", currentNum=" + currentNum +
                ", episodeId=" + episodeId +
                ", createTime=" + createTime +
                '}';
    }
}
