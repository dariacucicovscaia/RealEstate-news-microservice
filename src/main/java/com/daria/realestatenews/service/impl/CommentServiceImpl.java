package com.daria.realestatenews.service.impl;

import com.daria.realestatenews.dao.ArticleDAO;
import com.daria.realestatenews.dao.CommentDAO;
import com.daria.realestatenews.dao.UserDAO;
import com.daria.realestatenews.dto.CommentDTO;
import com.daria.realestatenews.dto.DisplayCommentDTO;
import com.daria.realestatenews.model.Article;
import com.daria.realestatenews.model.Comment;
import com.daria.realestatenews.model.User;
import com.daria.realestatenews.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDAO commentDAO;
    private final UserDAO userDAO;
    private final ArticleDAO articleDAO;

    public CommentServiceImpl(CommentDAO commentDAO, UserDAO userDAO, ArticleDAO articleDAO) {
        this.commentDAO = commentDAO;
        this.userDAO = userDAO;
        this.articleDAO = articleDAO;
    }

    @Override
    public Comment saveComment(CommentDTO commentDTO) {
        Optional<Article> article = articleDAO.findById(commentDTO.getArticleId());
        User user = userDAO.findByExternalId(commentDTO.getExternalId());

        if (article.isPresent()) {
            Comment comment = new Comment(user, article.get(), commentDTO.getContent(), LocalDateTime.now(), LocalDateTime.now());
            return commentDAO.save(comment);
        } else {
            return null;
        }
    }

    @Override
    public Page<DisplayCommentDTO> getPagedCommentsOfAnArticle(Long articleId, int page, int size) {
        return commentDAO.findAllByArticleId(articleId, PageRequest.of(page-1, size));
    }
}
