<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Lista de Insumos</title>
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
      width: 90%; /* Set table width */
      margin: 20px auto; /* Center the table */
      border-collapse: collapse; /* Remove default space between table cells */
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Add shadow */
    }

    th, td {
      padding: 12px; /* Padding inside cells */
      text-align: left; /* Align text to the left */
      border: 1px solid #ddd; /* Gray border */
    }

    th {
      background-color: #4CAF50; /* Green header background */
      color: white;
    }

    tr:nth-child(even) {
      background-color: #f9f9f9; /* Light gray for even rows */
    }

    tr:hover {
      background-color: #f1f1f1; /* Light hover effect */
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

<h2>Lista de Insumos</h2>

<!-- Table to display insumos -->
<table>
  <thead>
  <tr>
    <th>Tipo de Insumo</th>
    <th>Nombre de Insumo</th>
    <th>Cantidad Utilizada</th>
    <th>Fecha de Aplicación</th>
    <th>Proveedor</th>
    <th>Lote</th>
    <th>Plantación Asociada</th>
  </tr>
  </thead>
  <tbody>
  <!-- Iterar sobre los insumos -->
  <c:forEach var="insumo" items="${insumos}">
    <tr>
      <td>${insumo.tipo}</td>
      <td>${insumo.nombre}</td>
      <td>${insumo.cantidadUtilizada}</td>
      <td>${insumo.fechaAplicacion}</td>
      <td>${insumo.proveedor}</td>
      <td>${insumo.loteONumeroSerie}</td>
      <td>${insumo.plantacion.ubicacion} - ${insumo.plantacion.producto}</td> <!-- Mostrar plantación asociada -->
    </tr>
  </c:forEach>
  </tbody>
</table>

<footer>
  <p>&copy; 2024 Sistema de Trazabilidad Agrícola - Todos los derechos reservados.</p>
</footer>

</body>
</html>
