package views;

import contrellers.ControladorPago;
import models.PagoBitcoin;
import models.PagoPayPal;
import models.PagoTarjetaCredito;

import java.util.List;
import java.util.Scanner;

public class VistaPago {
    private ControladorPago controlador;
    private Scanner scanner;
    private String metodoSeleccionado; // ← NUEVO: guardar la selección

    public VistaPago() {
        this.scanner = new Scanner(System.in);
    }

    public void setControlador(ControladorPago controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n=== SISTEMA DE PAGOS  ===");
            System.out.println("1. Seleccionar método de pago");
            System.out.println("2. Realizar pago");
            System.out.println("3. Salir");

            // Mostrar método seleccionado actualmente
            if (metodoSeleccionado != null) {
                System.out.println("Método actual: " + metodoSeleccionado);
            }

            System.out.print("Seleccione opción: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1 -> seleccionarMetodoPago();
                    case 2 -> realizarPago();
                    case 3 -> {
                        System.out.println("¡Hasta luego!");
                        return;
                    }
                    default -> System.out.println("Opción inválida");
                }
            } catch (Exception e) {
                System.out.println("Error: Ingrese un número válido");
                scanner.nextLine(); // Limpiar buffer en caso de error
            }
        }
    }

    private void seleccionarMetodoPago() {
        System.out.println("\nMétodos de pago disponibles:");
        List<String> metodos = controlador.getMetodosPagoDisponibles();

        for (int i = 0; i < metodos.size(); i++) {
            System.out.println((i + 1) + ". " + metodos.get(i));
        }

        System.out.print("Seleccione método: ");

        try {
            int seleccion = scanner.nextInt();
            scanner.nextLine();

            switch (seleccion) {
                case 1 -> {
                    controlador.setEstrategia(new PagoTarjetaCredito());
                    metodoSeleccionado = "Tarjeta de Crédito";
                    mostrarExito("Método seleccionado: Tarjeta de Crédito");
                }
                case 2 -> {
                    controlador.setEstrategia(new PagoPayPal());
                    metodoSeleccionado = "PayPal";
                    mostrarExito("Método seleccionado: PayPal");
                }
                case 3 -> {
                    controlador.setEstrategia(new PagoBitcoin());
                    metodoSeleccionado = "Bitcoin";
                    mostrarExito("Método seleccionado: Bitcoin");
                }
                default -> mostrarError("Opción inválida");
            }
        } catch (Exception e) {
            mostrarError("Ingrese un número válido");
            scanner.nextLine();
        }
    }

    private void realizarPago() {
        if (controlador.getEstrategiaActual() == null) {
            mostrarError("Primero debe seleccionar un método de pago");
            return;
        }

        try {
            System.out.print("Ingrese monto: ");
            double monto = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Ingrese detalles del pago: ");
            String detalles = scanner.nextLine();

            // Procesar el pago
            controlador.procesarPago(monto, detalles);

        } catch (Exception e) {
            mostrarError("Error en los datos ingresados");
            scanner.nextLine();
        }
    }

    public void mostrarExito(String mensaje) {
        System.out.println("Bien" + mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("Fallo" + mensaje);
    }
}