<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/searchPage.css">
<title>O2 : Search Page</title>
</head>
<body id="block">

	<%@ page import="esearch.SearchClient,parse.JSONClient,org.json.simple.JSONObject,org.json.simple.JSONArray,java.util.Iterator" %>
	<%
		String query = request.getParameter("query");
		String output = SearchClient.searchDoc(query);
		
		if (output.length() == 0)
			response.sendRedirect("index.jsp");
		else {			
			JSONObject json = JSONClient.strToJSON(output);
			JSONObject hits = (JSONObject) json.get ("hits");
			JSONArray docs = (JSONArray) hits.get ("hits");
			
			JSONObject doc = null;

	%>

  <div class="card_container">
	<div class="wrapper">
		<form action="search.jsp" method="GET">
			<div class="field">    
			  <input type="text" name="query" class="txt_field" >
			  <button type="submit" class="search_btn">Search</button>
	  		</div>	  
		</form>	

		<%
			for(int i=0; i < docs.size(); i++){
				doc = (JSONObject) docs.get (i);
				String docName = (String) doc.get ("_id");
				doc = (JSONObject) doc.get ("_source");
		%>
	  	<div class="card">
	    	<div class="result" id="one">	
	    	<div class="info">
	        	<span class="title"><% out.println(docName);%></span>
		       <span class="address"><% out.println((String) doc.get("authorName")); %></span>
		       <span class="eta"><% out.println((String) doc.get("content")); %></span>
	      	</div>
	      	<div class="fab"></div>
	    	</div>
	  	</div>
 		<%}} %>
    </div>
  </div>
 
</body>
</html>
