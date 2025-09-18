package Controllers;

import Models.Notificacion;
import Models.NotificacionFactory;
import Views.NotificacionVista;

public class NotificacionControlador {
    private final GestorNotificaciones<Notificacion> gestor;
    private final NotificacionVista vista;

    public NotificacionControlador(GestorNotificaciones<Notificacion> gestor, NotificacionVista vista) {
        this.gestor = gestor;
        this.vista = vista;
    }

    public void agregarNotificacion(String tipo) {
        try {
            Notificacion n = NotificacionFactory.crearNotificacion(tipo);
            gestor.agregar(n);
            vista.mostrarMensaje("Notificación de tipo " + tipo + " agregada.");
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    public void enviarNotificaciones(String mensaje) {
        if (gestor.contar() == 0) {
            vista.mostrarMensaje("No hay notificaciones para enviar.");
            return;
        }
        vista.mostrarMensaje("=== Enviando notificaciones ===");
        gestor.enviarTodas(mensaje);
    }
}