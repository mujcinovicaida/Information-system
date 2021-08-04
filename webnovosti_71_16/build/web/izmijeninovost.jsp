

<%@page import="novosti.post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>izmijeninovost</title>
        <link rel="stylesheet" href="css/izmijeninovost.css">
    </head>
    <body>
        <div align="center">
        <h2>Unesite novu izmjenu u ovom postu</h2>
        
            <form action="izmijeninovost" method="POST" id="izmijeniforma">
            <input type="hidden" name="ID" value="${post.ID}">
            <br>
            <label>NASLOV</label>
            <br>
            <input type="text" name="naslov" value="${post.naslov}">
            <br>
            <label>SADRZAJ POSTA</label> 
            <br><input id="sadpostaid" type="text" name="sadrzaj_posta" value="${post.sadrzaj_posta}">
            <br>
            
            <button type="submit" >IZMIJENI</button>
        </form>

        
    </div>
    </body>
</html>