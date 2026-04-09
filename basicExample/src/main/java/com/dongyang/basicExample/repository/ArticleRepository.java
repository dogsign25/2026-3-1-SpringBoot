package com.dongyang.basicExample.repository;

import com.dongyang.basicExample.entity.ArticleEntity;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<ArticleEntity, Long> {

}
