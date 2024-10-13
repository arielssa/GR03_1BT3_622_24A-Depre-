<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registro de Plantación</title>
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

        form {
            width: 60%;
            margin: 20px auto;
            padding: 20px;
            border-radius: 8px;
            background-color: #f9f9f9;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        label, input, select {
            display: block;
            width: 100%;
            margin-bottom: 15px;
        }

        input[type="text"], input[type="number"], input[type="date"], select {
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 98%;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
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

<h2>Registrar Plantación</h2>

<form action="registrarPlantacion" method="post">
    <label for="ubicacion">Ubicación:</label>
    <input type="text" id="ubicacion" name="ubicacion" required />

    <label for="extension">Extensión (hectáreas):</label>
    <input type="number" id="extension" step="0.01" name="extension" required />

    <label for="producto">Producto/Cultivo:</label>
    <input type="text" id="producto" name="producto" required />

    <label for="variedad">Variedad de Producto:</label>
    <input type="text" id="variedad" name="variedad" />

    <label for="etapaActual">Etapa Actual:</label>
    <select id="etapaActual" name="etapaActual" required>
        <option value="Preparación del terreno">Preparación del terreno</option>
        <option value="Siembra">Siembra</option>
        <option value="Crecimiento">Crecimiento</option>
        <option value="Fertilización">Fertilización</option>
        <option value="Deshierbe">Deshierbe</option>
        <option value="Cosecha">Cosecha</option>
        <option value="Post cosecha">Post cosecha</option>
    </select>

    <label for="fechaCultivo">Fecha de Cultivo:</label>
    <input type="date" id="fechaCultivo" name="fechaCultivo" required />

    <label for="agricultorCedula">Agricultor:</label>
    <select id="agricultorCedula" name="agricultorCedula" required>
        <c:forEach var="agricultor" items="${agricultores}">
            <option value="${agricultor.cedula}">${agricultor.nombres} ${agricultor.apellidos}</option>
        </c:forEach>
    </select>

    <input type="submit" value="Registrar" />
</form>

<footer>
    <p>&copy; 2024 Sistema de Trazabilidad Agrícola - Todos los derechos reservados.</p>
</footer>

</body>
</html>
