/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tastyBurger.DAO;

import com.tastyBurger.beans.customerBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author VBlue
 */
public class customerDAO {
    
    private Connection connection;
    private PreparedStatement insertCustomer = null;
    
    public customerDAO() {
        
        try {
            connection = connectionDAO.getConnection();
            
            insertCustomer = connection.prepareStatement("insert into customer(first_name, last_name, address, suburb, postcode, phone, email,                                                                                              password) values(?,?,?,?,?,?,?,?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int addCustomer (customerBean cus) {
        
        int updateResult = 0;
        
        try {
            insertCustomer.setString(1, cus.getFname());
            insertCustomer.setString(2, cus.getLname());
            insertCustomer.setString(3, cus.getAddress());
            insertCustomer.setString(4, cus.getSuburb());
            insertCustomer.setString(5, cus.getPostcode());
            insertCustomer.setString(6, cus.getPhoneNumber());
            insertCustomer.setString(7, cus.getEmail());
            insertCustomer.setString(8, cus.getPassword());
            
            updateResult = insertCustomer.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return updateResult;
    }
   
}
