package controllers;

import models.CajeroModels;
import views.CajeroViews;

public class CajeroControlles {
    private CajeroModels model;
    private CajeroViews views;
    private boolean sistemaActivo;

    public CajeroControlles(CajeroModels model, CajeroViews views) {
        this.model = model;
        this.views = views;
        this.sistemaActivo = true;
    }

    public void iniciarSistema() {
        views.mostrarBienvenida();
        while (sistemaActivo) {
            if (autentificarUsuario()) {
                ejecutarMenuPrincipal();
            } else {
                views.mostrarMensajeError("Credenciales incorrectas");
            }
        }
        views.mostrarMensajeExito("Gracias por usar nuestro cajero");
        views.cerrarScanner();
    }

    private boolean autentificarUsuario() {
        String numeroCuenta = views.solicitarNumeroCuenta();
        String pin = views.solicitaPin();
        return model.autentificar(numeroCuenta, pin);
    }

    private void ejecutarMenuPrincipal() {
        boolean sesionActiva = true;
        while (sesionActiva) {
            views.mostrarMenu(model.getCuentaActual().getTitular());
            int opcion = views.leerOpcion();

            switch (opcion) {
                case 1: // Consultar saldo
                    double saldo = model.consultarSaldo();
                    views.mostrarMensajeExito("Saldo disponible: $" + saldo);
                    break;

                case 2: // Retiro
                    double retiro = views.solicitarCantidad("retirar");
                    if (model.realizarRetiro(retiro)) {
                        views.mostrarMensajeExito("Retiro exitoso");
                    } else {
                        views.mostrarMensajeError("Fondos insuficientes o cantidad inválida");
                    }
                    break;

                case 3: // Depósito
                    double deposito = views.solicitarCantidad("depositar");
                    if (model.realizarDeposito(deposito)) {
                        views.mostrarMensajeExito("Depósito exitoso");
                    } else {
                        views.mostrarMensajeError("Depósito inválido");
                    }
                    break;

                case 4: // Transferencia
                    String cuentaDestino = views.solicitarNumeroCuentaDestino();
                    double montoTransferencia = views.solicitarCantidad("transferencia");
                    if (model.realizarTransferencia(cuentaDestino, montoTransferencia)) {
                        views.mostrarMensajeExito("Transferencia exitosa");
                    } else {
                        views.mostrarMensajeError("Error en la transferencia");
                    }
                    break;

                case 5: // Cambio de NIP
                    String nipActual = views.solicitaPinActual();
                    String nuevoNip = views.solicitarNuevoPin();
                    if (model.cambiarNIP(nipActual, nuevoNip)) {
                        views.mostrarMensajeExito("NIP cambiado exitosamente");
                    } else {
                        views.mostrarMensajeError("NIP actual incorrecto");
                    }
                    break;

                case 6: // Cerrar sesión
                    views.mostrarMensajeExito("Sesión cerrada");
                    sesionActiva = false;
                    break;

                case 0: // Salir del sistema
                    views.mostrarMensajeExito("Saliendo del sistema...");
                    sesionActiva = false;
                    sistemaActivo = false;
                    break;

                default:
                    views.mostrarMensajeError("Opción no válida");
            }
        }
    }
}
