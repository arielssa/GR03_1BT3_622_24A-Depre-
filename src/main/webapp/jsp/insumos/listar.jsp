<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Lista de Insumos</title>
</head>
<body>
<h2>Lista de Insumos</h2>

<!-- Tabla para mostrar los insumos -->
<table border="1">
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

</body>
</html>
