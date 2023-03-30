package dev.darsaras.graphqldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.darsaras.graphqldemo.model.Book;

public interface BookRepository extends JpaRepository<Book,Long>{

    
}
