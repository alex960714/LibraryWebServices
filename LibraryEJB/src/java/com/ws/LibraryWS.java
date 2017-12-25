/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws;

import com.sessions.LibrarySessions;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author User
 */
@WebService(serviceName = "LibraryWS")
@Stateless()
public class LibraryWS {

    @EJB
    private LibrarySessions session;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod
    public ArrayList<String> getLibrary(){
        return session.getLibrary();
    }
    
    @WebMethod
    public void addNewBook(String isbn, String authors, String year,
            String publisher, String bookName){
        session.addNewBook(isbn, authors, year, publisher, bookName);
    }
    
    @WebMethod
    public boolean addNewExemplar(String isbn, Integer num){
        return session.addNewExemplar(isbn, num);
    }
    
    @WebMethod
    public boolean takeBook(String isbn){
        return session.takeBook(isbn);
    }
    
    @WebMethod
    public boolean returnBook(String isbn){
        return session.returnBook(isbn);
    }
}
