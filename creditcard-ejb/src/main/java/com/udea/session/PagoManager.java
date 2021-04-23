/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.persistence.Cliente;
import com.udea.persistence.Pago;
import com.udea.persistence.TarjetaCredito;
import java.sql.Timestamp;
import java.util.List;
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
    
    
    public String calcularTipoTarjeta(int id){
        int b = Integer.toString(id).length();
        id = id /(int) Math.pow(10,b-5);        
        if (id >= 11111 && id <= 22222) {
            return "American Express";
        }
        if (id >= 33334 && id <= 44444) {
            return "Diners";
        }
        if (id >= 55555 && id <= 66666){
            return "Visa";
        }
        if (id >= 77777 && id <= 88888){
            return "MasterCard";
        }
        return "Error";
    }
    
    @Override
    public boolean idTarjetaInvalid(int id){
        return this.calcularTipoTarjeta(id).equals("Error");
    }
    
    public String calcularTimeStamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.toString();
    }
    
    @Override
    public Pago savePago(Pago pago, TarjetaCredito tarjetaCredito, Cliente cliente) {
        tarjetaCredito.setClientesIdCliente(cliente);
        tarjetaCredito.setTipoTarjeta(this.calcularTipoTarjeta(tarjetaCredito.getIdTarjeta()));
        pago.setTarjetasCreditosIdTarjeta(tarjetaCredito);
        pago.setTimeStampPago(this.calcularTimeStamp());
        return em.merge(pago);
    }

    @Override
    public List<Pago> getAllPagos() {
        Query query = em.createNamedQuery("Pago.findAll");
        return query.getResultList();
    }

    @Override
    public Pago getPagoById(int id) {
        Query query = em.createNamedQuery("Pago.findByIdPago");
        query.setParameter("idPago", id);       
        return (Pago) query.getSingleResult();
    }
    
    
    
    
    
    
    
}
