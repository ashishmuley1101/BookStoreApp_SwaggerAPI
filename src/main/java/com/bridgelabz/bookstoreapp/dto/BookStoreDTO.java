package com.bridgelabz.bookstoreapp.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public @ToString class BookStoreDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = " Book Name Invalid...!")
    public String bookName;

    @NotNull(message = "Author name cannot be null")
    public String author;

    @NotNull(message = "Book description cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Description Is Invalid")
    public String bookDescription;

    @NotNull(message = "Price cannot be null")
    public int price;
}
