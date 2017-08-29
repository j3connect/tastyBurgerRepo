/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tastyBurger.BO;

import com.tastyBurger.DAO.customerDAO;
import com.tastyBurger.beans.customerBean;

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
    
}
