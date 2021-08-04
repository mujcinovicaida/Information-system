

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>registracija</title>
        <link rel="stylesheet" href="css/registracija.css">
    </head>
    <body>
        <div align="center">
        <h2>POPUNITE FORMU ZA REGISTRACIJU</h2>
        <form action="registracija" method="POST" class="regforma">
           
                <label>EMAIL:</label>
                <br>
                <input type="text" name="email">
                <br>
                <label>SIFRA:</label>
                <br>
                <input type="text" name="sifra">
                <br>
                <label>STATUS(1-aktivan;0-neaktivan):</label>
                <br>
                <input type="text" name="aktivnost">
                <br>
                <label>ULOGA(1-korisnik;2-urednik;3-admin):</label>
                <br>
                <input type="text" name="rolaID">
                <br>               
                <input id="registrujse" type="submit" value="DODAJ KORISNIKA">
           
        </form>
    </div>
    </body>
</html>
