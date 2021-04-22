/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juan-
 */
@Entity
@Table(name = "pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p")
    , @NamedQuery(name = "Pago.findByIdPago", query = "SELECT p FROM Pago p WHERE p.idPago = :idPago")
    , @NamedQuery(name = "Pago.findByValorPago", query = "SELECT p FROM Pago p WHERE p.valorPago = :valorPago")
    , @NamedQuery(name = "Pago.findByTimeStampPago", query = "SELECT p FROM Pago p WHERE p.timeStampPago = :timeStampPago")})
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago")
    private Integer idPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_pago")
    private int valorPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "time_stamp_pago")
    private String timeStampPago;
    @JoinColumn(name = "tarjetas_creditos_id_tarjeta", referencedColumnName = "id_tarjeta")
    @ManyToOne(optional = false)
    private TarjetaCredito tarjetasCreditosIdTarjeta;

    public Pago() {
    }

    public Pago(Integer idPago) {
        this.idPago = idPago;
    }

    public Pago(Integer idPago, int valorPago, String timeStampPago) {
        this.idPago = idPago;
        this.valorPago = valorPago;
        this.timeStampPago = timeStampPago;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public int getValorPago() {
        return valorPago;
    }

    public void setValorPago(int valorPago) {
        this.valorPago = valorPago;
    }

    public String getTimeStampPago() {
        return timeStampPago;
    }

    public void setTimeStampPago(String timeStampPago) {
        this.timeStampPago = timeStampPago;
    }

    public TarjetaCredito getTarjetasCreditosIdTarjeta() {
        return tarjetasCreditosIdTarjeta;
    }

    public void setTarjetasCreditosIdTarjeta(TarjetaCredito tarjetasCreditosIdTarjeta) {
        this.tarjetasCreditosIdTarjeta = tarjetasCreditosIdTarjeta;
    }
    
    public int getIdTarjetaCredito(){
        return this.getTarjetasCreditosIdTarjeta().getIdTarjeta();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.persistence.Pago[ idPago=" + idPago + " ]";
    }
    
}
