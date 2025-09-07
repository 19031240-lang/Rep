//Interface genericas
interface Operacion <T>{
    T ejecutar(T a,T b);
}
//Implementacion de la interfaz con enteros
public class Suma implements Operacion<Integer>{
    public Integer ejecutar(Integer a,Integer b){
        return a+b;
    }
}
