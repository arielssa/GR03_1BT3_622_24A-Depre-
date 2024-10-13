package com.agricultura.controller;

import com.agricultura.dao.PlantacionDAO;
import com.agricultura.model.Plantacion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/listarPlantaciones")
public class ListarPlantacionesServlet extends HttpServlet {

    private PlantacionDAO plantacionDAO;

    @Override
    public void init() {
        plantacionDAO = new PlantacionDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener la lista de agricultores
        // Implementa un método en AgricultorDAO para listar todos
        List<Plantacion> plantaciones = plantacionDAO.listarTodasPlantaciones();
        request.setAttribute("plantaciones", plantaciones);

        // Forward a la JSP de listado
        request.getRequestDispatcher("/jsp/plantaciones/listar.jsp").forward(request, response);
    }
}
