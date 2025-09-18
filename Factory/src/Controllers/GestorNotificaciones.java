package Controllers;

import java.util.ArrayList;
import java.util.List;
import Models.Notificacion;

public class GestorNotificaciones<T extends Notificacion> {
    private final List<T> notificaciones = new ArrayList<>();

    public void agregar(T notificacion) {
        notificaciones.add(notificacion);
    }

    public void enviarTodas(String mensaje) {
        for (T n : notificaciones) {
            n.enviar(mensaje);
        }
    }

    public int contar() {
        return notificaciones.size();
    }
}