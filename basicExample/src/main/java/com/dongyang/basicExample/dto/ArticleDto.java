package com.dongyang.basicExample.dto;

import com.dongyang.basicExample.entity.ArticleEntity;

public class ArticleDto {
    private String title;
    private String contents;

    public ArticleEntity toEntity(){
        return new ArticleEntity(null,title,contents);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
