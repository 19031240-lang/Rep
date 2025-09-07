//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Caja<String> cajaTexto= new Caja<>("Hola Mundo");
        System.out.println(cajaTexto.getContenido()); //Hola Mundo

        Caja<Integer> cajaNumero= new Caja<>(42);
        System.out.println(cajaNumero.getContenido()); // 42
    }
}