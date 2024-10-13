package com.agricultura.controller;

import com.agricultura.dao.InsumoDAO;
import com.agricultura.dao.PlantacionDAO;
import com.agricultura.model.Insumo;
import com.agricultura.model.Plantacion;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/registrarInsumo")
public class RegistroInsumoServlet extends HttpServlet {

    private InsumoDAO insumoDAO;
    private PlantacionDAO plantacionDAO;

    @Override
    public void init() {
        // Inicializar los DAOs
        insumoDAO = new InsumoDAO();
        plantacionDAO = new PlantacionDAO();
    }

    // Mostrar el formulario de registro de insumo (GET)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener la lista de plantaciones para el formulario
        List<Plantacion> plantaciones = plantacionDAO.listarTodasPlantaciones();
        request.setAttribute("plantaciones", plantaciones);

        // Formulario de registro
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/insumos/registro.jsp");
        dispatcher.forward(request, response);
    }

    // Procesar el formulario de registro de insumo (POST)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros del formulario
        String tipoInsumo = request.getParameter("tipoInsumo");
        String nombreInsumo = request.getParameter("nombreInsumo");
        double cantidadUtilizada = Double.parseDouble(request.getParameter("cantidadUtilizada"));
        String fechaAplicacionStr = request.getParameter("fechaAplicacion");
        String proveedor = request.getParameter("proveedor");
        String lote = request.getParameter("lote");
        int plantacionId = Integer.parseInt(request.getParameter("plantacionId"));  // Obtener el ID de la plantación

        // Parsear la fecha de aplicación
        java.util.Date fechaAplicacion = null;
        try {
            fechaAplicacion = new SimpleDateFormat("yyyy-MM-dd").parse(fechaAplicacionStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Obtener la plantación asociada
        Plantacion plantacion = plantacionDAO.getPlantacionById(plantacionId);

        // Crear el objeto Insumo con los datos del formulario
        Insumo insumo = new Insumo();
        insumo.setTipo(tipoInsumo);
        insumo.setNombre(nombreInsumo);
        insumo.setCantidadUtilizada(cantidadUtilizada);
        insumo.setFechaAplicacion(fechaAplicacion);
        insumo.setProveedor(proveedor);
        insumo.setLoteONumeroSerie(lote);
        insumo.setPlantacion(plantacion);  // Asociar el insumo con la plantación

        // Guardar el insumo en la base de datos utilizando el DAO
        insumoDAO.saveInsumo(insumo);

        // Redirigir a la lista de insumos
        response.sendRedirect("listarInsumos");
    }
}
