<%@page import="com.example.Conexion" %>
<%@page import="com.example.ClienteServlet" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clientes - Software Administrativo Hotelero</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <div id="logo"></div>
        <h1>Software Administrativo Hotelero</h1>
    </header>
    <main>
        <nav>
            <ul>
                <li><a href="index.html">Recepción</a></li>
                <li><a href="habitacion.html">Habitaciones</a></li>
                <li><a href="reservas.html">Reservas</a></li>
                <li><a href="clientes.html">Clientes</a></li>
                <li><a href="informes.html">Informes</a></li>
                <li><a href="configuracion.html">Configuración</a></li>
                <li><a href="personal.html">Personal</a></li>
            </ul>
        </nav>
        <section id="contenido">
            <h2>Clientes</h2>
            <div class="filtros">
                <label for="nombreCliente">Nombre:</label>
                <input type="text" id="nombreCliente" name="nombreCliente" placeholder="Buscar por nombre">
                <button type="button" id="btnFiltrarClientes">Filtrar</button>
            </div>
        </section>
    <h2>Agregar Cliente</h2>
    <form action="clientes" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br><br>

        <label for="apellido">Apellido:</label>
        <input type="text" id="apellido" name="apellido" required><br><br>

        <label for="correo">Correo:</label>
        <input type="email" id="correo" name="correo" required><br><br>

        <label for="usuario">Usuario:</label>
        <input type="text" id="usuario" name="usuario" required><br><br>

        <label for="contrasena">Contraseña:</label>
        <input type="password" id="contrasena" name="contrasena" required><br><br>

        <input type="submit" value="Agregar Cliente">
    </form>

    <h2>Mostrar Clientes</h2>
    <form action="clientes" method="get">
        <input type="submit" value="Mostrar Clientes">
    </form>
    <footer>
        <p>&copy; 2024 Software Administrativo Hotelero</p>
    </footer>
    <script src="script.js"></script>
</body>
</html>





