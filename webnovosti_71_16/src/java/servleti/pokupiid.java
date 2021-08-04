/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import DB.NovostiDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import novosti.post;



public class pokupiid extends HttpServlet {

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
        NovostiDB novostiDao=new NovostiDB();
        
        int vijestID=Integer.valueOf(request.getParameter("pokupi")); 
        
        Connection con=null;
        Statement stmt=null;
        String address="izmijeninovost.jsp";
        post p=new post();
        try{
            con=NovostiDB.getConnection();
            stmt=con.createStatement();
            String upit="select * from post where ID="+vijestID;
            PreparedStatement ps = con.prepareStatement(upit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.setID(rs.getString("ID"));
                p.setNaslov(rs.getString("naslov"));
                p.setSadrzaj_posta(rs.getString("Sadrzaj_posta"));
                
            }
            request.setAttribute("post", p);
            RequestDispatcher dispatcher = request.getRequestDispatcher("izmijeninovost.jsp");
		dispatcher.forward(request, response);
        } catch (SQLException e) {
            
            String err = e.getMessage();
            request.setAttribute("errormsg", err);
            address = "error.jsp";
        }
        
        
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