package com.dongyang.basicExample.service;

import com.dongyang.basicExample.dto.ArticleDto;
import com.dongyang.basicExample.entity.ArticleEntity;
import com.dongyang.basicExample.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public ArticleEntity show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public List<ArticleEntity> index(){
        return (List<ArticleEntity>)articleRepository.findAll();
    }

    public ArticleEntity create(ArticleDto dto){
        ArticleEntity at = articleRepository.save(dto.toEntity());
        return at;
    }

    public void delete(Long id){
        articleRepository.deleteById(id);
    }

    @Transactional
    public void transactionTest(List<ArticleDto> dtos) {
        List<ArticleEntity> ArticleList = new ArrayList<>();
        for (int i = 0; i < dtos.size(); i++) {
            ArticleDto dto = dtos.get(i);
            ArticleEntity at = dto.toEntity();
            ArticleList.add(at);
        }

        articleRepository.saveAll(ArticleList);

        try {
            articleRepository.findById(-1L).orElseThrow();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void update(Long id, ArticleDto dto) {
        ArticleEntity article = dto.toEntity();
        ArticleEntity target = articleRepository.findById(id).orElse(null);
        target.patch(article);
        articleRepository.save(article);
    }
}
