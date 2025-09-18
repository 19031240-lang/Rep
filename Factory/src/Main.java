import Controllers.GestorNotificaciones;
import Controllers.NotificacionControlador;
import Models.Notificacion;
import Views.NotificacionVista;

public class Main {
    public static void main(String[] args) {
        NotificacionVista vista = new NotificacionVista();
        GestorNotificaciones<Notificacion> gestor = new GestorNotificaciones<>();
        NotificacionControlador controlador = new NotificacionControlador(gestor, vista);

        // Simulación: agregamos notificaciones usando la Factory desde el controlador
        controlador.agregarNotificacion("email");
        controlador.agregarNotificacion("sms");
        controlador.agregarNotificacion("push");
        controlador.agregarNotificacion("whatsapp"); // esto debe producir un error controlado

        // Enviamos todas las notificaciones
        controlador.enviarNotificaciones("Hola, este es un mensaje importante.");
    }
}