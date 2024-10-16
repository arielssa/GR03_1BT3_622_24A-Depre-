package com.agricultura.controller;

import com.agricultura.dao.PlantacionDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/listarPlantaciones")
public class ListarPlantacionesServlet extends HttpServlet {

    private PlantacionDAO plantacionDAO;

    @Override
    public void init() {
        plantacionDAO = new PlantacionDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // obtener la lista de plantaciones
        request.setAttribute("plantaciones", plantacionDAO.listarTodasPlantaciones());

        // jsp de listado de plantaciones
        request.getRequestDispatcher("/jsp/plantaciones/listar.jsp").forward(request, response);
    }
}


