<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EventDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Event Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Event</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<%@include file="../functions/navbar.jsp" %>
<br>
<div class="main">

<%EventDTO e = (EventDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value=<%=e.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="description">Description</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="description" name="description" value=<%=e.getDescription()%>> 
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label for="type">Category</label>
    </div>
    <div class="col-75">
      <input type="text" id="category" name="category" value=<%=e.getCategory()%>>
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label for="st">StartDate</label>
    </div>
    <div class="col-75">
      <input type="text" id="startDate" name="startDate" value=<%=e.getStartDate()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="sd">EndDate</label>
    </div>
    <div class="col-75">
      <input type="text" id="endDate" name="endDate" value=<%=e.getEndDate()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="arg">Arguments</label>
    </div>
    <div class="col-75">
      <input type="text" id="arguments" name="arguments" value=<%=e.getArguments()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="arg">UserId</label>
    </div>
    <div class="col-75">
      <input type="text" id="userid" name="userid" value=<%=e.getId()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="arg">AgentName</label>
    </div>
    <div class="col-75">
      <input type="text" id="agentName" name="agentName" value=<%=e.getAgentName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="arg">AgentSurname</label>
    </div>
    <div class="col-75">
      <input type="text" id="agentSurname" name="agentSurname" value=<%=e.getAgentSurname()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="arg">Company</label>
    </div>
    <div class="col-75">
      <input type="text" id="company" name="company" value=<%=e.getCompany()%>>
    </div>
  </div>
  
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	

</body>
</html>