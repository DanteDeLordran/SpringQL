package dev.darsaras.graphqldemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.darsaras.graphqldemo.model.Book;
import dev.darsaras.graphqldemo.model.BookInput;
import dev.darsaras.graphqldemo.repository.BookRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(BookInput bookInput) {
        new Book();
        Book book = Book.builder()
                .title(bookInput.title())
                .pages(bookInput.pages())
                .author(bookInput.author())
                .build();
        return bookRepository.save(book);
    }

}
