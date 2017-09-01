/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tastyBurger.BO;

import com.tastyBurger.DAO.customerDAO;
import com.tastyBurger.beans.customerBean;
import com.tastyBurger.beans.loginBean;
import java.util.Random;

/**
 *
 * @author VBlue
 */
public class customerBO {
    
    customerDAO cusOperations = new customerDAO();
    
    public int addCustomer (customerBean customer) {
        
        int addCus = cusOperations.addCustomer(customer);
        
        return addCus;
    }
    
    public int login (loginBean lb) {
        int result = cusOperations.login(lb);
        return result;
    }
    
    public int randomNumber() throws Exception {
		
        // create random object
	Random randomno = new Random();
	 
	// check next int value  
	int j = randomno.nextInt(10000);
	System.out.println("Code value: " + j);
	return j;
    }
    
    public int setCode(int code, String email) throws Exception {
        int result = cusOperations.setCode(code, email);
        return result;
    }
    
}
