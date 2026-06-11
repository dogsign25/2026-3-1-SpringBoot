package com.dongyang.basicExample.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ArticleEntity {
    @Id // primary key
    @GeneratedValue // auto-increment
    private Long id;

    @Column // normal column
    private String title;
    @Column
    private String contents;

    public void patch(ArticleEntity articleEntity){
        if(articleEntity.title != null){
            this.title=articleEntity.title;
        }
        if(articleEntity.contents != null){
            this.contents=articleEntity.contents;
        }
    }
}
