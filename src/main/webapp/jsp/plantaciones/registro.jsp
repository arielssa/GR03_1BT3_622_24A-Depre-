<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registro de Plantación</title>
</head>
<body>
<h2>Registrar Plantación</h2>
<form action="registrarPlantacion" method="post">
    Ubicación: <input type="text" name="ubicacion" required /><br/>
    Extensión (hectáreas): <input type="number" step="0.01" name="extension" required /><br/>
    Producto/Cultivo: <input type="text" name="producto" required /><br/>
    Variedad de Producto: <input type="text" name="variedad" /><br/>
    Etapa Actual:
    <select name="etapaActual" required>
        <option value="Preparación del terreno">Preparación del terreno</option>
        <option value="Siembra">Siembra</option>
        <option value="Crecimiento">Crecimiento</option>
        <option value="Fertilización">Fertilización</option>
        <option value="Deshierbe">Deshierbe</option>
        <option value="Cosecha">Cosecha</option>
        <option value="Post cosecha">Post cosecha</option>
    </select><br/>
    Fecha de Cultivo: <input type="date" name="fechaCultivo" required /><br/>

    <!-- Select para Agricultores -->
    Agricultor:
    <select name="agricultorCedula" required>
        <!-- Iteramos sobre la lista de agricultores -->
        <c:forEach var="agricultor" items="${agricultores}">
            <option value="${agricultor.cedula}">${agricultor.nombres} ${agricultor.apellidos}</option>
        </c:forEach>
    </select><br/>

    <input type="submit" value="Registrar" />
</form>
</body>
</html>
