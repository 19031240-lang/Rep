package moneda;

public class Cajero {
    private int cantidad;

    // Atributos para almacenar la cantidad de billetes/monedas
    private int b1000, b500, b200, b100, b50, b20;
    private int mon10, mon5, mon2, mon1;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void Cambio() {
        int cantidadR = cantidad;

        b1000 = b500 = b200 = b100 = b50 = b20 = 0;
        mon10 = mon5 = mon2 = mon1 = 0;

        if(cantidad == 0){
            System.out.println("Termino el programa");
            return;
        }

        if(cantidadR >= 1000){
            b1000 = cantidadR / 1000;
            cantidadR %= 1000;
        }
        if(cantidadR >= 500){
            b500 = cantidadR / 500;
            cantidadR %= 500;
        }
        if(cantidadR >= 200){
            b200 = cantidadR / 200;
            cantidadR %= 200;
        }
        if(cantidadR >= 100){
            b100 = cantidadR / 100;
            cantidadR %= 100;
        }
        if(cantidadR >= 50){
            b50 = cantidadR / 50;
            cantidadR %= 50;
        }
        if(cantidadR >= 20){
            b20 = cantidadR / 20;
            cantidadR %= 20;
        }
        if(cantidadR >= 10){
            mon10 = cantidadR / 10;
            cantidadR %= 10;
        }
        if(cantidadR >= 5){
            mon5 = cantidadR / 5;
            cantidadR %= 5;
        }
        if(cantidadR >= 2){
            mon2 = cantidadR / 2;
            cantidadR %= 2;
        }
        if(cantidadR >= 1){
            mon1 = cantidadR;
        }

        mostrarDesglose();
    }

    // Método para mostrar los resultados almacenados
    public void mostrarDesglose(){
        System.out.println("Desglose de " + cantidad + " euros:");
        if(b1000 > 0) System.out.println("Billetes de 1000: " + b1000);
        if(b500 > 0)  System.out.println("Billetes de 500: " + b500);
        if(b200 > 0)  System.out.println("Billetes de 200: " + b200);
        if(b100 > 0)  System.out.println("Billetes de 100: " + b100);
        if(b50 > 0)   System.out.println("Billetes de 50: " + b50);
        if(b20 > 0)   System.out.println("Billetes de 20: " + b20);
        if(mon10 > 0) System.out.println("Monedas de 10: " + mon10);
        if(mon5 > 0)  System.out.println("Monedas de 5: " + mon5);
        if(mon2 > 0)  System.out.println("Monedas de 2: " + mon2);
        if(mon1 > 0)  System.out.println("Monedas de 1: " + mon1);
    }
}
