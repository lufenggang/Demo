package com.example.demo.service.impl;

import com.example.demo.entity.Video;
import com.example.demo.mapper.VideoMapper;
import com.example.demo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;


    @Override
    public List<Video> listVideo() {
        List<Video> videoList = videoMapper.list();
        return videoList;
    }
}
