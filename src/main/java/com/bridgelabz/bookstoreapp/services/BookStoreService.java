package com.bridgelabz.bookstoreapp.services;

import com.bridgelabz.bookstoreapp.dto.BookStoreDTO;
import com.bridgelabz.bookstoreapp.exception.BookStoreException;
import com.bridgelabz.bookstoreapp.model.BookStoreData;
import com.bridgelabz.bookstoreapp.repository.IBookStoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookStoreService implements IBookStoreService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IBookStoreRepository bookStoreRepository;

    @Override
    public List<BookStoreData> getBookStoreData() {
        return bookStoreRepository.findAll();
    }

    @Override
    public BookStoreData getBookStoreDataById(int bookId) {
        return bookStoreRepository.findById(bookId).orElseThrow(()
                -> new BookStoreException("Book with bookId "+bookId+" does not exit..!"));
    }


    @Override
    public BookStoreData createBookStoreData(BookStoreDTO bookStoreDTO) {
        BookStoreData bookStoreData=modelMapper.map(bookStoreDTO,BookStoreData.class);
        return bookStoreRepository.save(bookStoreData);
    }

    @Override
    public BookStoreData updateBookStoreData(int bookId, BookStoreDTO bookStoreDTO) {
        BookStoreData bookStoreData = this.getBookStoreDataById(bookId);
        bookStoreData.updateBookStoreData(bookStoreDTO);
        return bookStoreRepository.save(bookStoreData);
    }


    @Override
    public void deleteBookStoreData(int bookId) {
        BookStoreData addressData = this.getBookStoreDataById(bookId);
        bookStoreRepository.delete(addressData);


    }
}
