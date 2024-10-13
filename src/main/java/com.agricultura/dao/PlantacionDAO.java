package com.agricultura.dao;

import com.agricultura.model.Plantacion;
import com.agricultura.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PlantacionDAO {

    public void savePlantacion(Plantacion plantacion) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(plantacion);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Plantacion getPlantacionById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Plantacion.class, id);
        }
    }

    public void updateEtapa(Plantacion plantacion) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(plantacion);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Plantacion> listarTodasPlantaciones() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Comenzamos una transacción (aunque no sea estrictamente necesario para una consulta de solo lectura)
            session.beginTransaction();

            // Realizamos la consulta para obtener todos los agricultores
            List<Plantacion> plantaciones = session.createQuery("from Plantacion ", Plantacion.class).getResultList();

            // Confirmamos que la transacción es correcta (esto es más relevante si estamos haciendo cambios)
            session.getTransaction().commit();

            return plantaciones;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // En caso de error, se retorna una lista vacía
        }
    }

}
