package moneda;

import java.util.Scanner;

public class Moneda {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Cajero cajero1 = new Cajero();

        System.out.println("Ingresa los euros a transformar");
        System.out.println("Ingresa 0 para terminar");

        while(true){
            int cantidad = leer.nextInt();
            if (cantidad == 0){
                System.out.println("Finalizado.");
                break;
            }
            cajero1.setCantidad(cantidad);
            cajero1.Cambio();
        }

        leer.close();
    }
}
