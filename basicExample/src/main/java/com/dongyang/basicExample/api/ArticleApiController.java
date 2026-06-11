package com.dongyang.basicExample.api;

import com.dongyang.basicExample.dto.ArticleDto;
import com.dongyang.basicExample.entity.ArticleEntity;
import com.dongyang.basicExample.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
public class ArticleApiController {
    @Autowired
    private ArticleService articleService;

    @PatchMapping("/api/articles/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody ArticleDto dto){
        articleService.update(id,dto);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/api/articles/{id}")
    public ArticleEntity show(@PathVariable Long id){
        return articleService.show(id);
    }

    @GetMapping("/api/articles")
    public List<ArticleEntity> index(){
        return articleService.index();
    }

    @PostMapping("/api/articles")
    public ResponseEntity create(@RequestBody ArticleDto dto){
        ArticleEntity at = articleService.create(dto);
        return (at==null?ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null):
                ResponseEntity.status(HttpStatus.OK).body(null));
    }

    @DeleteMapping("/api/articles/{id}") // @GetMapping을 @DeleteMapping으로 바꾸고, 주소에서 /delete를 삭제
    public ResponseEntity delete(@PathVariable("id") Long id){
        articleService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/api/articles/transaction-test")
    public ResponseEntity transactionTest(@RequestBody List<ArticleDto> dtos){
        articleService.transactionTest(dtos);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}

