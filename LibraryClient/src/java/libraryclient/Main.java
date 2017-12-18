/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryclient;

import com.ws.*;

/**
 *
 * @author User
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LibraryWS_Service serviceHolder = new LibraryWS_Service();
        LibraryWS service = serviceHolder.getLibraryWSPort();
        System.out.println(service.hello(" from EHB"));
    }
    
}