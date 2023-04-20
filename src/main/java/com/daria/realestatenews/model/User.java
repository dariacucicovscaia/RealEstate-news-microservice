package com.daria.realestatenews.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;


    //TODO internal and external id
    // in cazul in care sunt 2 db diferite datatype difera sau una lucreaza cu sqlDB alta noSQLdb
    private long externalId;
    @OneToMany
    private List<Article> articles = new ArrayList<>();
    @OneToMany
    private List<Comment> comments = new ArrayList<>();




    public User() {
    }

    public User(String firstName, String lastName, long externalId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.externalId = externalId;
    }

    public User(long id, String firstName, String lastName, long externalId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.externalId = externalId;
    }

    public User(Long externalId, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.externalId = externalId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getExternalId() {
        return externalId;
    }

    public void setExternalId(long externalId) {
        this.externalId = externalId;
    }
    @JsonManagedReference
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
    @JsonManagedReference
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", externalId=" + externalId +
                '}';
    }
}
