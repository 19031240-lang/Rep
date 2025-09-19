package models;

public class PagoTarjetaCredito implements EstrategiaPago {
    @Override
    public boolean procesarPago(ModeloPago modelo) {
        System.out.println("Procesando pago con tarjeta de crédito...");
        System.out.println("Monto: $" + modelo.getMonto());
        System.out.println("Detalles: " + modelo.getDetalles());
        return true;
    }
    @Override
    public String getNombre() { return "Tarjeta de Crédito"; }
}


