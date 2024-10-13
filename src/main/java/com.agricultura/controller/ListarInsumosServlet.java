package com.agricultura.controller;

import com.agricultura.dao.InsumoDAO;
import com.agricultura.model.Insumo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/listarInsumos")
public class ListarInsumosServlet extends HttpServlet {

    private InsumoDAO insumoDAO;

    @Override
    public void init() {
        insumoDAO = new InsumoDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener la lista de agricultores
        // Implementa un método en AgricultorDAO para listar todos
        List<Insumo> insumos = insumoDAO.listarTodosInsumos();
        request.setAttribute("insumos", insumos);

        // Forward a la JSP de listado
        request.getRequestDispatcher("/jsp/insumos/listar.jsp").forward(request, response);
    }
}
