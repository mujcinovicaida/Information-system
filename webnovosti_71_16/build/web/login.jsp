
<!DOCTYPE html >
<!-- <%
	String param1 = application.getInitParameter("param1");
 
%> -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css/login.css">


</head>
<body>
	<div id="centered">    
            
                <div align="center">
                    <h1>${(poruka!=null) ? poruka : "Dobrodosli na nas informacioni sistem!"} </h1>
                            <h2> Prijava na sistem</h2>
                    <form action="login" method="POST">
                        <div class="tabela">
                                <p>EMAIL: </p>
                                <input type="text" name="email" value="${korisnik.email}" size="20"/>
                                <p>SIFRA: </p>          
                                <input type="password" name="sifra" value="${korisnik.sifra}" size="20"/>
                                <br>
                                <input id="ulogujse" type="submit" value="ULOGUJTE SE"/>
                        </div>
                    </form>
                 </div>
                <div align="center">

                    <a href="registracija.jsp">REGISTRUJTE SE</a>
                    <br><br>
                    <a href="novoall.jsp">PRIJAVITE SE KAO GOST</a>
                </div>
	</div>
</body>
</html>
