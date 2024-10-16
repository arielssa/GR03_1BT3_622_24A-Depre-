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

        request.setAttribute("insumos", insumoDAO.listarTodosInsumos());
        request.getRequestDispatcher("/jsp/insumos/listar.jsp").forward(request, response);
    }
}
