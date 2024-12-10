package com.adeindra6.service;

import com.adeindra6.dto.BookDetailDTO;

public interface BookService {
    public BookDetailDTO findBookDetailById(Long bookId);
}
