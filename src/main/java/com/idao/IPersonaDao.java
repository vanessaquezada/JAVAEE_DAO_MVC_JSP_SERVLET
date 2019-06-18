
package com.idao;

import com.Modelos.Persona;
import com.Modelos.Personas;
import java.sql.SQLException;
import java.util.List;

public interface IPersonaDao {

    public List<Personas> obtenerClientes();

    public Personas obtenerCliente(int id);
    
    public Boolean insertarCliente(Personas persona);

    public Boolean actualizarCliente(Personas persona);

    public Boolean eliminarCliente(Personas persona);    
}
