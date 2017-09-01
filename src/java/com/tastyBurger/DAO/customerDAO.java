/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tastyBurger.DAO;

import com.tastyBurger.beans.customerBean;
import com.tastyBurger.beans.loginBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VBlue
 */
public class customerDAO {
    
    private Connection connection;
    private PreparedStatement insertCustomer = null;
    private PreparedStatement loginQuery = null;
    private PreparedStatement codeInsert = null;
    
    public customerDAO() {
        
        try {
            connection = connectionDAO.getConnection();
            
            insertCustomer = connection.prepareStatement("insert into customer(first_name, last_name, address, suburb, postcode, phone, email,                                                                                              password) values(?,?,?,?,?,?,?,?)");
            loginQuery = connection.prepareStatement("select password from customer where email=?");
            codeInsert = connection.prepareStatement("update customer set code=? where email=?");
        } catch (SQLException ex) {
            Logger.getLogger(customerDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            
        } catch (SQLException ex) {
            Logger.getLogger(customerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionDAO.closeConnection(connection);
	}
        
        return updateResult;
    }
    
    public int login(loginBean lb) {
        
        int result = 0;
        
        try {
            loginQuery.setString(1, lb.getEmail());
            
            ResultSet rs = loginQuery.executeQuery();
            
            String DBPassword = rs.getString(1);
            
            if (DBPassword.equals("")) {
                result = 1;
            } else if (DBPassword.equals(lb.getPassword())) {
                result = 2;
            } else {
                result = 3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(customerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionDAO.closeConnection(connection);
	}
        
        return result;
    }
    
    public int setCode(int code, String email) throws SQLException {
		
	
	int j = 0;
	try {
            codeInsert.setInt(1, code);
            codeInsert.setString(2, email);
            
            j = codeInsert.executeUpdate();
           
	} catch (SQLException ex) {
            Logger.getLogger(customerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionDAO.closeConnection(connection);
	}
        return j;
    }
   
}
