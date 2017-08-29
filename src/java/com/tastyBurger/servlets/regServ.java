/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tastyBurger.servlets;

import com.tastyBurger.BO.customerBO;
import com.tastyBurger.beans.customerBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author VBlue
 */
@WebServlet(name = "regServ", urlPatterns = {"/regServ"})
public class regServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;
        
        customerBean cus = new customerBean();
        customerBO cusBO = new customerBO();
        
        cus.setFname(request.getParameter("inputFirstName"));
        cus.setLname(request.getParameter("inputLastName"));
        cus.setAddress(request.getParameter("inputAddress"));
        cus.setSuburb(request.getParameter("inputSuburb"));
        cus.setPostcode(request.getParameter("inputPostcode"));
        cus.setPhoneNumber(request.getParameter("inputPhone"));
        cus.setEmail(request.getParameter("exampleInputEmail1"));
        cus.setPassword(request.getParameter("exampleInputPassword1"));
        cus.setConfirmPassword(request.getParameter("exampleInputConfirmPassword1"));
        
        int addCus = cusBO.addCustomer(cus);
        
        if (addCus > 0) {
            rd = request.getRequestDispatcher("/thankyou.html");
        } else {
            rd = request.getRequestDispatcher("/temp.html");
        }
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
