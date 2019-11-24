/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Service;

import com.tp.Entity.Cargo;
import com.tp.Entity.Cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import com.tp.Repository.ICargoRepository;

/**
 *
 * @author shiara
 */
@Named
public class CargoServiceImpl implements ICargoService,Serializable{
     
    private static final long serialVersionUID = 1L;

    @Inject
    private List<Cargo> cargos = new ArrayList<>();


    @Override
    public void save(Cargo c) {
    	cargos.add(c);
    }

    @Override
    public void update(Cargo c) {
    	cargos.set(cargos.indexOf(c), c);
    }

    @Override
    public List<Cargo> findAll() {
    	return cargos;
    }

    @Override
    public void delete(Cargo c) {
    	cargos.remove(c);
    }
    
}
