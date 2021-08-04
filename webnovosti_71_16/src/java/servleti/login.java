/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import DB.NovostiDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import novosti.korisnik;

public class login extends HttpServlet {

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
        korisnik k = new korisnik();
        String email = request.getParameter("email");
        String sifra = request.getParameter("sifra");
        
        String poruka = "";
        if (email.isEmpty() || sifra.isEmpty()) {
            poruka = "Niste popunili sva polja";
            request.setAttribute("poruka", poruka);
            RequestDispatcher rd = request.getRequestDispatcher("/sveVijesti.jsp");
            rd.forward(request, response);
        }
        
        Connection con = null;
        Statement stmt = null;
        
        String address_3 = "all.jsp";
        String address_2 = "all.jsp";
        String address_1 = "novoall.jsp";
        String address;
        String upit = "select * from korisnik where email = '" + email + "' and sifra = '" + sifra + "'";
        ResultSet rs = null;
        try {
            con = NovostiDB.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(upit);
            
            if (rs.next()) {
                k.setID(rs.getString("ID"));
                k.setEmail(rs.getString("email"));
                k.setSifra(rs.getString("sifra"));
                k.setAktivnost(rs.getString("aktivnost"));
                k.setRolaID(rs.getString("rolaID"));
                stmt.close();
                
                sesija.setAttribute("korisnik", k);
                
            } else {
                poruka = "Neispravno kosisnicko ime i password! pokusajte ponovo!";
                request.setAttribute("poruka", poruka);
                address = "login.jsp";
                stmt.close();
            }
           
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
