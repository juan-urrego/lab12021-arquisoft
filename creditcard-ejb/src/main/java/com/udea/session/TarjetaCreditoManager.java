/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author juan-
 */
@Stateless
public class TarjetaCreditoManager implements TarjetaCreditoManagerLocal {

    @PersistenceContext(unitName = "com.udea_creditcard-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public boolean existTarjetaById(int id) {
        Query query = em.createNamedQuery("TarjetaCredito.findById");
        query.setParameter("idTarjeta", id);       
        return !query.getResultList().isEmpty();
    }
    
    
}
