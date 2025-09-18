package Models;

public class NotificacionFactory {
    public static Notificacion crearNotificacion(String tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo de notificación nulo");
        }
        switch (tipo.toLowerCase()) {
            case "email":
                return new EmailNotificacion();
            case "sms":
                return new SMSNotificacion();
            case "push":
                return new PushNotificacion();
            default:
                throw new IllegalArgumentException("Tipo de notificación no soportado: " + tipo);
        }
    }
}