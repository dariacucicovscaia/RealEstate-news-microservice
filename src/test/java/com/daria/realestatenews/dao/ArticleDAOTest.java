package com.daria.realestatenews.dao;

import com.daria.realestatenews.model.Article;
import com.daria.realestatenews.model.ArticleContent;
import com.daria.realestatenews.model.ImageCapture;
import com.daria.realestatenews.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;

//todo add asserts
@SpringBootTest
class ArticleDAOTest {
    @Autowired
    private ArticleDAO articleDAO;
    @Autowired
    private UserDAO userDAO;

//    @Test
//    public void TestGetArticlesById() {
//        System.out.println(articleDAO.findById(3L));
//    }
//
//    @Test
//    public void TestSaveArticleWithUserAndArticleContent() {
//        ArticleContent articleContent = new ArticleContent("title548461 lala", "descripSdafstion landur", "contensdvsvst shshshshs");
//        User user = new User("firstName", "lastName", 4);
//        userDAO.save(user);
//        Article article = new Article(
//                articleContent,
//                true,
//                LocalDateTime.now(),
//                LocalDateTime.now(),
//                user,
//                new ImageCapture(1L, "/articles/1.png", "one")
//        );
//
//        articleDAO.save(article);
//    }
//
//    @Test
//    public void testPageableQuery() {
//        int page = 0;
//        int size = 4;
//        PageRequest pageRequest = PageRequest.of(page, size);
//
//        articleDAO.findAllByPublishedAndOrderByLastUpdatedWithPagination(pageRequest).getContent().forEach(System.out::println);
//    }
//
//    @Test
//    public void testArticleDetails() {
//        System.out.println(articleDAO.getArticleDetails(1L));
//    }
}