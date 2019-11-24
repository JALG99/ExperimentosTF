/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tp.Service;

import com.tp.Entity.Detalle;
import com.tp.Entity.Promocion;
import com.tp.Repository.IPromocionRepository;
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
public class PromocionServiceImpl implements IPromocionService ,Serializable{

    private static final long serialVersionUID = 1L;

    @Inject
    private List<Promocion> promociones = new ArrayList<>();

    @Override
    public void save(Promocion prm) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	promociones.add(prm);
    }

    @Override
    public void update(Promocion prm) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	promociones.set(promociones.indexOf(prm), prm);
    }

    @Override
    public List<Promocion> findAll() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	return promociones;
    }

    @Override
    public void delete(Promocion prm) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	promociones.remove(prm);
    }


}
   

