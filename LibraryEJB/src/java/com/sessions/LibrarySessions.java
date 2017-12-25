/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessions;

import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author User
 */
@Stateless
@LocalBean
public class LibrarySessions {
    private ArrayList<Book> library;

    public LibrarySessions() {
        library = new ArrayList<>();
        library.add(new Book("5-352-00754-5","Hemingway E.","2005","Azbuka-classika","For Whom the Bell Tolls",2));
        library.add(new Book("5-02-013996-3","Samarsky A.A., Gulin A.V.","1989","Nauka","Numerical analisys",3));
        library.add(new Book("0-387-96131-3","Preparata F., Sheimos M.","1989","Mir","Computational geometry",2));
        library.add(new Book("5-94774-537-2","Irodov I.E.","2006","BINOM","Electromagnetism",4));
    }

    public ArrayList<String> getLibrary() {
        ArrayList<String> books = new ArrayList<>();
        for(Book book: library){
            books.add(book.getInfo());
        }
        return books;
    }
    
    public void addNewBook(String isbn, String authors, String year,
            String publisher, String bookName){
        for(Book book:library){
            if(isbn.equals(book.getIsbn())){
                return;
            }
        }
        library.add(new Book(isbn,authors,year,publisher,bookName,1));
    }
    
    public boolean addNewExemplar(String isbn, Integer num){
        for(Book book:library){
            if(isbn.equals(book.getIsbn())){
                book.addExemplar(num);                
                return true;
            }
        }
        return false;
    }
    
    public boolean takeBook(String isbn){
        for(Book book:library){
            if(isbn.equals(book.getIsbn())){
                return book.takeBook();
            }
        }
        return false;
    }
    
    public boolean returnBook(String isbn){
        for(Book book:library){
            if(isbn.equals(book.getIsbn())){
                book.returnBook();
                return true;
            }
        }
        return false;
    }
}
