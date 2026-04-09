package com.dongyang.basicExample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    @GetMapping("/search")
    public String mainSearch(@RequestParam("searchForm") String keyword){
        System.out.println("검색어: " + keyword);
        return "";
    }
}
