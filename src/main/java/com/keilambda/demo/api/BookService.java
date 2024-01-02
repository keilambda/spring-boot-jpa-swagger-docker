package com.keilambda.demo.api;

import com.keilambda.demo.infra.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAll();
    Optional<Book> getOne(Long id);
    Book add(Book b);
    void delete(Long id);
}
