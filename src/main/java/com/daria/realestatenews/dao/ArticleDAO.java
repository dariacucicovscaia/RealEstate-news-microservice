package com.daria.realestatenews.dao;

import com.daria.realestatenews.dto.ArticleDTO;
import com.daria.realestatenews.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


//TODO pagination with PagingAndSortingRepository, JPARepository, QueryByExampleExecutor
//TODO ui hint wsgi editor for react
public interface ArticleDAO extends PagingAndSortingRepository<Article, Long> {
    @Query(
            value = " SELECT * FROM article as a  " +
                    " inner join article_content as ac on a.article_content_id = ac.id " +
                    " where a.is_published = 1 ORDER BY a.last_updated DESC",
            countQuery = " SELECT count(*) FROM article as a  " +
                    " inner join article_content as ac on a.article_content_id = ac.id " +
                    " where a.is_published = 1 ",
            nativeQuery = true)
    Page<Article> findAllByPublishedAndOrderByLastUpdatedWithPagination(Pageable pageable);

    @Query(
            value = "SELECT new com.daria.realestatenews.dto.ArticleDTO(a.id, a.creationDate, ac.title,ac.description, ac.content, u.firstName, u.lastName, u.externalId, a.isPublished, i.path ) FROM Article as a \n" +
                    "inner join ArticleContent as ac on a.articleContent.id = ac.id\n" +
                    "inner join ImageCapture as i on a.image.id = i.id\n" +
                    "inner join User as u on u.id = a.user.id where a.id = ?1"
           )
    ArticleDTO getArticleDetails(Long articleId);
}
