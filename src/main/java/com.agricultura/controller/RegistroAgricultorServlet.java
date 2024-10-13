package com.agricultura.controller;

import com.agricultura.dao.AgricultorDAO;
import com.agricultura.model.Agricultor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/registrarAgricultor")
public class RegistroAgricultorServlet extends HttpServlet {

    private AgricultorDAO agricultorDAO;

    @Override
    public void init() {
        agricultorDAO = new AgricultorDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirigir al formulario de registro
        request.getRequestDispatcher("/jsp/agricultores/registro.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener parámetros del formulario
        String cedula = request.getParameter("cedula");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Crear objeto Agricultor
        Agricultor agricultor = new Agricultor();
        agricultor.setCedula(cedula);
        agricultor.setNombres(nombres);
        agricultor.setApellidos(apellidos);
        agricultor.setEmail(email);
        agricultor.setPassword(password); // Considera encriptar la contraseña

        // Guardar en la base de datos
        agricultorDAO.saveAgricultor(agricultor);

        // Redirigir a una página de éxito o listado
        response.sendRedirect("listarAgricultores");
    }
}
