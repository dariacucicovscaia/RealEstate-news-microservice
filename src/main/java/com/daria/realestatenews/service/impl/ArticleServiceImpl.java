package com.daria.realestatenews.service.impl;

import com.daria.realestatenews.dao.ArticleDAO;
import com.daria.realestatenews.dao.UserDAO;
import com.daria.realestatenews.dto.ArticleCreationDTO;
import com.daria.realestatenews.dto.ArticleDTO;
import com.daria.realestatenews.model.Article;
import com.daria.realestatenews.model.ArticleContent;
import com.daria.realestatenews.model.ImageCapture;
import com.daria.realestatenews.model.User;
import com.daria.realestatenews.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleDAO articleDAO;
    private final UserDAO userDAO;
    Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    public ArticleServiceImpl(ArticleDAO articleDAO, UserDAO userDAO) {
        this.articleDAO = articleDAO;
        this.userDAO = userDAO;
    }

    @Override
    public Article saveArticle(ArticleCreationDTO articleCreationDTO) {
        ArticleContent articleContent = new ArticleContent(articleCreationDTO.getTitle(), articleCreationDTO.getDescription(), articleCreationDTO.getContent());
        User user;
        if (userDAO.findByExternalId(articleCreationDTO.getExternalId()) != null) {
            user = userDAO.findByExternalId(articleCreationDTO.getExternalId());
        } else {
            user = userDAO.save(new User(articleCreationDTO.getFirstName(), articleCreationDTO.getLastName(), articleCreationDTO.getExternalId()));
        }
        Article article = new Article(
                articleContent,
                articleCreationDTO.getPublished(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                user,
                new ImageCapture(articleCreationDTO.getImagePath(), articleCreationDTO.getImageCapture())
        );

        Article createdArticle = articleDAO.save(article);
        logger.info("Article has been created " + createdArticle);
        return createdArticle;
    }

    @Override
    public Optional<Article> findArticleById(long id) {
        return articleDAO.findById(id);
    }

    @Override
    public Page<Article> findAllByPublishedAndOrderByLastUpdatedWithPagination(int page, int size) {
        Page<Article> pages = articleDAO.findAllByPublishedAndOrderByLastUpdatedWithPagination(PageRequest.of(page - 1, size));
        //TODO pagination starts at 0 so needed op is
        logger.info(pages.toString());
        return pages;
    }

    @Override
    public ArticleDTO getArticleDetails(Long articleId) {
        return articleDAO.getArticleDetails(articleId);
    }


}
