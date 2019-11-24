/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Service;

import com.tp.Entity.Detalle;
import com.tp.Entity.Producto;
import com.tp.Repository.IDetalleRepository;
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
public class DetalleServiceImpl implements IDetalleService ,Serializable{

    private static final long serialVersionUID = 1L;

    @Inject
    private List<Detalle> detalles = new ArrayList<>();

    @Override
    public void save(Detalle ord) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	detalles.add(ord);
    }

    @Override
    public void update(Detalle ord) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	detalles.set(detalles.indexOf(ord), ord);
    }

    @Override
    public List<Detalle> findAll() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	return detalles;
    }

    @Override
    public void delete(Detalle ord) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	detalles.remove(ord);
    }


}
   