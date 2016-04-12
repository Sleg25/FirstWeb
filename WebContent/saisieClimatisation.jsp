<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Formulaire de saisie</title>
	
	<script type="text/javascript" src="jquery-2.2.2.js"></script>
	<script type="text/javascript" src="Climatisation.js"></script>
	</head>
	<body>
		
  		<c:choose>
			 <c:when test="${not empty sessionScope.userName}">
				<div>${sessionScope.userName} est connecté</div>
				<a href="LogOutController"> Se déconnecter</a>
				<br/><br/>
			</c:when>	
			<c:otherwise>
				<a href="LoginController"> Se connecter</a>
				<br/><br/>
			</c:otherwise>
		</c:choose>
		
		<div>${SauvegardeErreur}</div>
		<form action="ClimatisationController" method="POST">
			<label style="">Saisir le nom de l'appareil</label> <input id="sourceNb" type = "text" value="${nom}" name="nom">
			<span style="color:red">${nomErreur}</span>
			<span id= "nbId" style="color:blue"></span><br/>
			
			<label>Saisir la température en degré celsius</label><input type = "text" value="${temperature}" name="temperature"><span style="color:red">${temperatureErreur}</span><br/>
			<label>Saisir la pression en bars </label><input type = "text" value="${pression}" name="pression"><span style="color:red">${pressionErreur}</span><br/>
			<label>Saisir le taux d'humidité </label><input type = "text" value="${tauxHumidite}" name="tauxHumidite"><span style="color:red">${humiditeErreur}</span><br/>
			<input type="submit" value="Enregistrer" name="valider"></label><br/>
		</form>
		
		<br/><br/>
		
	
	</body>
</html>