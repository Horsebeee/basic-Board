package com.study.app.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class PageHandler {

    private static final int BAR_LENGTH = 10;

    public List<Integer> PageHandler(int curr,int total) {
        int startNum = Math.max(0,curr-(BAR_LENGTH/2));
        int endNum = Math.min(startNum + BAR_LENGTH, total);

        return IntStream.range(startNum,endNum).boxed().toList();
    }
}
