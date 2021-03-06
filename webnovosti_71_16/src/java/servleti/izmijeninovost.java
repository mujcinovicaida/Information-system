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
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import novosti.post;


/**
 *
 * @author Merisa
 */
public class izmijeninovost extends HttpServlet {

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

        HttpSession sesija = request.getSession();
        post p= (post) sesija.getAttribute("post");

        String naslov = request.getParameter("naslov");
        String sadrzaj_posta = request.getParameter("sadrzaj_posta");
        String ID=request.getParameter("ID");
        
        p.setNaslov(naslov);
        p.setSadrzaj_posta(sadrzaj_posta);

        sesija.setAttribute("post", p);

        String upit="update post set naslov=?,sadrzaj_posta=? where ID=?;";
                
        Connection con = null;
        
        String address = "all.jsp";
        
        try {
            con = NovostiDB.getConnection();
            PreparedStatement ps = con.prepareStatement(upit);
           ps.setString(1,naslov);
                    ps.setString(2, sadrzaj_posta);
                    ps.setString(3, ID);
                    ps.executeUpdate();
           
            
            con.close();
        } catch (SQLException e) {
            sesija.invalidate();
            String err = e.getMessage();
            request.setAttribute("errormsg", err);
            address = "error";

        }

        request.setAttribute("poruka", "Podaci su uspje??no izmijenjeni!");
        RequestDispatcher rd = request.getRequestDispatcher(address);
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