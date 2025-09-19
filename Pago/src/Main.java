import contrellers.ControladorPago;
import views.VistaPago;


public class Main {
    public static void main(String[] args) {
        // Crear primero la vista
        VistaPago vista = new VistaPago();

        // Crear el controlador inyectando la vista
        ControladorPago controlador = new ControladorPago(vista);

        // Inyectar el controlador en la vista
        vista.setControlador(controlador);

        // Iniciar la aplicación
        vista.mostrarMenu();
    }
}
