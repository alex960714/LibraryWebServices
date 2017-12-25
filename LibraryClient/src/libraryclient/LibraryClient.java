/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryclient;

import com.ws.LibraryWS;
import com.ws.LibraryWS_Service;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class LibraryClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LibraryWS_Service serviceHolder = new LibraryWS_Service();
        LibraryWS service = serviceHolder.getLibraryWSPort();
        
        String isbn;
        String authors;
        String year;
        String publisher;
        String bookName;
        Integer numAvailable;
        
        Scanner in = new Scanner(System.in);
        System.out.println("Please, enter your credentials:");
        String login = in.next();
        if(login.equals("root")){
            System.out.println("Welcome, root!");
            while(true){
                System.out.println("Please, choose action:");
                System.out.println("1. Show list of the books");
                System.out.println("2. Add new book");
                System.out.println("3. Add new book exemplar");
                int action = in.nextInt();
                switch(action){
                    case 1:
                        System.out.println("List of books in library:");
                        ArrayList<String> books = (ArrayList) service.getLibrary();
                        for(String book: books){
                            System.out.println(book);
                        }
                        break;
                    case 2: 
                        System.out.println("Please, enter next parameters:");
                        System.out.println("ISBN:");
                        isbn = in.next();
                        System.out.println("Authors:");
                        authors = in.next();
                        System.out.println("Year of publishing:");
                        year = in.next();
                        System.out.println("Publisher:");
                        publisher = in.next();
                        System.out.println("Name of book:");
                        bookName = in.next();
                        service.addNewBook(isbn, authors, year, publisher, bookName);
                        break;
                    case 3:
                        System.out.println("Please, enter next parameters:");
                        System.out.println("ISBN:");
                        isbn = in.next();
                        System.out.println("Number of exemplars:");
                        Integer num = in.nextInt();
                        if(service.addNewExemplar(isbn, num)){
                            System.out.println("Your books were added successfully");
                        }
                        else{
                            System.out.println("Sorry, this book does not exist. You should firstly add this book into library");
                        }
                        break;
                    default:
                        System.out.println("Incorrect command. Please, try again.");
                }
            }
        }
        else if(login.equals("user")){
            System.out.println("Welcome, user!");
            while(true){                
                System.out.println("Please, choose action:");
                System.out.println("1. Show list of the books");
                System.out.println("2. Take a book");
                System.out.println("3. Return a book");
                int action = in.nextInt();
                switch(action){
                    case 1:
                        System.out.println("List of books in library:");
                        ArrayList<String> books = (ArrayList) service.getLibrary();
                        for(String book: books){
                            System.out.println(book);
                        }
                        break;
                    case 2:
                        System.out.println("Please, enter next parameters:");
                        System.out.println("ISBN:");
                        isbn = in.next();
                        if(service.takeBook(isbn)){
                            System.out.println("This book was reserved to you successfully");
                        }
                        else{
                            System.out.println("Sorry, no exemplars of this book are available");
                        }
                        break;
                    case 3:
                        System.out.println("Please, enter next parameters:");
                        System.out.println("ISBN:");
                        isbn = in.next();
                        if(service.returnBook(isbn)){
                            System.out.println("This book was returned successfully");
                        }
                        else{
                            System.out.println("Sorry, this book does not exist.");
                        }
                        break;
                    default:
                        System.out.println("Incorrect command. Please, try again.");
                }
            }
        }
        else{
            System.out.println("Access denied");
        }
    }
    
}
