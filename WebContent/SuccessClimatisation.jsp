<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Bonjour ${userName}</p>
 	<div>Nom de l'appareil : ${nom}</div>
 	<p>Température : ${temperature} </p>
 	<p>Pression : ${pression}</p>
 	<p>Taux humidité : ${tauxHumidite}</p>
 	${erreurs}
 	
 	<br/><br/>
 	<a href="ListeController"> Accéder à la liste des climatiseurs</a><br/>
 	<a href="LogOutController"> Se déconnecter</a>
</body>
</html>