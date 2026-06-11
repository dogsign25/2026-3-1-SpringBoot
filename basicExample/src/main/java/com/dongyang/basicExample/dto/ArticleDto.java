package com.dongyang.basicExample.dto;

import com.dongyang.basicExample.entity.ArticleEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDto {
    private Long id;
    private String title;
    private String contents;

    public ArticleEntity toEntity() {
        return new ArticleEntity(id, title, contents);
    }

}