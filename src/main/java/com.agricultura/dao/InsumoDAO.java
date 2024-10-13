package com.agricultura.dao;

import com.agricultura.dto.Agricultor;
import com.agricultura.dto.Insumo;
import com.agricultura.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class InsumoDAO {

    public void saveInsumo(Insumo insumo) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(insumo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Insumo> listarTodosInsumos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Comenzamos una transacción (aunque no sea estrictamente necesario para una consulta de solo lectura)
            session.beginTransaction();

            // Realizamos la consulta para obtener todos los agricultores
            List<Insumo> insumos = session.createQuery("from Insumo", Insumo.class).getResultList();

            // Confirmamos que la transacción es correcta (esto es más relevante si estamos haciendo cambios)
            session.getTransaction().commit();

            return insumos;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // En caso de error, se retorna una lista vacía
        }
    }

    // Otros métodos: get, update, delete, etc.
}
