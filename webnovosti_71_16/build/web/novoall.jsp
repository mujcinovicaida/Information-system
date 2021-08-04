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
        <title>gost-novosti</title>
        <link rel="stylesheet" href="css/novoall.css">

    </head>
    <body>
        <div align="center">
        <h2>Dobrodosli na informacioni sistem!</h2>
        <form action="novostiispisgost" method="POST">
            <input type="submit" value="POGLEDAJ NOVOSTI">
        </form>
        
        <table>
               <c:forEach items="${rezultati}" var="nov">              
                    
                    <tr>
                        <th id="naslovi">
                            ${nov.naslov} 
                          </th>
                    </tr> 
                    <tr>
                        <th id="sadrzaj">
                            ${nov.sadrzaj_posta}
                        </th>
                    </tr>
                </c:forEach>
           </table>
    </div>
    </body>
</html>
