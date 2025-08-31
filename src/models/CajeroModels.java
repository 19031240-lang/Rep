package models;

import java.util.HashMap;
import java.util.Map;
public class CajeroModels {
    private Map<String, Cuenta> cuentas;
    private Cuenta cuentaActual;
   public CajeroModels() {
       cuentas = new HashMap<>();
       inicializarCuentas();
   }
   private void inicializarCuentas() {
       cuentas.put("12345", new Cuenta("1234","1111",5000000.00,"Juan Perez"));
       cuentas.put("54321",new Cuenta("54321","000",4522,"Maria Guadalipe N"));
   }
   public boolean autentificar(String numeroCuenta, String pin){
       Cuenta cuenta=cuentas.get(numeroCuenta);
       if(cuenta!=null && cuenta.validarPIN(pin)){
           this.cuentaActual=cuenta;
           return true;
       }
       return false;
   }
    public Cuenta getCuentaActual() {
       return cuentaActual;
    }
   public double consultarSaldo(){
       return this.cuentaActual != null ? cuentaActual.getSaldo() : 0;
   }
   public boolean realizarRetiro(double cantidad){
       return cuentaActual != null && cuentaActual.retirar(cantidad);
   }
   public boolean realizarDeposito(double cantidad){
       if(cuentaActual != null && cantidad >0 ){
           cuentaActual.depositar(cantidad);
           return true;
       }
       return false;
   }
   public boolean centaExistente(String numeroCuenta){
       return  cuentas.containsKey(numeroCuenta);
   }
   //definir el modo para transferir
   public boolean realizarTransferencia(String numeroCuentaDestino, double cantidad) {
       if (cuentaActual == null || cantidad <= 0) {
           return false;
       }
       Cuenta cuentaDestino = cuentas.get(numeroCuentaDestino);
       if (cuentaDestino == null) {
           return false;
       }
       if (cuentaActual.transferir(cantidad, cuentaDestino)) {
           return true;
       }
       return false;
   }
}
