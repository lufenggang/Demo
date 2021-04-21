package com.example.demo.controller;

import com.example.demo.entity.Video;
import com.example.demo.service.VideoService;
import com.example.demo.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;


    @GetMapping("list")
    public JsonData list(){
        List<Video> videoList = videoService.listVideo();
        return JsonData.success().data("videoList",videoList);
    }


}
