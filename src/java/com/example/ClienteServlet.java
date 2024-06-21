
package com.example;

import com.example.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/clientes")
public class ClienteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String correo = request.getParameter("correo");
            String usuario = request.getParameter("usuario");
            String contrasena = request.getParameter("contrasena");

            Connection connection = Conexion.getConnection();
            if (connection != null) {
                String sql = "INSERT INTO clientes (Nombre, Apellido, Correo, Usuario, Contrasena) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, nombre);
                statement.setString(2, apellido);
                statement.setString(3, correo);
                statement.setString(4, usuario);
                statement.setString(5, contrasena);
                statement.executeUpdate();

                out.println("<h2>Cliente agregado exitosamente!</h2>");
                connection.close();
            } else {
                out.println("<h2>Error en la conexión!</h2>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Connection connection = Conexion.getConnection();
            if (connection != null) {
                String sql = "SELECT * FROM clientes";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();

                out.println("<html><head><title>Clientes</title></head><body>");
                out.println("<h2>Lista de Clientes</h2>");
                out.println("<table border='1'><tr><th>ID</th><th>Nombre</th><th>Apellido</th><th>Correo</th><th>Usuario</th><th>Contraseña</th></tr>");
                while (resultSet.next()) {
                    out.println("<tr>");
                    out.println("<td>" + resultSet.getInt("IdCliente") + "</td>");
                    out.println("<td>" + resultSet.getString("Nombre") + "</td>");
                    out.println("<td>" + resultSet.getString("Apellido") + "</td>");
                    out.println("<td>" + resultSet.getString("Correo") + "</td>");
                    out.println("<td>" + resultSet.getString("Usuario") + "</td>");
                    out.println("<td>" + resultSet.getString("Contrasena") + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("</body></html>");
                connection.close();
            } else {
                out.println("<h2>Error en la conexión!</h2>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}