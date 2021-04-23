/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.persistence.Cliente;
import com.udea.persistence.Pago;
import com.udea.persistence.TarjetaCredito;
import com.udea.session.ClienteManagerLocal;
import com.udea.session.PagoManagerLocal;
import com.udea.session.TarjetaCreditoManagerLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;


/**
 *
 * @author juan-
 */
public class PagoMBean implements Serializable {
    
    @EJB
    private ClienteManagerLocal clienteManager;
    
    @EJB
    private PagoManagerLocal pagoManager;
    
    @EJB
    private TarjetaCreditoManagerLocal tarjetaCreditoManager;
    
    private Pago pago;
    private TarjetaCredito tarjetaCredito;
    private Cliente cliente;
    private List<Pago> pagos;

    /**
     * Creates a new instance of PagoMBean
     */
    public PagoMBean() {
    }
    
    public List<Pago> getPagos() {
        if ((pagos == null) || (pagos.isEmpty())) {
            refresh();
        }
        return pagos;
    }
    
    public void refresh() {
        pagos = pagoManager.getAllPagos();
    }
    
    public Pago getPago() {
        return pago;
    }

    public TarjetaCredito getTarjetaCredito() {
        return tarjetaCredito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    
    
    public String showDetails(Pago pago) {
        this.pago = pago;
        return "DETAILS";
    }
    
   
    public String pago(){
        pago = new Pago();
        tarjetaCredito = new TarjetaCredito();
        pago.setValorPago(500);
        cliente = new Cliente();
        return "PAGO";
    }
    
    public String list(){       
        return "LIST";
    }
   
    
    
    public String pagar(){
        
            if (pagoManager.idTarjetaInvalid(tarjetaCredito.getIdTarjeta())) {
                return "ERRORTARJETA";
            }
            pago= pagoManager.savePago(pago, tarjetaCredito, cliente);
            return "SAVED";
        
    }
    
    /*public String getTarjetaCredito() {      
        List<TarjetaCredito> tarjetaCreditos = tarjetaCreditoManager.getTarjetaCreditos();
        
        return ;
    }*/
    
   /* public javax.faces.model.SelectItem[] getZipCodes() {
        SelectItem[] options = null;
        List<MicroMarket> zipCodes = zipCodeManager.getZipCodes();
        if (zipCodes != null && zipCodes.size() > 0) {
            int i = 0;
            options = new SelectItem[zipCodes.size()];
            for (MicroMarket dc : zipCodes) {
                options[i++] = new SelectItem(dc.getZipCode(), dc.getZipCode());
            }
        }
        return options;
    }*/
    
}
