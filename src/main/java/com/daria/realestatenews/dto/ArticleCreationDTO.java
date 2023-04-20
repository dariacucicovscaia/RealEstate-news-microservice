package com.daria.realestatenews.dto;

public class ArticleCreationDTO {
    private final String title;
    private final String description;
    private final String content;
    private final String firstName;
    private final String lastName;
    private final Long externalId;
    private final Boolean isPublished;
    private final String imagePath;
    private final String imageCapture;


    public ArticleCreationDTO(String title, String description, String content, String firstName, String lastName, Long externalId, Boolean isPublished, String imagePath, String imageCapture) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.firstName = firstName;
        this.lastName = lastName;
        this.externalId = externalId;
        this.isPublished = isPublished;
        this.imagePath = imagePath;
        this.imageCapture = imageCapture;
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

    public String getImageCapture() {
        return imageCapture;
    }
}
