import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(1,2,3);
        List<String> palabras = List.of("Java","Genericos");

        Util.imprimirLista(numeros);
        Util.imprimirLista(palabras);
    }
}