/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.persistence.Cliente;
import com.udea.persistence.Pago;
import com.udea.persistence.TarjetaCredito;
import java.util.List;
import java.util.Set;
import javax.ejb.Local;

/**
 *
 * @author juan-
 */
@Local
public interface PagoManagerLocal {

    Pago savePago(Pago pago, TarjetaCredito tarjetaCredito, Cliente cliente);

    List<Pago> getAllPagos();

    Pago getPagoById(int id);
    
    boolean idTarjetaInvalid(int id);
    
}
