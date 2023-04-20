package com.daria.realestatenews.dto;

import java.time.LocalDateTime;

public class ArticleDTO {
    private final Long id;
    private final LocalDateTime creationDate;
    private final String title;
    private final String description;
    private final String content;
    private final String firstName;
    private final String lastName;
    private final Long externalId;
    private final Boolean isPublished;
    private final String imagePath;

    public ArticleDTO(Long id, LocalDateTime creationDate, String title, String description, String content, String firstName, String lastName, Long externalId, Boolean isPublished, String imagePath) {
        this.id = id;
        this.creationDate = creationDate;
        this.title = title;
        this.description = description;
        this.content = content;
        this.firstName = firstName;
        this.lastName = lastName;
        this.externalId = externalId;
        this.isPublished = isPublished;
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getExternalId() {
        return externalId;
    }

    public Boolean getPublished() {
        return isPublished;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String toString() {
        return "ArticleDTO{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", externalId=" + externalId +
                ", isPublished=" + isPublished +
                '}';
    }
}
