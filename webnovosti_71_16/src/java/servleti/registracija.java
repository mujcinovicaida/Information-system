/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import novosti.korisnik;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DB.NovostiDB;


public class registracija extends HttpServlet {

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

        korisnik k = new korisnik();

        String email = request.getParameter("email");
        String sifra = request.getParameter("sifra");
        String aktivnost = request.getParameter("aktivnost");
        String rolaID = request.getParameter("rolaID");
        

        k.setEmail(email);
        k.setSifra(sifra);
        k.setAktivnost(aktivnost);
        k.setRolaID(rolaID);
        

        HttpSession sesija = request.getSession();
        sesija.setAttribute("korisnik", k);

        String upit = "insert into korisnik(email, sifra, aktivnost, rolaID ) values ('" + email + "', '" + sifra + "', '" + aktivnost + "', '" + rolaID +  "')";

        Connection con = null;
        Statement stmt = null;
        String address_3 = "all.jsp";
        String address_2 = "all.jsp";
        String address_1 = "novoall.jsp";
        String address;

        try {
            con = NovostiDB.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(upit);
            stmt.close();
            con.close();
        } catch (SQLException e) {
            sesija.invalidate();
            String err = e.getMessage();
            request.setAttribute("errormsg", err);
            address = "error";

        }
         if(k.getRolaID().equals("1")){
            request.setAttribute("poruka", "Podaci su uspješno dodani!");
            RequestDispatcher rd = request.getRequestDispatcher("novoall.jsp");
            rd.forward(request, response);
        }else if(k.getRolaID().equals("2")){
            request.setAttribute("poruka", "Podaci su uspješno dodani!");
            RequestDispatcher rd = request.getRequestDispatcher(address_2);
            rd.forward(request, response);
        }else if(k.getRolaID().equals("3")){
            request.setAttribute("poruka", "Podaci su uspješno dodani!");
            RequestDispatcher rd = request.getRequestDispatcher(address_3);
            rd.forward(request, response);
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
