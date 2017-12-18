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
public class UserSession {
    public ArrayList<ArrayList<String>> getBooksList(){
        return null;
    }
    
    public boolean takeBook(String isbn){
        return false;
    }
    
    public void returnBook(String isbn){
        
    }
}
