
package com.idao;

import com.Modelos.Persona;
import java.sql.SQLException;
import java.util.List;

public interface IPersonaDao {

    public List<Persona> obtenerClientes();

    public Persona obtenerCliente(int id);
    
    public Boolean insertarCliente(Persona persona);

    public Boolean actualizarCliente(Persona persona);

    public Boolean eliminarCliente(Persona persona);    
}
