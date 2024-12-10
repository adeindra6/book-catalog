package com.adeindra6.dto;

import java.io.Serializable;

public class BookDetailDTO implements Serializable {
    private static final long serialVersionUID = 881741962L;

    private Long bookId;
    private String authorName;
    private String bookTitle;
    private String bookDescription;

    public Long getBookId() {
        return bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public String getBookDescription() {
        return bookDescription;
    }
    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }
    @Override
    public String toString() {
        return "BookDetailDTO [bookId=" + bookId + ", authorName=" + authorName + ", bookTitle=" + bookTitle
                + ", bookDescription=" + bookDescription + ", getBookId()=" + getBookId() + ", getAuthorName()="
                + getAuthorName() + ", getBookTitle()=" + getBookTitle() + ", getBookDescription()="
                + getBookDescription() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }
}
