package com.bbw.library.model;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@ToString
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String author;
    private int pages;
    private String genres;
    private String img;
    @Column(name = "releasedate")  // Specify the column name explicitly
    private Date releasedate;
}
