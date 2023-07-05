package com.enviro.assessment.grad001.paulmaodi.assessment.entity;

import java.net.URI;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class AccountProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    
    private String surname;
    
    @Transient
    private String imageFormat;

    
    private URI httpImageLink;


    public URI getHttpImageLink() {
        return httpImageLink;
    }
    public void setHttpImageLink(URI httpImageLink) {
        this.httpImageLink = httpImageLink;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getImageFormat() {
        return imageFormat;
    }
    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }

}
