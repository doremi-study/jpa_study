package com.juustudy.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter
@Entity
public class Book {
    @Id @GeneratedValue
    private Integer id;

    private String name;

    private String title;

    @ManyToOne
    private BookStore bookStore;

}

