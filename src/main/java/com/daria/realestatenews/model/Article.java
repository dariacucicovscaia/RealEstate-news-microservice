package com.daria.realestatenews.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "article")
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn
    private ArticleContent articleContent;
    private boolean isPublished;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdated;
    @ManyToOne(optional = false)
    @JoinColumn
    private User user;
    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    @OneToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn
    private ImageCapture image;
    public Article() {
    }

    public Article(ArticleContent articleContent, boolean isPublished, LocalDateTime creationDate, LocalDateTime lastUpdated, User user, ImageCapture image) {
        this.articleContent = articleContent;
        this.isPublished = isPublished;
        this.creationDate = creationDate;
        this.lastUpdated = lastUpdated;
        this.user = user;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArticleContent getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(ArticleContent articleContent) {
        this.articleContent = articleContent;
    }

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @JsonManagedReference
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public ImageCapture getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", isPublished=" + isPublished +
                ", creationDate=" + creationDate +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
