package models;

public class ModeloPago {
    private double monto;
    private String metodoPago;
    private String detalles;

    public ModeloPago(double monto, String metodoPago, String detalles) {
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.detalles = detalles;
    }
    public double getMonto() {
        return monto;
    }
    public String getMetodoPago() {
        return metodoPago;
    }
    public String getDetalles() {
        return detalles;
    }
}
