/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.persistence.TarjetaCredito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author juan-
 */
@Local
public interface TarjetaCreditoManagerLocal {

    boolean existTarjetaById(int id);

    List<TarjetaCredito> getTarjetaCreditos();
    
}
