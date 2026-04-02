package com.dongyang.basicExample.controller;

import com.dongyang.basicExample.dto.ArticleDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "/article/new";
    }

    @PostMapping("/articles/new")
    public String newArticleForm(ArticleDto dto){
        //1.파라미터 받고
        //2. DTO 생성해서 Setter이용해서 setting -> 1,2번은 스프링이 알아서 해줌
        //3. 위의 2번 DTO 객체를 DAO 생성해서 넘겨주고
        System.out.println("title : " + dto.getTitle());
        System.out.println("content : " + dto.getContents());
        return "";
    }

//    @GetMapping("/articles/list")
//    public String newArticleForm(){
//        return "/article/list";
//    }
}
