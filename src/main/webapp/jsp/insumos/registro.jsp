<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Registrar Insumo</title>
</head>
<body>
<h2>Registrar Nuevo Insumo</h2>
<form action="registrarInsumo" method="post">
  <!-- Tipo de Insumo -->
  Tipo de Insumo:
  <select name="tipoInsumo" required>
    <option value="Fertilizante">Fertilizante</option>
    <option value="Plaguicida">Plaguicida</option>
    <option value="Herbicida">Herbicida</option>
    <option value="Abono">Abono</option>
    <option value="Otros">Otros</option>
  </select><br/>

  <!-- Nombre del Insumo -->
  Nombre del Insumo: <input type="text" name="nombreInsumo" required /><br/>

  <!-- Cantidad Utilizada -->
  Cantidad Utilizada (kg, litros, etc.): <input type="number" step="0.01" name="cantidadUtilizada" required /><br/>

  <!-- Fecha de Aplicación -->
  Fecha de Aplicación: <input type="date" name="fechaAplicacion" required /><br/>

  <!-- Proveedor -->
  Proveedor del Insumo: <input type="text" name="proveedor" required /><br/>

  <!-- Lote o Número de Serie -->
  Lote o Número de Serie: <input type="text" name="lote" required /><br/>

  <!-- Selección de Plantación -->
  Plantación:
  <select name="plantacionId" required>
    <c:forEach var="plantacion" items="${plantaciones}">
      <option value="${plantacion.id}">${plantacion.ubicacion} - ${plantacion.producto}</option>
    </c:forEach>
  </select><br/>

  <input type="submit" value="Registrar Insumo" />
</form>
</body>
</html>
