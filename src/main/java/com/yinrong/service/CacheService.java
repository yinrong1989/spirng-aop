package com.yinrong.service;

import com.yinrong.exception.BookNotFoundException;
import com.yinrong.model.Book;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author yinrong
 * @className CacheService
 * @description ${description}
 * @date 2017/3/9
 */
@Component
//这里定义了之后就不必在下面的每个方法上写 cacheNames="books" 了
@CacheConfig(cacheNames = "books")
public class CacheService {

    @Cacheable(key="#isbn")
    public Book findBook(String isbn) throws BookNotFoundException {
        System.out.println("isbn="+isbn+" 方法调用");
        Book book = null;
        if (isbn == "123") {
            book = new Book("123", "Thinking in Java");
        } else if (isbn == "456") {
            book = new Book("456", "Effective Java");
        } else {
            throw new BookNotFoundException("没有找到isbn对应的书");
        }
        return book;

    }
    @CachePut(key="#isbn")
    public Book updateBook(String isbn,String bookName){
        System.out.println("isbn=" + isbn + " bookName="+bookName+" 更新缓存的方法被调用");
        Book book = new Book(isbn,bookName);
        return book;
    }
    @CacheEvict(allEntries=true)
    public void loadBooks(){
        System.out.println("清除缓存的方法被调用");
    }
}