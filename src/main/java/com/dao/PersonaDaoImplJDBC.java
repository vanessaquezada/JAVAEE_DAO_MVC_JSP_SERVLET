/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.Data.Conexion;
import com.Modelos.Persona;
import com.idao.IPersonaDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FIGTE
 */
public class PersonaDaoImplJDBC implements IPersonaDao {

    private Conexion con;
    private Connection connection;

    public PersonaDaoImplJDBC() {
        con = new Conexion();
    }

    @Override
    public List<Persona> obtenerClientes() {
        List<Persona> lista = new ArrayList<Persona>();
        String sql = "SELECT * FROM personas";

        try {
            con.conectar();

            connection = con.getJdbcConnection();
            Statement statement = connection.createStatement();
            ResultSet resulSet = statement.executeQuery(sql);

            while (resulSet.next()) {
                int id = resulSet.getInt("id");
                String nombre = resulSet.getString("nombre");
                String apellidos = resulSet.getString("apellidoS");
                Integer edad = resulSet.getInt("edad");
                String direccion = resulSet.getString("direccion");
                Persona p = new Persona(id, nombre, apellidos, edad, direccion);
                lista.add(p);
            }
            con.desconectar();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDaoImplJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Problemas con la BD");
            return null;
        }
    }

    @Override
    public Persona obtenerCliente(int id) {
        Persona p = null;
        String sql = "SELECT * FROM personas WHERE id= ? ";
        try {
            con.conectar();

            connection = con.getJdbcConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet res = statement.executeQuery();
            if (res.next()) {
                p = new Persona(res.getInt("id"), res.getString("nombre"), res.getString("apellidos"),
                        res.getInt("edad"), res.getString("direccion"));
            }
            res.close();
            con.desconectar();

            return p;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDaoImplJDBC.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Boolean actualizarCliente(Persona persona) {
        boolean rowActualizar = false;
        String sql = "UPDATE personas SET nombre=?,apellidos=?,edad=?, direccion=? WHERE id=?";
        try {
            con.conectar();

            connection = con.getJdbcConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
          statement.setInt(5, persona.getId());
            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getApellidos());
            statement.setInt(3, persona.getEdad());
            statement.setString(4, persona.getDireccion());

            rowActualizar = statement.executeUpdate() > 0;
            statement.close();
            con.desconectar();
            return rowActualizar;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDaoImplJDBC.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Boolean eliminarCliente(Persona persona) {
        boolean rowEliminar = false;
		String sql = "DELETE FROM personas WHERE ID=?";
        try {
            con.conectar();
       
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, persona.getId());
 
		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
 
		return rowEliminar;
         } catch (SQLException ex) {
            Logger.getLogger(PersonaDaoImplJDBC.class.getName()).log(Level.SEVERE, null, ex);
            return false;
         }        
    }

    @Override
    public Boolean insertarCliente(Persona persona) {
        String sql = "INSERT INTO personas(nombre,apellidos,edad,direccion) VALUES ( ?,?,?,?)";
        System.out.println(persona.getNombre());
        PreparedStatement statement;
        try {
            con.conectar();
            connection = con.getJdbcConnection();
            statement = connection.prepareStatement(sql);

           // statement.setInt(1, persona.getId());
            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getApellidos());
            statement.setInt(3, persona.getEdad());
            statement.setString(4, persona.getDireccion());

            boolean rowInserted = statement.executeUpdate() > 0;
            statement.close();
            con.desconectar();
            System.out.println("Guardado");    
            return rowInserted;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDaoImplJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No Guardado");   
            return false;
        }
    }

}
