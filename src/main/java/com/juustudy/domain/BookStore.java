package com.juustudy.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@Entity(name="book_store")
public class BookStore {

    @Id @GeneratedValue
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "bookStore")
    private Set<Book> books = new HashSet<>();

    public void add(Book book){
    }
}
