

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>dodajnovost</title>
        <link rel="stylesheet" href="css/dodajnovost.css">
    </head>
    <body>
       
        <div align="center">
             <h2>Dodajte novost</h2>
            <form action="dodajnovost" method="POST" id="dodajformaid">
            <label>NASLOV:</label>
            <br>
            <input type="text" name="naslov">
            <br>
            <label>SADRZAJ NOVOSTI:</label>
            <br>
            <input id="sadpostaid1" type="text" name="sadrzaj_posta">
            <br>
            
            <input id="inputdodajid" type="submit" value="DODAJ NOVOST">
        </form>
        </div>
        
    </body>
</html>