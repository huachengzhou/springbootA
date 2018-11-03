package com.blue.ioc.spel;

import com.blue.domin.BookA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    @Bean(name = "bookA")
    public BookA getBook(){
        BookA book = new BookA();
        book.setAuthor("#{'blake'}");
        book.setBookmark("#{9.87E4}");
        return book;
    }
}
