<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro de Agricultor</title>
</head>
<body>
<h2>Registrar Agricultor</h2>
<form action="registrarAgricultor" method="post">
    Cédula: <input type="text" name="cedula" required /><br/>
    Nombres: <input type="text" name="nombres" required /><br/>
    Apellidos: <input type="text" name="apellidos" required /><br/>
    Email: <input type="email" name="email" required /><br/>
    Contraseña: <input type="password" name="password" required /><br/>
    <input type="submit" value="Registrar" />
</form>
</body>
</html>
