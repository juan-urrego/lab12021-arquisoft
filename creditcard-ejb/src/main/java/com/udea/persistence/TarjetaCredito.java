/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.persistence;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juan-
 */
@Entity
@Table(name = "tarjetas_creditos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarjetasCreditos.findAll", query = "SELECT t FROM TarjetasCreditos t")
    , @NamedQuery(name = "TarjetasCreditos.findByIdTarjeta", query = "SELECT t FROM TarjetasCreditos t WHERE t.idTarjeta = :idTarjeta")
    , @NamedQuery(name = "TarjetasCreditos.findByCvvTarjeta", query = "SELECT t FROM TarjetasCreditos t WHERE t.cvvTarjeta = :cvvTarjeta")
    , @NamedQuery(name = "TarjetasCreditos.findByTipoTarjeta", query = "SELECT t FROM TarjetasCreditos t WHERE t.tipoTarjeta = :tipoTarjeta")
    , @NamedQuery(name = "TarjetasCreditos.findByFechaTarjeta", query = "SELECT t FROM TarjetasCreditos t WHERE t.fechaTarjeta = :fechaTarjeta")})
public class TarjetaCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tarjeta")
    private Integer idTarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cvv_tarjeta")
    private int cvvTarjeta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_tarjeta")
    private String tipoTarjeta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fecha_tarjeta")
    private String fechaTarjeta;
    @JoinColumn(name = "clientes_id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente clienteIdCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarjetasCreditosIdTarjeta")
    private Collection<Pago> pagosCollection;

    public TarjetaCredito() {
    }

    public TarjetaCredito(Integer idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public TarjetaCredito(Integer idTarjeta, int cvvTarjeta, String tipoTarjeta, String fechaTarjeta) {
        this.idTarjeta = idTarjeta;
        this.cvvTarjeta = cvvTarjeta;
        this.tipoTarjeta = tipoTarjeta;
        this.fechaTarjeta = fechaTarjeta;
    }

    public Integer getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Integer idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public int getCvvTarjeta() {
        return cvvTarjeta;
    }

    public void setCvvTarjeta(int cvvTarjeta) {
        this.cvvTarjeta = cvvTarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getFechaTarjeta() {
        return fechaTarjeta;
    }

    public void setFechaTarjeta(String fechaTarjeta) {
        this.fechaTarjeta = fechaTarjeta;
    }

    public Cliente getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(Cliente clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }
    
    public int getCliente(){
        return this.clienteIdCliente.getIdCliente();
    }
    
    public void setCliente(int id){
        this.clienteIdCliente = new Cliente(id);
    }

    @XmlTransient
    public Collection<Pago> getPagosCollection() {
        return pagosCollection;
    }

    public void setPagosCollection(Collection<Pago> pagosCollection) {
        this.pagosCollection = pagosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarjeta != null ? idTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarjetaCredito)) {
            return false;
        }
        TarjetaCredito other = (TarjetaCredito) object;
        if ((this.idTarjeta == null && other.idTarjeta != null) || (this.idTarjeta != null && !this.idTarjeta.equals(other.idTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.persistence.TarjetasCreditos[ idTarjeta=" + idTarjeta + " ]";
    }
    
}
