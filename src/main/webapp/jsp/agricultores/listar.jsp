<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Listado de Agricultores</title>
  <style>
    /* Global Styles */
    body {
      background-color: white;
      font-family: 'Arial', sans-serif;
      color: #333;
      margin: 0;
      padding: 0;
    }

    header {
      background-color: #4CAF50; /* Green background */
      color: white;
      padding: 20px;
      text-align: center;
    }

    h2 {
      text-align: center;
      color: #4CAF50; /* Green heading */
      margin-top: 20px;
    }

    table {
      width: 80%; /* Set table width */
      margin: 20px auto; /* Center the table */
      border-collapse: collapse;
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Add some shadow for depth */
    }

    th, td {
      padding: 12px 15px;
      text-align: left;
      border: 1px solid #ddd; /* Border around cells */
    }

    th {
      background-color: #4CAF50; /* Green background for table headers */
      color: white;
    }

    tr:nth-child(even) {
      background-color: #f2f2f2; /* Light gray background for even rows */
    }

    tr:hover {
      background-color: #ddd; /* Light gray on hover */
    }

    footer {
      background-color: #333;
      color: white;
      text-align: center;
      padding: 10px;
      position: relative;
      bottom: 0;
      width: 100%;
    }
  </style>
</head>
<body>

<header>
  <h1>Bienvenido al Sistema de Trazabilidad Agrícola</h1>
  <p>Gestión de plantaciones</p>
</header>

<h2>Listado de Agricultores</h2>
<table>
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

<footer>
  <p>&copy; 2024 Sistema de Trazabilidad Agrícola - Todos los derechos reservados.</p>
</footer>

</body>
</html>
