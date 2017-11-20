<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>O2 Semantic Search</title>
		<link rel="stylesheet" type="text/css" href="style/mainPage.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	</head>
	<body>
		
		<p> O<sub>2<sub> </p>
		<form id="content" action="search.jsp" method="GET">
		  <input type="text" name="query" class="input">
		  <button type="reset" class="search" onclick="expand()"></button>
		</form>
			<button id="submit" type="submit" form="content" value="Submit" >Go</button>
		
		<a href="upload.html" id="upload">Upload Docs</a>
		
		<script src="scripts/mainPage.js"></script>
		<!--  
		<form id="content" action="${pageContext.request.contextPath}/search" method="GET">
			<input name="query" type="text" placeholder="" class="input"/>
			<button type="reset" id="reset" class="search"></button>
		</form>
		
		<hr>
		<form action="${pageContext.request.contextPath}/save" method="POST">
			<input type="text" name="docName" placeholder="Document name"/>
			<input type="text" name="content" placeholder="Content"/>
			<input type="text" name="authorName" placeholder="Author name"/>
			<input type="submit" value="Upload Doc"/>
		</form>
		-->
	</body>
</html>
