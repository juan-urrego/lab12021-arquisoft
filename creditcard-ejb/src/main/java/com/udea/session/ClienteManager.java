/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.persistence.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author juan-
 */
@Stateless
public class ClienteManager implements ClienteManagerLocal {

    @PersistenceContext(unitName = "com.udea_creditcard-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
  
    
    @Override
    public Cliente getClienteById() {
        return null;
        //insertar codigo
    }

    @Override
    public void saveCliente(int idCliente, String nombreCliente, String emailCliente) {
        //insertar codigo
    }


    
}
