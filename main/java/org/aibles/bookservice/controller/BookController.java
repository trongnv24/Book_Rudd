package org.aibles.bookservice.controller;

import jakarta.persistence.Id;
import org.aibles.bookservice.dto.request.BookRequest;
import org.aibles.bookservice.dto.response.BookRepose;
import org.aibles.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")

public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public BookRepose create(@RequestBody @Validated BookRequest request) {
        return bookService.create(request);
    }
    @GetMapping("{id}")
    public BookRepose getOneById(@PathVariable("id") long id) {
        return bookService.getById(id);
    }


   @PutMapping("{id}")
   @ResponseStatus(HttpStatus.OK)
   public BookRepose update(@RequestBody BookRequest request, @PathVariable("id") long id) {
      return bookService.update(request, id);
    }

   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.OK)
   public void delete(@PathVariable("id") long id) {
        bookService.deleteById(id);
  }


}
