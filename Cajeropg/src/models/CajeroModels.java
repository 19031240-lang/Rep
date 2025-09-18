package models;

import java.util.HashMap;
import java.util.Map;

public class CajeroModels {
    private Map<String, Cuenta<String>> cuentas;
    private Cuenta<String> cuentaActual;

    public CajeroModels() {
        cuentas = new HashMap<>();
        inicializarCuentas();
    }

    private void inicializarCuentas() {
        cuentas.put("12345", new Cuenta<>("12345", "1111", 5000, "Juan Perez"));
        cuentas.put("54321", new Cuenta<>("54321", "0000", 4522, "Maria Guadalupe"));
    }

    public boolean autentificar(String numeroCuenta, String pin) {
        Cuenta<String> cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null && cuenta.validarPIN(pin)) {
            this.cuentaActual = cuenta;
            return true;
        }
        return false;
    }

    public Cuenta<String> getCuentaActual() {
        return cuentaActual;
    }

    public double consultarSaldo() {
        return cuentaActual != null ? cuentaActual.getSaldo() : 0;
    }

    public boolean realizarRetiro(double cantidad) {
        return cuentaActual != null && cuentaActual.retirar(cantidad);
    }

    public boolean realizarDeposito(double cantidad) {
        if (cuentaActual != null && cantidad > 0) {
            cuentaActual.depositar(cantidad);
            return true;
        }
        return false;
    }

    public boolean realizarTransferencia(String numeroCuentaDestino, double cantidad) {
        if (cuentaActual == null || cantidad <= 0) return false;
        Cuenta<String> destino = cuentas.get(numeroCuentaDestino);
        if (destino == null) return false;
        return cuentaActual.transferir(cantidad, destino);
    }

    public boolean cambiarNIP(String nipActual, String nuevoNip) {
        if (cuentaActual != null && cuentaActual.validarPIN(nipActual)) {
            cuentaActual.setNip(nuevoNip);
            return true;
        }
        return false;
    }
}
