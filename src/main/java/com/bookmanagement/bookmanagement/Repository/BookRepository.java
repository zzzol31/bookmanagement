package com.bookmanagement.bookmanagement.Repository;

import com.bookmanagement.bookmanagement.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
