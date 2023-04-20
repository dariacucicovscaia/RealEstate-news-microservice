package com.daria.realestatenews.model;

import javax.persistence.*;

@Entity
@Table
public class ImageCapture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    @Column(columnDefinition = "TEXT")
    private String capture;

    public ImageCapture() {

    }

    public ImageCapture(Long id, String path, String capture) {
        this.id = id;
        this.path = path;
        this.capture = capture;
    }

    public ImageCapture(String path, String capture) {
        this.path = path;
        this.capture = capture;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCapture() {
        return capture;
    }

    public void setCapture(String capture) {
        this.capture = capture;
    }
}
