package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.BookStoreDTO;
import com.bridgelabz.bookstoreapp.dto.ResponseDTO;
import com.bridgelabz.bookstoreapp.model.BookStoreData;
import com.bridgelabz.bookstoreapp.services.IBookStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bookstore")
//@Api telling the controller details
@Api(value = "Book Service",description = "My Book Store")
public class BookStoreController {
    @Autowired
    private IBookStoreService bookStoreService;


    //@ApiOperation for setting the methods name at UI end in Swagger API
    @ApiOperation(value = "Getting all books from store")
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getBookStoreData() {
        List<BookStoreData> bookStoreDataList ;
        bookStoreDataList = bookStoreService.getBookStoreData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", bookStoreDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @ApiOperation(value = "Getting all books from store by ID")
    @GetMapping("/get/{bookId}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("bookId") int bookId) {
        BookStoreData bookStoreData ;
        bookStoreData = bookStoreService.getBookStoreDataById(bookId);
        ResponseDTO respDTO = new ResponseDTO("Get Call for Id Successful ", bookStoreData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }


    @ApiOperation(value = "Storing new book")
    @PostMapping(path = "/create")
    public ResponseEntity<ResponseDTO> createBookStoreData(@Valid @RequestBody BookStoreDTO bookStoreDTO) {
        BookStoreData bookStoreData = null;
        bookStoreData = bookStoreService.createBookStoreData(bookStoreDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Address Book Data Successfully ", bookStoreData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }


    @ApiOperation(value = "Updating the book details by Id")
    @PutMapping("/update/{bookId}")
    public ResponseEntity<ResponseDTO> updateBookStoreData(@PathVariable("bookId") int bookId, @Valid @RequestBody BookStoreDTO bookStoreDTO) {
        BookStoreData bookStoreData = null;
        bookStoreData = bookStoreService.updateBookStoreData(bookId,bookStoreDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Address Book Data Successfully", bookStoreData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }



    @ApiOperation(value = "Deleting book by Id")
    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<ResponseDTO> deleteBookStoreData(@PathVariable("bookId") int bookId) {
        bookStoreService.deleteBookStoreData(bookId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " + bookId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
