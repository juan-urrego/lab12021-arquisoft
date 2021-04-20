/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.persistence.Cliente;
import javax.ejb.Local;

/**
 *
 * @author juan-
 */
@Local
public interface ClienteManagerLocal {

    Cliente getClienteById();

    void saveCliente(int idCliente, String nombreCliente, String emailCliente);

    boolean existClientById(int id);
    
    
}
