package com.daria.realestatenews.controller;

import com.daria.realestatenews.dto.ArticleCreationDTO;
import com.daria.realestatenews.dto.ArticleDTO;
import com.daria.realestatenews.model.Article;
import com.daria.realestatenews.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/news/article")
@CrossOrigin
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public ResponseEntity<Article> saveArticle(@RequestBody ArticleCreationDTO article) {
        return ResponseEntity.status(HttpStatus.CREATED).body(articleService.saveArticle(article));
    }

    @GetMapping("/latest")
    public ResponseEntity<Page<Article>> getLatestArticles(@RequestParam("page") int page,
                                                           @RequestParam("size") int size) {

        return ResponseEntity.status(HttpStatus.OK).body(articleService.findAllByPublishedAndOrderByLastUpdatedWithPagination(page, size));
    }
    @GetMapping("/details/{articleId}")
    public ResponseEntity<ArticleDTO> getArticleDetails(@PathVariable Long articleId) {
        return ResponseEntity.status(HttpStatus.OK).body(articleService.getArticleDetails(articleId));
    }
}
