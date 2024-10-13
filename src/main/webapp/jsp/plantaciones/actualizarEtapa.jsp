<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Actualizar Etapa de Plantaciones</title>
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
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }

        form {
            margin: 0;
        }

        select {
            padding: 5px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
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

        .message {
            width: 90%;
            margin: 20px auto;
            padding: 10px;
            border-radius: 4px;
            background-color: #e7f3fe;
            color: #31708f;
            border: 1px solid #bce8f1;
        }

        .error {
            background-color: #f2dede;
            color: #a94442;
            border: 1px solid #ebccd1;
        }
    </style>
</head>
<body>

<header>
    <h1>Bienvenido al Sistema de Trazabilidad Agrícola</h1>
    <p>Gestión de plantaciones</p>
</header>

<h2>Actualizar Etapa de Plantaciones</h2>

<!-- Mensajes de éxito o error -->
<c:if test="${not empty mensaje}">
    <div class="message ${mensajeTipo}">
            ${mensaje}
    </div>
</c:if>

<table>
    <thead>
    <tr>
        <th>Ubicación</th>
        <th>Extensión (ha)</th>
        <th>Producto/Cultivo</th>
        <th>Etapa Actual</th>
        <th>Actualizar Etapa</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="plantacion" items="${plantaciones}">
        <tr>
            <td>${plantacion.ubicacion}</td>
            <td>${plantacion.extension}</td>
            <td>${plantacion.producto}</td>
            <td>${plantacion.etapaActual}</td>
            <td>
                <form action="actualizarEtapaPlantacion" method="post">
                    <input type="hidden" name="plantacionId" value="${plantacion.id}" />
                    <select name="nuevaEtapa" required>
                        <option value="" disabled selected>--Seleccionar--</option>
                        <c:forEach var="etapa" items="${etapasDisponibles}">
                            <option value="${etapa}">${etapa}</option>
                        </c:forEach>
                    </select>
                    <br/><br/>
                    <input type="submit" value="Actualizar" />
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<footer>
    <p>&copy; 2024 Sistema de Trazabilidad Agrícola - Todos los derechos reservados.</p>
</footer>

</body>
</html>
