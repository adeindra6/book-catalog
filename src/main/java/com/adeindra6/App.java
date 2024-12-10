package com.adeindra6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adeindra6.config.AppConfig;
import com.adeindra6.domain.Author;
import com.adeindra6.dto.BookDetailDTO;
import com.adeindra6.service.AuthService;
import com.adeindra6.service.BookService;
import com.adeindra6.service.impl.EmailServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "大家好" );
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

        BookService bookService = (BookService) appContext.getBean("bookService");
        BookDetailDTO bookDetailDTO = bookService.findBookDetailById(2L);
        System.out.println("Book Detail: " + bookDetailDTO);

        Author author = (Author) appContext.getBean("author");
        System.out.println(author);

        EmailServiceImpl emailService = (EmailServiceImpl) appContext.getBean("emailService");
        emailService.sendMail("test@gmail.com", "老鼠爱大米", "Played by 马胜杰");

        AuthService authService = (AuthService) appContext.getBean("authService");
        authService.login("test@gmail.com");

        // To run this program
        // mvn org.springframework.boot:spring-boot-maven-plugin:run
    }
}
