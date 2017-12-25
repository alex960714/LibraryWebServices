/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessions;

/**
 *
 * @author User
 */
public class Book {
    private String isbn;
    private String authors;
    private String year;
    private String publisher;
    private String bookName;
    private Integer numAvailable;

    public Book(String isbn, String authors, String year, 
            String publisher, String bookName, Integer numOverall) {
        this.isbn = isbn;
        this.authors = authors;
        this.year = year;
        this.publisher = publisher;
        this.bookName = bookName;
        this.numAvailable = numOverall;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthors() {
        return authors;
    }

    public String getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getBookName() {
        return bookName;
    }
    
    public void addExemplar(Integer numAvailable) {
        this.numAvailable += numAvailable;
    }

    public boolean takeBook() {
        if(numAvailable > 0){
            numAvailable--;
            return true;
        }
        return false;
    }

    public void returnBook() {
        numAvailable++;
    }
    
    public String getInfo(){
        return isbn+" "+authors+" "+year+" "
                +bookName+" "+numAvailable.toString();
    }
}
