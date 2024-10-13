<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Listado de Plantaciones</title>
</head>
<body>
<h2>Listado de Plantaciones</h2>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Ubicación</th>
    <th>Extensión</th>
    <th>Producto</th>
    <th>Variedad</th>
    <th>Etapa Actual</th>
    <th>Fecha de Cultivo</th>
    <th>Agricultor</th>
  </tr>
  <c:forEach var="plantacion" items="${plantaciones}">
    <tr>
      <td>${plantacion.id}</td>
      <td>${plantacion.ubicacion}</td>
      <td>${plantacion.extension} ha</td>
      <td>${plantacion.producto}</td>
      <td>${plantacion.variedad}</td>
      <td>${plantacion.etapaActual}</td>
      <td>${plantacion.fechaCultivo}</td>
      <td>${plantacion.agricultor.nombres} ${plantacion.agricultor.apellidos}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
