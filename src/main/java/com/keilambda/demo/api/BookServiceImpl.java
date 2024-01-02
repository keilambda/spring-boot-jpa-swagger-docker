package com.keilambda.demo.api;

import com.keilambda.demo.infra.Book;
import com.keilambda.demo.infra.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepo repo;

    @Override
    public List<Book> getAll() {
        return StreamSupport.stream(repo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> getOne(Long id) {
        return repo.findById(id);
    }

    @Override
    public Book add(Book b) {
        return repo.save(b);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
