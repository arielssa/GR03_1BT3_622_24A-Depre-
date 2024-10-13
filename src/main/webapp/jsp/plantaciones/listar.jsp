<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Listado de Plantaciones</title>
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
      background-color: #4CAF50;
      color: white;
      padding: 20px;
      text-align: center;
    }

    h2 {
      text-align: center;
      color: #4CAF50;
      margin-top: 20px;
    }

    table {
      width: 80%;
      margin: 20px auto;
      border-collapse: collapse;
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
      background-color: #f9f9f9;
    }

    th, td {
      padding: 12px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }

    th {
      background-color: #4CAF50;
      color: white;
    }

    tr:hover {
      background-color: #f1f1f1;
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

<h2>Listado de Plantaciones</h2>

<table>
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

<footer>
  <p>&copy; 2024 Sistema de Trazabilidad Agrícola - Todos los derechos reservados.</p>
</footer>

</body>
</html>
