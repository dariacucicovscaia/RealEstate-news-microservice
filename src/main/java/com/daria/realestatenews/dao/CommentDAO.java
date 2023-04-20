package com.daria.realestatenews.dao;

import com.daria.realestatenews.dto.DisplayCommentDTO;
import com.daria.realestatenews.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentDAO extends PagingAndSortingRepository<Comment, Long> {
    @Query(value = "select new com.daria.realestatenews.dto.DisplayCommentDTO(c.content, u.firstName, u.lastName, u.externalId , c.lastUpdated) from Comment  as c " +
            " inner join User as u on u.id = c.user.id " +
            " where c.article.id = ?1 ORDER BY c.lastUpdated DESC ")
    Page<DisplayCommentDTO> findAllByArticleId(Long articleId, Pageable pageable);

}
