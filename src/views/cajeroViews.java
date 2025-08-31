package views;

import java.util.Scanner;

public class cajeroViews {
    private Scanner sc;

    public cajeroViews() {
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
        System.out.println("2. Retirar ");
        System.out.println("3. Depositar");
        System.out.println("4. Transferir");
        System.out.println("5. Cambiar PIN");
        System.out.println("9. Salir");
    }

    public int leerOpcion() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void mostrarSaldo(double saldo) {
        System.out.println("=============================================");
        System.out.println(" Su saldo actual es: $" + saldo);
        System.out.println("=============================================");
    }

    public double solicitarCantidad(String operacion) {
        System.out.print("Ingresa la cantidad a " + operacion + ": ");
        try {
            return Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    public void mostrarMensajeExito(String mensaje) {
        System.out.println("[ÉXITO] " + mensaje);
    }

    public void mostrarMensajeError(String mensaje) {
        System.out.println("[ERROR] " + mensaje);
    }

    public void cerrarScanner() {
        if (sc != null) {
            sc.close();
            System.out.println("Gracias por usar el cajero. ¡Hasta luego!");
        }
    }
}
