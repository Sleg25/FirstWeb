<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		<h1>
			${dateDuJour}
			<br/>
			Il est ${heure}
			</h1>
			<br/>
			Les données mesurées par le capteur sont : 
			<br/>
				Température : ${clim1.getTemperature()} °C, <br/>
				ce que fait : ${clim1.getTemperatureFarenheit()} F<br/>
				Pression : ${clim1.getPression()} bars<br/>
	
	</body>
</html>