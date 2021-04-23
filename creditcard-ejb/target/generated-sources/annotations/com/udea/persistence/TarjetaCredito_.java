package com.udea.persistence;

import com.udea.persistence.Cliente;
import com.udea.persistence.Pago;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-23T13:08:00")
@StaticMetamodel(TarjetaCredito.class)
public class TarjetaCredito_ { 

    public static volatile SingularAttribute<TarjetaCredito, String> fechaTarjeta;
    public static volatile SingularAttribute<TarjetaCredito, Integer> idTarjeta;
    public static volatile SingularAttribute<TarjetaCredito, String> tipoTarjeta;
    public static volatile SingularAttribute<TarjetaCredito, Integer> cvvTarjeta;
    public static volatile SingularAttribute<TarjetaCredito, Cliente> clientesIdCliente;
    public static volatile CollectionAttribute<TarjetaCredito, Pago> pagoCollection;

}