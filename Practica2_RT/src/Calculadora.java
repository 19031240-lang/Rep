//Clase generica que solo acepta tipos que hereden de Number
public class Calculadora <T extends Number> {
    private T numero;

    public Calculadora(T numero) {
        this.numero = numero;

    }
    public double getDoble(){
        return numero.doubleValue() * 2;
    }
}
