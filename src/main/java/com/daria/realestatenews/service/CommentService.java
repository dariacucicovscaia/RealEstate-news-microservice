package com.daria.realestatenews.service;

import com.daria.realestatenews.dto.CommentDTO;
import com.daria.realestatenews.dto.DisplayCommentDTO;
import com.daria.realestatenews.model.Comment;
import org.springframework.data.domain.Page;

public interface CommentService {
    Comment saveComment(CommentDTO commentDTO) ;

    Page<DisplayCommentDTO> getPagedCommentsOfAnArticle(Long articleId, int page, int size);

}
