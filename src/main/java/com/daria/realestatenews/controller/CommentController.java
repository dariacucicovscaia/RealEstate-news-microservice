package com.daria.realestatenews.controller;

import com.daria.realestatenews.dto.CommentDTO;
import com.daria.realestatenews.dto.DisplayCommentDTO;
import com.daria.realestatenews.model.Comment;
import com.daria.realestatenews.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/news/comment")
@CrossOrigin
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Comment> saveComment(@RequestBody CommentDTO commentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.saveComment(commentDTO));
    }
    @GetMapping("/{articleId}")
    public ResponseEntity<Page<DisplayCommentDTO>> getCommentsOfAnArticle(@PathVariable Long articleId, @RequestParam int page, @RequestParam int size){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getPagedCommentsOfAnArticle(articleId,page, size));
    }
}
