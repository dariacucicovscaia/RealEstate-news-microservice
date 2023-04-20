package com.daria.realestatenews.service;

import com.daria.realestatenews.dto.ArticleCreationDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


//TODO mock layer
@SpringBootTest
class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

//    @Test
//    void saveArticle() {
//        ArticleCreationDTO articleCreationDTO = new ArticleCreationDTO("mai", "mai", "mai", "firstName", "lastName", 10L, true, "", "");
//
//        articleService.saveArticle(articleCreationDTO);
//    }
//
//    @Test
//    void findArticleById() {
//        System.out.println(articleService.findArticleById(5L));
//    }
}