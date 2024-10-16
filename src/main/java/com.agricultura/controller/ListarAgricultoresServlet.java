package com.agricultura.controller;

import com.agricultura.dao.AgricultorDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/listarAgricultores")
public class ListarAgricultoresServlet extends HttpServlet {

    private AgricultorDAO agricultorDAO;

    @Override
    public void init() {
        agricultorDAO = new AgricultorDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("agricultores", agricultorDAO.listarTodosAgricultores());
        request.getRequestDispatcher("/jsp/agricultores/listar.jsp").forward(request, response);

    }
}
