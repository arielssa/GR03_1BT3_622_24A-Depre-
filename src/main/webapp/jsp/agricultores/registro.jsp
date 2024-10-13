<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro de Agricultor</title>
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

        form {
            max-width: 400px; /* Set maximum width for the form */
            margin: 20px auto; /* Center the form */
            padding: 20px; /* Add padding */
            border: 1px solid #ccc; /* Gray border */
            border-radius: 8px; /* Rounded corners */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Add shadow */
            background-color: #f9f9f9; /* Light gray background */
        }

        div {
            margin-bottom: 20px; /* Space between input groups */
        }

        label {
            display: block; /* Make labels block elements */
            margin-bottom: 5px; /* Space between label and input */
            color: #4CAF50; /* Green labels */
        }

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: calc(100% - 20px); /* Full width */
            padding: 10px; /* Padding inside inputs */
            border: 1px solid #ccc; /* Gray border */
            border-radius: 4px; /* Rounded corners */
            box-sizing: border-box; /* Padding does not affect width */
        }

        input[type="submit"] {
            background-color: #4CAF50; /* Green button */
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-weight: bold;
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #45a049; /* Darker green on hover */
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

<h2>Registrar Agricultor</h2>
<form action="registrarAgricultor" method="post">
    <div>
        <label for="cedula">Cédula:</label>
        <input type="text" id="cedula" name="cedula" required />
    </div>

    <div>
        <label for="nombres">Nombres:</label>
        <input type="text" id="nombres" name="nombres" required />
    </div>

    <div>
        <label for="apellidos">Apellidos:</label>
        <input type="text" id="apellidos" name="apellidos" required />
    </div>

    <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required />
    </div>

    <div>
        <label for="password">Contraseña:</label>
        <input type="password" id="password" name="password" required />
    </div>

    <div>
        <input type="submit" value="Registrar" />
    </div>
</form>

<footer>
    <p>&copy; 2024 Sistema de Trazabilidad Agrícola - Todos los derechos reservados.</p>
</footer>

</body>
</html>
