package dev.darsaras.graphqldemo.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import dev.darsaras.graphqldemo.model.Book;
import dev.darsaras.graphqldemo.model.BookInput;
import dev.darsaras.graphqldemo.service.BookService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // query FindAllBooks {
    //     findAllBooks{
    //       id
    //       title
    //       author
    //       pages
    //     }
    // }
    @QueryMapping
    public List<Book> findAllBooks(){
        return bookService.allBooks();
    }
    
    // mutation CreateBook {
    //     createBook(bookInput:{
    //       title:"Yo",
    //       pages:9999,
    //       author:"Londor"
    //     }){
    //       title
    //       pages
    //       author
    //     }
    // }
    @MutationMapping
    public Book createBook(@Argument BookInput bookInput){
        return bookService.createBook(bookInput);
    }

    @MutationMapping
    public Book updateBook(@Argument Long id, @Argument BookInput bookInput){
        return bookService.updateBook(id, bookInput);
    }

    @MutationMapping
    public void deleteBook(@Argument Long id){
        bookService.deleteBook(id);
    }
}
