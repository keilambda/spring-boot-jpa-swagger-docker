package com.keilambda.demo.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

import com.keilambda.demo.infra.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Returns all the books in the library")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "all the books", useReturnTypeSchema = true)
    })
    public @ResponseBody List<Book> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Returns a book by it's id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "found a book successfully"),
            @ApiResponse(responseCode = "204", description = "book could not be found")
    })
    public @ResponseBody Optional<Book> getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Adds a new book to the library")
    public @ResponseBody Book add(
            @RequestBody
            Book b) {
        return service.add(b);
    }

    @DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Deletes a book from a library by it's id")
    public void delete(Long id) {
        service.delete(id);
    }
}
