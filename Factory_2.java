// Este programa implementa el patrón Abstract Factory para crear diferentes tipos de automóviles.



/*
  Interfaz de la fábrica abstracta que declara el método para crear productos (carros).
  Define una interfaz para crear objetos Car sin especificar sus clases concretas.
 */
interface CarFactory {
    /*
     Método factory para crear instancias de Car.
      return Una instancia de un tipo específico de Car (Sedan o SUV)
     */
    Car createCar();
}

/*
 Interfaz que define el producto base (Car) que todas las fábricas crearán.
 Establece el contrato que todos los tipos de carros deben implementar.
 */
interface Car {
    /*
     Método que simula el proceso de ensamblaje del carro.
     Cada implementación concreta proporcionará su propia lógica de ensamblaje.
     */
    void assemble();
}

/*
 Implementación concreta de un Sedan que implementa la interfaz Car.
 Representa un tipo específico de automóvil con características de sedán.
 */
class Sedan implements Car {
    /*
      Implementación específica del ensamblaje para un sedán.
     Proporciona detalles sobre el proceso de ensamblaje de este tipo de vehículo.
     */
    @Override
    public void assemble() {
        System.out.println("Assembling a sedan car.");
        // En una implementación real, aquí iría la lógica específica para ensamblar un sedán
    }
}

/*
 Implementación concreta de un SUV que implementa la interfaz Car.
 Representa un tipo específico de automóvil con características de SUV (Sport Utility Vehicle).
 */
class SUV implements Car {
    /*
     Implementación específica del ensamblaje para un SUV.
     Proporciona detalles sobre el proceso de ensamblaje de este tipo de vehículo.
     */
    @Override
    public void assemble() {
        System.out.println("Assembling an SUV car.");
        // En una implementación real, aquí iría la lógica específica para ensamblar un SUV
    }
}

/*
 Fábrica concreta que implementa la interfaz CarFactory para crear instancias de Sedan.
 Se especializa en la producción de objetos de tipo Sedan.
 */
class SedanFactory implements CarFactory {
    /*
     Implementación del método factory para crear Sedans.
     return Una nueva instancia de Sedan
     */
    @Override
    public Car createCar() {
        return new Sedan();
    }
}

/*
 Fábrica concreta que implementa la interfaz CarFactory para crear instancias de SUV.
 Se especializa en la producción de objetos de tipo SUV.
 */
class SUVFactory implements CarFactory {

     // Implementación del método factory para crear SUVs.

    @Override
    public Car createCar() {
        return new SUV();
    }
}

/*
 Clase principal que demuestra el uso del patrón Abstract Factory.
 Muestra cómo crear diferentes tipos de carros utilizando sus fábricas correspondientes.
 */
public class Main {

     // Método principal que ejecuta la demostración del patrón Abstract Factory.

    public static void main(String[] args) {
        // Crear una fábrica de Sedans y usarla para producir un Sedan
        CarFactory sedanFactory = new SedanFactory();
        Car sedan = sedanFactory.createCar();
        sedan.assemble();  // Ensamblar el Sedan

        // Crear una fábrica de SUVs y usarla para producir un SUV
        CarFactory suvFactory = new SUVFactory();
        Car suv = suvFactory.createCar();
        suv.assemble();  // Ensamblar el SUV

        // El cliente code sólo interactúa con interfaces (CarFactory y Car)
        // sin conocer las implementaciones concretas, demostrando el desacoplamiento
    }
}