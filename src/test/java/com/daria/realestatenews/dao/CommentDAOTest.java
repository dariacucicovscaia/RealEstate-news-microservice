package com.daria.realestatenews.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentDAOTest {
@Autowired
private CommentDAO commentDAO;
//    @Test
//    void findAllByArticleId() {
//        int page = 0;
//        int size = 10;
//        commentDAO.findAllByArticleId(1L, PageRequest.of(page, size)).forEach(System.out::println);
//    }
}