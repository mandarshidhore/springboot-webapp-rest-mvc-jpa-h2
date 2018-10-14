<html>
<head>
	<title>Spring Boot Web App rest mvc jpa h2</title>
</head>
<body>
	athlete age = ${f_name}
	athlete first name = ${l_name}
	
	<!-- invokes /addathlete - currently in HomeController -->
	<form action="addathlete">
		Insert Athlete Info
		<br/>
		First Name <input type="text" name="fName"/>
		<br/>
		Age <input type="text" name="age"/>
		<br/>
		<input type="submit"/>
	</form>
	
	<!-- invokes /getathletebyage - currently in HomeController -->
	<form action="getathletebyage">
		Get Athlete by age
		<br/>
		Age <input type="text" name="age"/>
		<br/>
		<input type="submit"/>
	</form>
	
	<!-- invokes /getathletebyfirstname - currently in HomeController -->
	<form action="getathletebyfirstname">
		Get Athlete by first name
		<br/>
		FirstName <input type="text" name="firstN"/>
		<br/>
		<input type="submit"/>
	</form>
</body>
</html>