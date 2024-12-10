package com.adeindra6.repository.impl;

import java.util.Map;

import com.adeindra6.domain.Book;
import com.adeindra6.repository.BookRepository;

public class BookRepositoryImpl implements BookRepository {
    private Map<Long, Book> bookMap;

    @Override
    public Book findBookById(Long id) {
        Book book = bookMap.get(id);
        return book;
    }

    public Map<Long, Book> getBookMap() {
        return bookMap;
    }

    public void setBookMap(Map<Long, Book> bookMap) {
        this.bookMap = bookMap;
    }
}
