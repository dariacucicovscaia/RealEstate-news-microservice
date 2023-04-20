package com.daria.realestatenews.dto;

public class CommentDTO {
    private final Long externalId;
    private final Long articleId;
    private final String content;

    public CommentDTO( Long externalId, Long articleId, String content) {
        this.externalId = externalId;
        this.articleId = articleId;
        this.content = content;
    }

    public Long getExternalId() {
        return externalId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public String getContent() {
        return content;
    }
}
