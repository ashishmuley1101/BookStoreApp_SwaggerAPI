package com.bridgelabz.bookstoreapp.services;

import com.bridgelabz.bookstoreapp.dto.BookStoreDTO;
import com.bridgelabz.bookstoreapp.model.BookStoreData;

import java.util.List;
import java.util.Optional;

public interface IBookStoreService {
    List<BookStoreData> getBookStoreData();

    BookStoreData getBookStoreDataById(int bookId);

    BookStoreData createBookStoreData(BookStoreDTO bookStoreDTO);

    //BookStoreData updateBookStoreData(BookStoreDTO bookStoreDTO);

    BookStoreData updateBookStoreData(int bookId, BookStoreDTO bookStoreDTO);

    void deleteBookStoreData(int bookId);
}
