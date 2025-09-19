package models;

public class PagoBitcoin implements EstrategiaPago {
    @Override
    public boolean procesarPago(ModeloPago modelo) {
        System.out.println("Procesando pago con Bitcoin...");
        System.out.println("Monto equivalente: " + (modelo.getMonto() / 50000) + " BTC");
        System.out.println("Detalles: " + modelo.getDetalles());
        return true;
    }

    @Override
    public String getNombre() { return "Bitcoin"; }
}