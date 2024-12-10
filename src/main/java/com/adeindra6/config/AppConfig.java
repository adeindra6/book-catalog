package com.adeindra6.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.adeindra6.domain.Author;
import com.adeindra6.domain.Book;
import com.adeindra6.repository.BookRepository;
import com.adeindra6.repository.impl.BookRepositoryImpl;
import com.adeindra6.service.AuthService;
import com.adeindra6.service.EmailService;
import com.adeindra6.service.impl.AuthServiceImpl;
import com.adeindra6.service.impl.EmailDummyServiceImpl;
import com.adeindra6.service.impl.EmailServiceImpl;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;

@ComponentScan(basePackages = {"com.adeindra6"})
@Configuration
public class AppConfig {

    @Bean
    public Author author() {
        return new Author(1L, "ade indra pratama", -16401L);
    }

    @Bean
    @Primary
    public Book book1(Author author) {
        Book book = new Book();

        book.setId(1L);
        book.setTitle("Book 1");
        book.setDescription("Book 1 Description");
        book.setAuthor(author);

        return book;
    }

    @Bean
    public Book book2(Author author) {
        Book book = new Book();

        book.setId(2L);
        book.setTitle("Book 2");
        book.setDescription("Book 2 Description");
        book.setAuthor(author);

        return book;
    }

    @Bean
    public Properties mailProperties() {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", true);
        prop.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        prop.put("mail.smtp.port", 25);
        prop.put("mail.smtp.ssl.trust", "sandbox.smtp.mailtrap.io");

        return prop;
    }

    @Bean
    public PasswordAuthentication passwordAuthentication() {
        return new PasswordAuthentication("bf8ee517ed01e1", "4de5f3af5c9007");
    }

    @Bean
    public Session mailSession(@Qualifier("mailProperties") Properties mailProperties, PasswordAuthentication passwordAuthentication) {
        return Session.getInstance(mailProperties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return passwordAuthentication;
            }
        });
    }

    @Bean
    public EmailService emailService(Session mailSession) {
        return new EmailServiceImpl(mailSession);
    }

    @Bean
    public EmailService emailDummyService() {
        return new EmailDummyServiceImpl();
    }

    @Bean
    public AuthService authService(@Qualifier("emailDummyService") EmailService emailService) {
        return new AuthServiceImpl(emailService);
    }

    @Bean
    public BookRepository bookRepository(Book book1, Book book2) {
        Map<Long, Book> bookMap = new HashMap<Long, Book>();
        bookMap.put(1L, book1);
        bookMap.put(2L, book2);

        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        bookRepository.setBookMap(bookMap);

        return bookRepository;
    }
}
