//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Par<String, Integer> edadPersona = new Par<>("Carlos",25);
        System.out.println(
                edadPersona.getClave()+" tiene "+
                edadPersona.getValor()+" años"
        );
    }
}