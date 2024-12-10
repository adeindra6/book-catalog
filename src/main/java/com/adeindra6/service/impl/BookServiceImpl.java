package com.adeindra6.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adeindra6.domain.Book;
import com.adeindra6.dto.BookDetailDTO;
import com.adeindra6.repository.BookRepository;
import com.adeindra6.service.BookService;;

@Service("bookService")
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        super();
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDetailDTO findBookDetailById(Long bookId) {
        Book book = bookRepository.findBookById(bookId);
        BookDetailDTO dto = new BookDetailDTO();

        dto.setBookId(book.getId());
        dto.setAuthorName(book.getAuthor().getName());
        dto.setBookTitle(book.getTitle());
        dto.setBookDescription(book.getDescription());

        return dto;
    }

    /*
    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    */
}
