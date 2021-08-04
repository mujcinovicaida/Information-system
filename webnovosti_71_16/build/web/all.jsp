
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="novosti.post"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/all.css">
        <title>svevijesti</title>
    </head>
    <body>
        <div align="center">

                <h2>Dobrodošli na informacioni sistem!</h2> 
                <a href="dodajnovost.jsp">DODAJ NOVOST</a>
                    
                    <form action="novostispis" method="POST">
                    <input id="pogledajnovostiid" type="submit" value="POGLEDAJ NOVOSTI">
                    </form><br>
              
                <table>
                    <c:forEach items="${rezultati}" var="nov">
                    
                    <tr>                       
                        <th id="naslovi1"> ${nov.naslov};</th>
                    </tr>
                    <tr>
                        <th id="sadrzaj1">${nov.sadrzaj_posta}</th>
                    </tr>
                    <tr>
                        <th>                         
                                <form action="pokupiid" method="POST">
                                <button type="submit" name="pokupi" value="${nov.ID}">IZMIJENI</button>   
                                </form>    
                        </th>
                        <th>
                                <form action="obrisinovost" method="POST">
                                <button type="submit" name="obrisi" value="obrisinovost-${nov.ID}">OBRIŠI</button>
                                </form>
                        </th>
                    </tr>
                    </c:forEach>
                </table>
        </div>
    </body>
</html>