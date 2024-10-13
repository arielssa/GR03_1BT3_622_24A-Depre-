package com.agricultura.controller;

import com.agricultura.dao.PlantacionDAO;
import com.agricultura.model.Plantacion;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/actualizarEtapaPlantacion")
public class ActualizarEtapaPlantacionServlet extends HttpServlet {

    private PlantacionDAO plantacionDAO;
    private List<String> etapasDisponibles;

    @Override
    public void init() {
        plantacionDAO = new PlantacionDAO();
        // Definir las etapas disponibles para la actualización
        etapasDisponibles = Arrays.asList(
                "Preparación del terreno",
                "Siembra",
                "Crecimiento",
                "Fertilización",
                "Deshierbe",
                "Cosecha",
                "Post cosecha"
        );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Plantacion> plantaciones = plantacionDAO.listarTodasPlantaciones();
        request.setAttribute("plantaciones", plantaciones);
        request.setAttribute("etapasDisponibles", etapasDisponibles);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/plantaciones/actualizarEtapa.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener parámetros del formulario
        String plantacionIdStr = request.getParameter("plantacionId");
        String nuevaEtapa = request.getParameter("nuevaEtapa");

        if (plantacionIdStr != null && nuevaEtapa != null && !nuevaEtapa.isEmpty()) {
            int plantacionId = Integer.parseInt(plantacionIdStr);
            Plantacion plantacion = plantacionDAO.getPlantacionById(plantacionId);
            if (plantacion != null) {
                // Actualizar la etapa de la plantación
                plantacion.setEtapaActual(nuevaEtapa);
                boolean actualizado = plantacionDAO.updateEtapa(plantacion);
                if (actualizado) {
                    request.setAttribute("mensaje", "Etapa actualizada exitosamente para la plantación ID: " + plantacionId);
                    request.setAttribute("mensajeTipo", "success");
                } else {
                    request.setAttribute("mensaje", "Error al actualizar la etapa para la plantación ID: " + plantacionId);
                    request.setAttribute("mensajeTipo", "error");
                }
            } else {
                request.setAttribute("mensaje", "Plantación no encontrada con ID: " + plantacionId);
                request.setAttribute("mensajeTipo", "error");
            }
        } else {
            request.setAttribute("mensaje", "Datos incompletos para la actualización.");
            request.setAttribute("mensajeTipo", "error");
        }

        // Volver a listar las plantaciones con el mensaje
        List<Plantacion> plantaciones = plantacionDAO.listarTodasPlantaciones();
        request.setAttribute("plantaciones", plantaciones);
        request.setAttribute("etapasDisponibles", etapasDisponibles);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/plantaciones/actualizarEtapa.jsp");
        dispatcher.forward(request, response);
    }
}
