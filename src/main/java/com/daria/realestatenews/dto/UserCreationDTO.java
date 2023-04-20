package com.daria.realestatenews.dto;

public class UserCreationDTO {
    private final String firstName;
    private final String lastName;
    private final Long externalId;

    public UserCreationDTO(String firstName, String lastName, Long externalId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.externalId = externalId;
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
}
