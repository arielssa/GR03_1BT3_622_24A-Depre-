<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Listado de Agricultores</title>
</head>
<body>
<h2>Listado de Agricultores</h2>
<table border="1">
  <tr>
    <th>Cédula</th>
    <th>Nombres</th>
    <th>Apellidos</th>
    <th>Email</th>
  </tr>
  <c:forEach var="agricultor" items="${agricultores}">
    <tr>
      <td>${agricultor.cedula}</td>
      <td>${agricultor.nombres}</td>
      <td>${agricultor.apellidos}</td>
      <td>${agricultor.email}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
