package models;

public class Cuenta {
    private String numeroCuenta;
    private String pin;
    private double saldo;
    private String titular;

    public Cuenta(String numeroCuenta, String pin, double saldo, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.pin = pin;
        this.saldo = saldo;
        this.titular = titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getPin() {
        return pin;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    // Reglas de negocio
    public boolean validarPIN(String pinIngresado) {
        return this.pin.equals(pinIngresado);
    }

    public boolean retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= this.saldo) {
            this.saldo -= cantidad;
            return true;
        }
        return false;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
        }
    }

    // Transferir dinero a otra cuenta
    public boolean transferir(double cantidad, Cuenta destino) {
        if (this.retirar(cantidad)) {
            destino.depositar(cantidad);
            return true;
        }
        return false;
    }

    //Cambiar PIN
    public boolean cambiarPIN(String pinActual, String nuevoPin) {
        if (this.validarPIN(pinActual) && nuevoPin != null && nuevoPin.length() >= 4) {
            this.pin = nuevoPin;
            return true;
        }
        return false;
    }
}
