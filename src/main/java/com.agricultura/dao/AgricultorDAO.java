package com.agricultura.dao;

import com.agricultura.model.Agricultor;
import com.agricultura.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AgricultorDAO {

    public void saveAgricultor(Agricultor agricultor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(agricultor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Agricultor getAgricultorByCedula(String cedula) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Agricultor.class, cedula);
        }
    }

    public List<Agricultor> listarTodosAgricultores() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Comenzamos una transacción (aunque no sea estrictamente necesario para una consulta de solo lectura)
            session.beginTransaction();

            // Realizamos la consulta para obtener todos los agricultores
            List<Agricultor> agricultores = session.createQuery("from Agricultor", Agricultor.class).getResultList();

            // Confirmamos que la transacción es correcta (esto es más relevante si estamos haciendo cambios)
            session.getTransaction().commit();

            return agricultores;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // En caso de error, se retorna una lista vacía
        }
    }


    // Otros métodos: update, delete, etc.
}
