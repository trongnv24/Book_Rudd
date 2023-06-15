package org.aibles.bookservice.service.impl;

import jakarta.persistence.Id;
import org.aibles.bookservice.dto.request.BookRequest;
import org.aibles.bookservice.dto.response.BookRepose;
import org.aibles.bookservice.entity.Book;
import org.aibles.bookservice.repository.BookRepository;
import org.aibles.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
 public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public BookRepose create(BookRequest request) {

        Book book = Book.from(request);
        book = bookRepository.save(book);
        BookRepose response = new BookRepose();
        response.setName(book.getName());
        response.setAuthor(book.getAuthor());
        response.setCode(book.getCode());

        return response;

    }
    @Override
    public BookRepose getById(long id) {
        Optional<Book> book = bookRepository.findById(id);
        Optional<Object> optionalBook = null;
        BookRepose response = new BookRepose();
        response.setName(book.get().getName());
        response.setAuthor(book.get().getAuthor());
        response.setCode(book.get().getCode());
        return response;
    }



    @Override
   public BookRepose update(BookRequest request, long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
      if (!optionalBook.isPresent()) {
           throw new RuntimeException();
       }
       Book book = optionalBook.get();
       book.setName(request.getName());
        book.setAuthor(request.getAuthor());
        book.setCode(request.getCode());
       BookRepose response = new BookRepose();
        response.setName(book.getName());
        response.setAuthor(book.getAuthor());
        response.setCode(book.getCode());
        return response;
    }

    @Override
    public void deleteById(long id) {
       bookRepository.deleteById(id);

    }

}