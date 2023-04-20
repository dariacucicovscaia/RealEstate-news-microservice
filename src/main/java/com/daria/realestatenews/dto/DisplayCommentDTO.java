package com.daria.realestatenews.dto;

import java.time.LocalDateTime;

public class DisplayCommentDTO {
    private final String content;
    private final String firstName;
    private final String lastName;
    private final Long externalId;
    private final LocalDateTime lastUpdated;


    public DisplayCommentDTO(String content, String firstName, String lastName, Long externalId, LocalDateTime lastUpdated) {
        this.content = content;
        this.firstName = firstName;
        this.lastName = lastName;
        this.externalId = externalId;
        this.lastUpdated = lastUpdated;
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

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
}
