package com.bridgelabz.bookstoreapp.repository;

import com.bridgelabz.bookstoreapp.model.BookStoreData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookStoreRepository extends JpaRepository<BookStoreData,Integer> {

}
