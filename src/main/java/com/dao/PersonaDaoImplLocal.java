
package com.dao;

import com.Data.Data;
import com.Modelos.Persona;
import com.Modelos.Personas;
import com.idao.IPersonaDao;
import java.util.ArrayList;
import java.util.List;

public class PersonaDaoImplLocal implements IPersonaDao{    
    
    public PersonaDaoImplLocal() {
       Personas p1=new Personas();
       p1.setNombre("Juan");
       p1.setApellidos("Perez");
       p1.setEdad(19);
       p1.setDireccion("Ataco");
       Data.data.add(p1);
    }

    
    @Override
    public List<Personas> obtenerClientes() {
        return Data.data;
    }

    @Override
    public Personas obtenerCliente(int id) {
       return Data.data.get(id);
    }

    @Override
    public Boolean actualizarCliente(Personas p) {
        Data.data.get(p.getId()).setNombre(p.getNombre());
	Data.data.get(p.getId()).setApellidos(p.getApellidos());
        Data.data.get(p.getId()).setEdad(p.getEdad());
        Data.data.get(p.getId()).setDireccion(p.getDireccion());
	System.out.println("Persona con id: "+p.getId()+" actualizado satisfactoriamente");
        return true;
    }

    @Override
    public Boolean eliminarCliente(Personas p) {
        Data.data.remove(p.getId());
	System.out.println("Persona con id: "+p.getId()+" elimnado satisfactoriamente");
        return true;
    }

    @Override
    public Boolean insertarCliente(Personas persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
