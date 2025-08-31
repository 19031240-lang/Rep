import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cajero {
    private List<Cuenta> cuentas = new ArrayList<Cuenta>();
    private Cuenta usuarioActual;
    Scanner s= new Scanner(System.in);
    public Cajero() {
        cuentas.add(new Cuenta("1234", "Juan", 1000.0));
        cuentas.add(new Cuenta("5678", "Maria", 2500.0));
    }
    public void iniciar(){
        System.out.println("***** Cajero, Por favor indroduzca sus datos para iniciar!! *****");
        if(!login()){
            System.out.println("Demasiados intentos fallidos");
            return;
        }
        menu ();
    }
    private boolean login(){
        int intentos=0;
        System.out.println("Ingrese su usuario");
        String usuario = s.nextLine();
        while (intentos < 3) {
            System.out.print("Ingrese su PIN: ");
            String pin = s.nextLine();
            usuarioActual = buscarCuenta(pin);
            if (usuarioActual != null) {
                System.out.println("Bienvenido, " + usuarioActual.getNombre());
                return true;
            } else {
                System.out.println("PIN incorrecto.");
                intentos++;
            }
        }
        return false;
    }
    private void menu(){
        boolean salir = false;
        while (!salir) {
            System.out.println("\n1. Ver saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = s.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Su saldo actual es:"+usuarioActual.getSaldo());
                    break;
                case 2:
                   retirar();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    System.out.println("Gracias por usar nuestro Cajero, ¡Hasta luego!");
            }
        }
    }

    private void retirar() {
        System.out.print("Ingrese cantidad a retirar: ");
        double retiro = s.nextDouble();
        if (usuarioActual.retirar(retiro)) {
            System.out.println("Retiro exitoso. Nuevo saldo: $" + usuarioActual.getSaldo());
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }
    private void depositar() {
        System.out.println("Ingrese la cantidad que desea depositar: ");
        double depositar = s.nextDouble();
        usuarioActual.depositar(depositar);
        System.out.println("Deposito realizado");
    }
    private Cuenta buscarCuenta(String pin) {
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getPin().equals(pin)) {
                return cuentas.get(i);
            }
        }
        return null;
    }


}


