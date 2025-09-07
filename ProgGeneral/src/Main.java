//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Uso de Caja con String
        Caja<String> cajaTexto = new Caja<>("Hola Generics");
        System.out.println(cajaTexto);

        // Uso de Caja con Integer
        Caja<Integer> cajaNumero = new Caja<>(123);
        System.out.println(cajaNumero);

        // Uso de Pila con Strings
        Pila<String> pilaNombres = new Pila<>();
        pilaNombres.apilar("Juan");
        pilaNombres.apilar("María");
        pilaNombres.apilar("Pedro");

        while (!pilaNombres.estaVacia()) {
            System.out.println("Sacando de la pila: " + pilaNombres.desapilar());
        }
    }
}