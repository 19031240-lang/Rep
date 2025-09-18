package models;

public class Cuenta<T> {
    private T numeroCuenta;
    private String nip;
    private double saldo;
    private String titular;

    public Cuenta(T numeroCuenta, String nip, double saldo, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.nip = nip;
        this.saldo = saldo;
        this.titular = titular;
    }

    public T getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public boolean validarPIN(String pin) {
        return this.nip.equals(pin);
    }

    public void setNip(String nuevoNip) {
        this.nip = nuevoNip;
    }

    public void depositar(double cantidad) {
        this.saldo += cantidad;
    }

    public boolean retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    public boolean transferir(double cantidad, Cuenta<T> destino) { // 👈 nota que destino también es genérico
        if (retirar(cantidad)) {
            destino.depositar(cantidad);
            return true;
        }
        return false;
    }
}
