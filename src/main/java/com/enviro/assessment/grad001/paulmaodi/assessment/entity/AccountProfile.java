package com.enviro.assessment.grad001.paulmaodi.assessment.entity;

import java.net.URL;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity class for AccountProfile table in the database to store the account
 * holder's name, surname and the httpImageLink.
 */
@Entity
public class AccountProfile {
    /**
     * The id of the account holder.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The name of the account holder.
     */
    private String name;

    /**
     * The surname of the account holder.
     */
    private String surname;

    /**
     * The httpImageLink of the decoded image.
     */
    private URL httpImageLink;

    public URL getHttpImageLink() {
        return httpImageLink;
    }

    public void setHttpImageLink(URL httpImageLink) {
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
}
