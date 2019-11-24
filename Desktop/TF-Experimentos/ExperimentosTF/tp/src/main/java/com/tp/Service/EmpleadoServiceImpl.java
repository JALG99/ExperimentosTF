/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Service;

import com.tp.Entity.Cliente;
import com.tp.Entity.Empleado;
import com.tp.Repository.IEmpleadoRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author shiara
 */
@Named
public class EmpleadoServiceImpl implements IEmpleadoService,Serializable{

    private static final long serialVersionUID = 1L;

    @Inject
    private List<Empleado> empleados = new ArrayList<>();

   
    @Override
    public void saveEmpleado(Empleado emp) {
    	empleados.add(emp);
    }


    @Override
    public List<Empleado> getAll() {
    	return empleados;
    }

    @Override
    public void delete(Empleado emp) {
    	empleados.remove(emp);
    }

    @Override
    public void updateEmpleado(Empleado emp) {
    	empleados.set(empleados.indexOf(emp), emp);
    }

  
    
}
