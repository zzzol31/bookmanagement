package com.bookmanagement.bookmanagement.Service;

import com.bookmanagement.bookmanagement.Entity.Book;
import com.bookmanagement.bookmanagement.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        Optional<Book> opt = bookRepository.findById(id);
        return opt.orElse(null);
    }

    public Book updateBook(Book book){
        Optional<Book> opt = bookRepository.findById(book.getId());
        if(opt.isPresent()){
            Book updatedBook = opt.get();
            updatedBook.setName(book.getName() == null ? updatedBook.getName() : book.getName());
            updatedBook.setPage(book.getPage());
            return bookRepository.save(updatedBook);
        }
        return null;
    }

    public void deletedBookById(Long id){
        Optional<Book> opt = bookRepository.findById(id);
        opt.ifPresent(book -> bookRepository.deleteById(book.getId()));
    }
}
