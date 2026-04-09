package com.dongyang.basicExample.controller;

import com.dongyang.basicExample.dto.ArticleDto;
import com.dongyang.basicExample.entity.ArticleEntity;
import com.dongyang.basicExample.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "/article/new";
    }

    @PostMapping("/articles/new")
    public String newArticleForm(ArticleDto dto){
        //1.파라미터 받고
        //2. DTO 생성해서 Setter이용해서 setting -> 1,2번은 스프링이 알아서 해줌
        //3. 위의 2번 DTO 객체를 DAO 생성해서 넘겨주고

        // 1. dto에의 값을 ArticleEntity로 넣기
        ArticleEntity ae = dto.toEntity();
         //2. ArticleRepository 의 save()
        articleRepository.save(ae);
        return "";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable("id") Long id){
        System.out.println("상세 글 값 : "+id);
        return "";
    }



//    @GetMapping("/articles/list")
//    public String newArticleForm(){
//        return "/article/list";
//    }
}
