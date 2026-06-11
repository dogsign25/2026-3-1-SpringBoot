package com.dongyang.basicExample.controller;

import com.dongyang.basicExample.dto.ArticleDto;
import com.dongyang.basicExample.entity.ArticleEntity;
import com.dongyang.basicExample.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RequestMapping("/articles")
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping
    public String index(Model mo){
        List<ArticleEntity> listEntity = (List<ArticleEntity>)articleRepository.findAll();
        mo.addAttribute("articleList",listEntity);
        return "article/index";
    }

    @GetMapping("/new")
    public String newArticleForm(){
        return "article/new";
    }

    @PostMapping("/new")
    public String newArticleForm(ArticleDto dto){
        //1.파라미터 받고
        //2. DTO 생성해서 Setter이용해서 setting -> 1,2번은 스프링이 알아서 해줌
        //3. 위의 2번 DTO 객체를 DAO 생성해서 넘겨주고

        // 1. dto에의 값을 ArticleEntity로 넣기
        ArticleEntity ae = dto.toEntity();
         //2. ArticleRepository 의 save()
        ArticleEntity insertEntity = articleRepository.save(ae);
        return "redirect:/articles/"+insertEntity.getId();
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        ArticleEntity at = articleRepository.findById(id).orElse(null);
        model.addAttribute("showEntity", at);
        return "article/show";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id, RedirectAttributes model){
        articleRepository.deleteById(id);
        model.addFlashAttribute("msg","삭제되었음");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id,Model mo){
        //select
        ArticleEntity editEntity = articleRepository.findById(id).orElse(null);
        mo.addAttribute("editEntity", editEntity);
        return "article/edit";
        //
    }

    @PostMapping("/update")
    public String update(ArticleDto dto){
        ArticleEntity updateEntity = articleRepository.save(dto.toEntity());
        return "redirect:/articles";
    }

}
