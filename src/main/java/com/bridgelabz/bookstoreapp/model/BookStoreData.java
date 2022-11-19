package com.bridgelabz.bookstoreapp.model;


import com.bridgelabz.bookstoreapp.dto.BookStoreDTO;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "book_store")
public @Data class BookStoreData {

       @Id
       @GeneratedValue
       @Column(name = "book_id")
        private int bookId;

        @Column(name = "book_name")
        private String bookName;

        @Column(name = "author")
        private String author;

        @Column(name = "book_description")
        private String bookDescription;

        @Column(name = "price")
        private int price;

        public BookStoreData(BookStoreDTO bookStoreDTO) {
                this.updateBookStoreData(bookStoreDTO);
        }

        public BookStoreData() {

        }

        public void updateBookStoreData(BookStoreDTO bookStoreDTO) {

                this.bookName= bookStoreDTO.bookName;
                this.author=bookStoreDTO.author;
                this.bookDescription=bookStoreDTO.bookDescription;
                this.price=bookStoreDTO.price;

        }
}
