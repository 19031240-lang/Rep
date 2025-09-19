package models;

public class PagoPayPal implements EstrategiaPago {
    @Override
    public boolean procesarPago(ModeloPago modelo) {
        System.out.println("Procesando pago con PayPal...");
        System.out.println("Monto: $" + modelo.getMonto());
        System.out.println("Detalles: " + modelo.getDetalles());
        return true;
    }

    @Override
    public String getNombre() { return "PayPal"; }
}
