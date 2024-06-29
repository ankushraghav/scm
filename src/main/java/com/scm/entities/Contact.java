package com.scm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Contact {

    @Id
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String picture;
    @Column(length = 1000)
    private String description;
    private Boolean favorite = false;

    private String websiteLink;
    private String linkedInLink;

    @ManyToOne
    private User user;
}
