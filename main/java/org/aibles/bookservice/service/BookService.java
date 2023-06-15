package org.aibles.bookservice.service;

import org.aibles.bookservice.dto.request.BookRequest;
import org.aibles.bookservice.dto.response.BookRepose;

import java.awt.print.Book;

public interface BookService {

    BookRepose create(BookRequest request);
    BookRepose getById(long id);

    BookRepose update(BookRequest request, long id);

    void deleteById(long id);



}




