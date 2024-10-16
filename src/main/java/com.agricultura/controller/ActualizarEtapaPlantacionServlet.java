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

    private void cargarPlantaciones(HttpServletRequest request) {
        List<Plantacion> plantaciones = plantacionDAO.listarTodasPlantaciones();
        request.setAttribute("plantaciones", plantaciones);
        request.setAttribute("etapasDisponibles", etapasDisponibles);
    }

    private String validarParametrosActualizacion(String plantacionIdStr, String nuevaEtapa) {
        if (plantacionIdStr == null || plantacionIdStr.isEmpty()) {
            return "ID de plantación faltante.";
        }
        if (nuevaEtapa == null || nuevaEtapa.isEmpty()) {
            return "Etapa nueva faltante.";
        }
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cargarPlantaciones(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/plantaciones/actualizarEtapa.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener parámetros del formulario
        String plantacionIdStr = request.getParameter("plantacionId");
        String nuevaEtapa = request.getParameter("nuevaEtapa");

        // Validar parámetros
        String errorMensaje = validarParametrosActualizacion(plantacionIdStr, nuevaEtapa);
        if (errorMensaje != null) {
            request.setAttribute("mensaje", errorMensaje);
            request.setAttribute("mensajeTipo", "error");
            cargarPlantaciones(request);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/plantaciones/actualizarEtapa.jsp");
            dispatcher.forward(request, response);
            return;
        }

        int plantacionId = Integer.parseInt(plantacionIdStr);
        Plantacion plantacion = plantacionDAO.getPlantacionById(plantacionId);
        if (plantacion != null) {
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

        cargarPlantaciones(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/plantaciones/actualizarEtapa.jsp");
        dispatcher.forward(request, response);
    }
}
