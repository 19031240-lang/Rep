package views;

import java.util.Scanner;

public class CajeroViews {
    private Scanner sc;

    public CajeroViews() {
        sc = new Scanner(System.in);
    }

    public void mostrarBienvenida() {
        System.out.println("=================================================");
        System.out.println(" Bienvenido al cajero automático del banco ");
        System.out.println("=================================================");
    }

    public String solicitarNumeroCuenta() {
        System.out.print("Ingresa tu número de cuenta: ");
        return sc.nextLine();
    }

    public String solicitaPin() {
        System.out.print("Ingresa tu PIN: ");
        return sc.nextLine();
    }

    public void mostrarMenu(String titular) {
        System.out.println("=============================================");
        System.out.println(" Bienvenido " + titular);
        System.out.println("=============================================");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Retirar");
        System.out.println("3. Depositar");
        System.out.println("4. Transferir");
        System.out.println("5. Cambiar PIN");
        System.out.println("6. Cerrar sesión");
        System.out.println("0. Salir del sistema");
    }

    public int leerOpcion() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public double solicitarCantidad(String operacion) {
        System.out.print("Ingresa la cantidad a " + operacion + ": ");
        try {
            return Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String solicitarNumeroCuentaDestino() {
        System.out.print("Ingresa el número de cuenta destino: ");
        return sc.nextLine();
    }

    public String solicitaPinActual() {
        System.out.print("Ingresa tu PIN actual: ");
        return sc.nextLine();
    }

    public String solicitarNuevoPin() {
        System.out.print("Ingresa tu nuevo PIN: ");
        return sc.nextLine();
    }

    public void mostrarMensajeExito(String mensaje) {
        System.out.println( mensaje);
    }

    public void mostrarMensajeError(String mensaje) {
        System.out.println( mensaje);
    }

    public void cerrarScanner() {

            sc.close();
            System.out.println("Gracias por usar el cajero. ¡Hasta luego!");

    }
}
