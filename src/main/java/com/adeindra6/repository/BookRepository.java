package com.adeindra6.repository;
import com.adeindra6.domain.Book;;

public interface BookRepository {
    public Book findBookById(Long id);
}
