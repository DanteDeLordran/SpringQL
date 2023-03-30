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

    public Book updateBook(Long id,BookInput bookInput) {
        Book bookToUpdate = bookRepository.findById(id).orElse(null);
        if(bookToUpdate == null) {
            throw new RuntimeException("Book not found");
        }
        bookToUpdate.setTitle(bookInput.title());
        bookToUpdate.setPages(bookInput.pages());
        bookToUpdate.setAuthor(bookInput.author());
        bookRepository.save(bookToUpdate);
        return bookToUpdate;
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}
