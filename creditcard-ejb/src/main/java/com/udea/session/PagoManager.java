/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.persistence.Pago;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author juan-
 */
@Stateless
public class PagoManager implements PagoManagerLocal {

    @PersistenceContext(unitName = "com.udea_creditcard-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    
   
    @Override
    public Pago savePago(Pago pago) {
        return em.merge(pago);
    }

    @Override
    public List<Pago> getAllPagos() {
        Query query = em.createNamedQuery("Pagos.findAll");
        return query.getResultList();
    }

    @Override
    public Pago getPagoById(int id) {
        Query query = em.createNamedQuery("Pagos.findByIdPago");
        query.setParameter("idPago", id);       
        return (Pago) query.getSingleResult();
    }
    
    
    
    
    
    
    
}
