package contrellers;

import models.EstrategiaPago;
import models.ModeloPago;
import views.VistaPago;

import java.util.Arrays;
import java.util.List;

public class ControladorPago {
    private EstrategiaPago estrategia;
    private VistaPago vista;

    public ControladorPago(VistaPago vista) {
        this.vista = vista;
    }

    public void setEstrategia(EstrategiaPago estrategia) {
        this.estrategia = estrategia;
    }

    public EstrategiaPago getEstrategiaActual() {
        return estrategia;
    }

    public void procesarPago(double monto, String detalles) {
        if (estrategia == null) {
            vista.mostrarError("Seleccione un método de pago primero");
            return;
        }

        ModeloPago modelo = new ModeloPago(monto, estrategia.getNombre(), detalles);
        boolean exito = estrategia.procesarPago(modelo);

        if (exito) {
            vista.mostrarExito("Pago de $" + monto + " procesado exitosamente con " + estrategia.getNombre());
        } else {
            vista.mostrarError("Error al procesar el pago");
        }
    }

    public List<String> getMetodosPagoDisponibles() {
        return Arrays.asList("Tarjeta de Crédito", "PayPal", "Bitcoin");
    }
}



