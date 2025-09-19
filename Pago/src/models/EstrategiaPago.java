package models;

public interface EstrategiaPago {
    boolean procesarPago(ModeloPago modelo);
    String getNombre();
}



