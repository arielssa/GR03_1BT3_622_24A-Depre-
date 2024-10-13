<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Registrar Insumo</title>
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
      color: #4CAF50;
      margin-top: 20px;
    }

    form {
      width: 50%;
      margin: 0 auto;
      padding: 20px;
      background-color: #f9f9f9;
      border-radius: 8px;
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Shadow effect */
    }

    form div {
      margin-bottom: 15px;
    }

    label, select, input[type="text"], input[type="number"], input[type="date"], input[type="submit"] {
      width: 100%;
      padding: 10px;
      margin: 5px 0;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }

    input[type="submit"] {
      background-color: #4CAF50;
      color: white;
      border: none;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background-color: #45a049;
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

<h2>Registrar Nuevo Insumo</h2>

<form action="registrarInsumo" method="post">
  <div>
    <label for="tipoInsumo">Tipo de Insumo:</label>
    <select id="tipoInsumo" name="tipoInsumo" required>
      <option value="Fertilizante">Fertilizante</option>
      <option value="Plaguicida">Plaguicida</option>
      <option value="Herbicida">Herbicida</option>
      <option value="Abono">Abono</option>
      <option value="Otros">Otros</option>
    </select>
  </div>

  <div>
    <label for="nombreInsumo">Nombre del Insumo:</label>
    <input type="text" id="nombreInsumo" name="nombreInsumo" required />
  </div>

  <div>
    <label for="cantidadUtilizada">Cantidad Utilizada (kg, litros, etc.):</label>
    <input type="number" id="cantidadUtilizada" step="0.01" name="cantidadUtilizada" required />
  </div>

  <div>
    <label for="fechaAplicacion">Fecha de Aplicación:</label>
    <input type="date" id="fechaAplicacion" name="fechaAplicacion" required />
  </div>

  <div>
    <label for="proveedor">Proveedor del Insumo:</label>
    <input type="text" id="proveedor" name="proveedor" required />
  </div>

  <div>
    <label for="lote">Lote o Número de Serie:</label>
    <input type="text" id="lote" name="lote" required />
  </div>

  <div>
    <label for="plantacionId">Plantación:</label>
    <select id="plantacionId" name="plantacionId" required>
      <c:forEach var="plantacion" items="${plantaciones}">
        <option value="${plantacion.id}">${plantacion.ubicacion} - ${plantacion.producto}</option>
      </c:forEach>
    </select>
  </div>

  <div>
    <input type="submit" value="Registrar Insumo" />
  </div>
</form>

<footer>
  <p>&copy; 2024 Sistema de Trazabilidad Agrícola - Todos los derechos reservados.</p>
</footer>

</body>
</html>
