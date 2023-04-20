package com.daria.realestatenews.service;

import com.daria.realestatenews.dto.ArticleCreationDTO;
import com.daria.realestatenews.dto.ArticleDTO;
import com.daria.realestatenews.model.Article;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ArticleService {
    Article saveArticle(ArticleCreationDTO articleCreationDTO);

    Optional<Article> findArticleById(long id);
    Page<Article> findAllByPublishedAndOrderByLastUpdatedWithPagination(int page, int size);
    ArticleDTO getArticleDetails(Long articleId);
}
