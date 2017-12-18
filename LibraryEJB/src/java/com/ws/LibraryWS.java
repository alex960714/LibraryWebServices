/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws;

import com.sessions.EmployeeSession;
import com.sessions.UserSession;
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
    private EmployeeSession emp;
    @EJB
    private UserSession usr;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}
