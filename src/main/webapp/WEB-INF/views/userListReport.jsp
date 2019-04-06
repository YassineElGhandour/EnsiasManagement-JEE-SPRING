<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report</title>
</head>
<body>
 <table border="1" >
  <thead>
   <tr>
    <td>ID</td>
    <td>Salle</td>
    <td>Salle</td>
    <td>Salle</td>
   </tr>
  </thead>
  <tbody>
   <c:forEach items="${salles }" var="salle" >
    <tr>
     <td>${salle.idSalle }</td>
     <td>${salle.nomSalle }</td>
     <td>${salle.nomSalle }</td>
     <td>${salle.nomSalle }</td>
    </tr>
   </c:forEach>
  </tbody>
 </table>
 
 <spring:url value="/report/?type=xls" var="xlsURL" />
 <a href="${xlsURL }">Download Excel</a>
 
</body>
</html>