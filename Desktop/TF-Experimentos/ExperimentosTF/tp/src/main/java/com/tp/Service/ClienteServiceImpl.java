/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Service;

import com.tp.Entity.Cliente;
import com.tp.Entity.Detalle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import com.tp.Repository.IClienteRepository;

/**
 *
 * @author shiara
 */
@Named
public class ClienteServiceImpl implements IClienteService,Serializable{
     
    private static final long serialVersionUID = 1L;

    @Inject
    private List<Cliente> clientes = new ArrayList<>();


    @Override
    public void saveCliente(Cliente c) {
    	clientes.add(c);
    }

    @Override
    public void updateCliente(Cliente c) {
    	clientes.set(clientes.indexOf(c), c);
    }

    @Override
    public List<Cliente> getAll() {
    	return clientes;
    }

    @Override
    public void delete(Cliente c) {
    	clientes.remove(c);
    }
    
}
