//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Calculadora<Integer> clac1 = new Calculadora<>(10);
        System.out.println(clac1.getDoble());// 20

        Calculadora<Double> clac2 = new Calculadora<>(5.5);
        System.out.println(clac2.getDoble());//11
    }
}