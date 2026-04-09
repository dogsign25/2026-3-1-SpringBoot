package com.dongyang.basicExample.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ArticleEntity {
    @Id // primary key
    @GeneratedValue // auto-increment
    private Long id;


    @Column // normal column
    private String title;
    @Column
    private String contents;

    public ArticleEntity(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    public ArticleEntity() {
    }

}
