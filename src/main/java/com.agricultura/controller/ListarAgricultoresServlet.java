package com.agricultura.controller;

import com.agricultura.dao.AgricultorDAO;
import com.agricultura.dto.Agricultor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/listarAgricultores")
public class ListarAgricultoresServlet extends HttpServlet {

    private AgricultorDAO agricultorDAO;

    @Override
    public void init() {
        agricultorDAO = new AgricultorDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener la lista de agricultores
        // Implementa un método en AgricultorDAO para listar todos
        List<Agricultor> agricultores = agricultorDAO.listarTodosAgricultores();
        request.setAttribute("agricultores", agricultores);

        // Forward a la JSP de listado
        request.getRequestDispatcher("/jsp/agricultores/listar.jsp").forward(request, response);
    }
}
