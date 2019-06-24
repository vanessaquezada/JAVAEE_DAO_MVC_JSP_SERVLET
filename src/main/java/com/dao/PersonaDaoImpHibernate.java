/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.Data.HibernateUtil;
import com.Modelos.Persona;
import com.Modelos.Personas;
import com.idao.IPersonaDao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;

/**
 *
 * @author FIGTE
 */
public class PersonaDaoImpHibernate implements IPersonaDao {

    Session session;
    SessionFactory sessionFactory;

    public PersonaDaoImpHibernate() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Personas> obtenerClientes() {
        List<Personas> lista = new ArrayList<Personas>();
        session = sessionFactory.openSession();
        try {

            // Getting Transaction Object From Session Object
            session.beginTransaction();

            lista = session.createNamedQuery("Personas.findAll").list();
        } catch (Exception sqlException) {
            if (null != session.getTransaction()) {
                //  logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            return lista;
        }

    }

    @Override
    public Personas obtenerCliente(int id) {
        Personas p = null;
        session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            p = session.get(Personas.class, id);
            session.getTransaction().commit();
            session.close();
            return p;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.clear();
            session.close();
            return null;

        }
    }

    @Override
    public Boolean insertarCliente(Personas persona) {

        session = sessionFactory.openSession();

        session.beginTransaction();

        try {
            Personas p = new Personas();
            p.setNombre(persona.getNombre());
            p.setApellidos(persona.getApellidos());
            p.setEdad(persona.getEdad());
            p.setDireccion(persona.getDireccion());

            session.save(p);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.clear();
            session.close();
            return false;

        }
    }

    @Override
    public Boolean actualizarCliente(Personas persona) {
        session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.update(persona);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.clear();
            session.close();
            return false;

        }
    }

    @Override
    public Boolean eliminarCliente(Personas persona) {

        session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.remove(persona);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.clear();
            session.close();
            return false;

        }
    }

}
