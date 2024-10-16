package com.agricultura.controller;

import com.agricultura.dao.AgricultorDAO;
import com.agricultura.dao.PlantacionDAO;
import com.agricultura.model.Agricultor;
import com.agricultura.model.Plantacion;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/registrarPlantacion")
public class RegistroPlantacionServlet extends HttpServlet {

    private PlantacionDAO plantacionDAO;
    private AgricultorDAO agricultorDAO;

    @Override
    public void init() {
        plantacionDAO = new PlantacionDAO();
        agricultorDAO = new AgricultorDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Agricultor> agricultores = agricultorDAO.listarTodosAgricultores();

        request.setAttribute("agricultores", agricultores);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/plantaciones/registro.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros del formulario encapsulados en el nuevo método
        Plantacion plantacion = obtenerParametrosDelFormulario(request);

        // Guardar en la base de datos
        plantacionDAO.savePlantacion(plantacion);

        // Redirigir a una página de éxito o listado
        response.sendRedirect("listarPlantaciones");
    }

    private Plantacion obtenerParametrosDelFormulario(HttpServletRequest request) {
        // Obtener parámetros del formulario
        String ubicacion = request.getParameter("ubicacion");
        double extension = Double.parseDouble(request.getParameter("extension"));
        String producto = request.getParameter("producto");
        String variedad = request.getParameter("variedad");
        String etapaActual = request.getParameter("etapaActual");
        String fechaCultivoStr = request.getParameter("fechaCultivo");
        String agricultorCedula = request.getParameter("agricultorCedula");

        // Parsear la fecha
        Date fechaCultivo = null;
        try {
            fechaCultivo = new SimpleDateFormat("yyyy-MM-dd").parse(fechaCultivoStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Obtener el agricultor
        Agricultor agricultor = agricultorDAO.getAgricultorByCedula(agricultorCedula);

        // Crear objeto Plantacion
        Plantacion plantacion = new Plantacion();
        plantacion.setUbicacion(ubicacion);
        plantacion.setExtension(extension);
        plantacion.setProducto(producto);
        plantacion.setVariedad(variedad);
        plantacion.setEtapaActual(etapaActual);
        plantacion.setFechaCultivo(fechaCultivo);
        plantacion.setAgricultor(agricultor);

        return plantacion;
    }
}
