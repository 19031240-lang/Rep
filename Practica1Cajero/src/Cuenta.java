public class Cuenta {
    private String pin;
    private String nombre;
    private double saldo;
    public Cuenta(String pin, String nombre, double saldo) {
        this.pin = pin;
        this.nombre = nombre;
        this.saldo = saldo;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getSaldo() {
        return saldo;
    }
    public void depositar(double cantidad) {
        saldo += cantidad;
    }
    public boolean retirar(double cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

}
