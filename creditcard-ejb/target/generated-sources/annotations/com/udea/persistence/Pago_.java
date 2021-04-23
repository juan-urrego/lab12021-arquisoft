package com.udea.persistence;

import com.udea.persistence.TarjetaCredito;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-22T21:52:06")
@StaticMetamodel(Pago.class)
public class Pago_ { 

    public static volatile SingularAttribute<Pago, String> timeStampPago;
    public static volatile SingularAttribute<Pago, TarjetaCredito> tarjetasCreditosIdTarjeta;
    public static volatile SingularAttribute<Pago, Integer> idPago;
    public static volatile SingularAttribute<Pago, Integer> valorPago;

}