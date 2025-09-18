/*
  Este programa implementa el patrón Factory para crear diferentes tipos de vehículos
  de manera flexible.
 */

/*
  Interfaz que define el contrato que todos los vehículos deben implementar.
  Establece los métodos básicos que cualquier vehículo debe tener.
 */
interface Vehiculo {
    /*
      Simula la acción de acelerar el vehículo. Cada tipo de vehículo implementará este método de manera diferente.
     */
    void acelerar();

    /*
     Simula la acción de frenar el vehículo.
     Cada tipo de vehículo implementará este método de manera diferente.
     */
    void frenar();

    /*
      Muestra información específica sobre el vehículo.
      Incluye detalles como marca, modelo y características particulares.
     */
    void mostrarInfo();
}


/*Implementación concreta de un Coche que implementa la interfaz Vehiculo.
  Representa un vehículo de cuatro ruedas con motor a gasolina.
 */
class Coche implements Vehiculo {
    private String marca;
    private String modelo;

    // Constructor para crear una instancia de Coche.

    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    /*
     Implementación específica de acelerar para un coche.
     Muestra un mensaje indicando que el coche está acelerando por la carretera.
     */
    @Override
    public void acelerar() {
        System.out.println("El coche " + marca + " " + modelo + " está acelerando por la carretera");
    }

    /*
     Implementación específica de frenar para un coche.
     Muestra un mensaje indicando que el coche utiliza frenos de disco.
     */
    @Override
    public void frenar() {
        System.out.println("El coche está frenando con frenos de disco");
    }

    /*
     Muestra información detallada sobre el coche.
      Incluye marca, modelo y características generales.
     */
    @Override
    public void mostrarInfo() {
        System.out.println("🚗 Coche: " + marca + " " + modelo + " - 4 ruedas, motor a gasolina");
    }
}

/*
  Implementación concreta de una Motocicleta que implementa la interfaz Vehiculo.
  Representa un vehículo de dos ruedas, ágil y rápido.
 */
class Motocicleta implements Vehiculo {
    private String marca;
    private int cilindrada;

    //Constructor para crear una instancia de Motocicleta.

    public Motocicleta(String marca, int cilindrada) {
        this.marca = marca;
        this.cilindrada = cilindrada;
    }

    /*
     Implementación específica de acelerar para una motocicleta.
     Muestra un mensaje indicando la cilindrada de la moto mientras acelera.
     */
    @Override
    public void acelerar() {
        System.out.println("La motocicleta " + marca + " está acelerando con " + cilindrada + "cc");
    }

    //Implementación específica de frenar para una motocicleta.

    @Override
    public void frenar() {
        System.out.println("La motocicleta está frenando con precaución");
    }

    // Muestra información detallada sobre la motocicleta.

    @Override
    public void mostrarInfo() {
        System.out.println("🏍️ Motocicleta: " + marca + " " + cilindrada + "cc - 2 ruedas, ágil y rápida");
    }
}

/*
 Implementación concreta de un Camión que implementa la interfaz Vehiculo.
 Representa un vehículo pesado de carga con gran capacidad.
 */
class Camion implements Vehiculo {
    private String marca;
    private double capacidadCarga;


     // Constructor para crear una instancia de Camión.

    public Camion(String marca, double capacidadCarga) {
        this.marca = marca;
        this.capacidadCarga = capacidadCarga;
    }

    /*
     Implementación específica de acelerar para un camión.
     Muestra un mensaje indicando que acelera lentamente debido a su carga.
     */
    @Override
    public void acelerar() {
        System.out.println("El camión " + marca + " está acelerando lentamente con " + capacidadCarga + " toneladas");
    }

    /*
     Implementación específica de frenar para un camión.
     Muestra un mensaje indicando que utiliza sistema de frenos neumático.
     */
    @Override
    public void frenar() {
        System.out.println("El camión está frenando con sistema de frenos neumático");
    }


     // Muestra información detallada sobre el camión.

    @Override
    public void mostrarInfo() {
        System.out.println("🚛 Camión: " + marca + " - Capacidad: " + capacidadCarga + " toneladas");
    }
}

/*
  Enumeración que define los tipos de vehículos disponibles en el sistema.
  Se utiliza para indicar a la fábrica qué tipo de vehículo debe crear.
 */
enum TipoVehiculo {
    COCHE, MOTOCICLETA, CAMION
}

/*
 Fábrica de vehículos que implementa el patrón de diseño Factory.
 Centraliza la lógica de creación de objetos vehículo, permitiendo
 desacoplar el código cliente de las clases concretas.
 */
class VehiculoFactory {


     //Crea un vehículo del tipo especificado con los parámetros proporcionados.


    public static Vehiculo crearVehiculo(TipoVehiculo tipo, String... parametros) {
        switch (tipo) {
            case COCHE:
                // Crear coche con parámetros o valores por defecto
                if (parametros.length >= 2) {
                    return new Coche(parametros[0], parametros[1]);
                } else {
                    return new Coche("Toyota", "Corolla"); // Valores por defecto
                }

            case MOTOCICLETA:
                // Crear motocicleta con parámetros o valores por defecto
                if (parametros.length >= 2) {
                    try {
                        int cilindrada = Integer.parseInt(parametros[1]);
                        return new Motocicleta(parametros[0], cilindrada);
                    } catch (NumberFormatException e) {
                        // Si el segundo parámetro no es un número, usar valor por defecto
                        return new Motocicleta(parametros[0], 250);
                    }
                } else {
                    return new Motocicleta("Yamaha", 250); // Valores por defecto
                }

            case CAMION:
                // Crear camión con parámetros o valores por defecto
                if (parametros.length >= 2) {
                    try {
                        double capacidad = Double.parseDouble(parametros[1]);
                        return new Camion(parametros[0], capacidad);
                    } catch (NumberFormatException e) {
                        // Si el segundo parámetro no es un número, usar valor por defecto
                        return new Camion(parametros[0], 10.0);
                    }
                } else {
                    return new Camion("Volvo", 15.0); // Valores por defecto
                }

            default:
                throw new IllegalArgumentException("Tipo de vehículo no soportado: " + tipo);
        }
    }

    // Crea un vehículo del tipo especificado con valores por defecto.

    public static Vehiculo crearVehiculoPorDefecto(TipoVehiculo tipo) {
        return crearVehiculo(tipo);
    }
}

/*
 Clase principal que demuestra el uso del patrón Factory para crear vehículos.
 Muestra diferentes formas de crear instancias y utilizar los métodos de los vehículos.
 */
public class FactoryPatternDemo {

    //Método principal que ejecuta la demostración del patrón Factory.

    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DEL PATRÓN FACTORY ===\n");

        // Crear vehículos específicos usando la fábrica con parámetros personalizados
        Vehiculo coche1 = VehiculoFactory.crearVehiculo(TipoVehiculo.COCHE, "Honda", "Civic");
        Vehiculo moto1 = VehiculoFactory.crearVehiculo(TipoVehiculo.MOTOCICLETA, "Kawasaki", "600");
        Vehiculo camion1 = VehiculoFactory.crearVehiculo(TipoVehiculo.CAMION, "Mercedes", "12.5");

        // Crear vehículos con valores por defecto
        Vehiculo coche2 = VehiculoFactory.crearVehiculoPorDefecto(TipoVehiculo.COCHE);
        Vehiculo moto2 = VehiculoFactory.crearVehiculoPorDefecto(TipoVehiculo.MOTOCICLETA);

        // Almacenar todos los vehículos en un arreglo para procesarlos juntos
        Vehiculo[] vehiculos = {coche1, moto1, camion1, coche2, moto2};

        // Mostrar información de todos los vehículos
        System.out.println("1. INFORMACIÓN DE VEHÍCULOS:");
        System.out.println("----------------------------");
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.mostrarInfo();
        }

        // Demostrar el comportamiento de acelerar de todos los vehículos
        System.out.println("\n2. ACELERANDO TODOS LOS VEHÍCULOS:");
        System.out.println("----------------------------------");
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.acelerar();
        }

        // Demostrar el comportamiento de frenar de todos los vehículos
        System.out.println("\n3. FRENANDO TODOS LOS VEHÍCULOS:");
        System.out.println("--------------------------------");
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.frenar();
        }

        // Demostrar creación dinámica basada en tipos de vehículo
        System.out.println("\n4. CREACIÓN DINÁMICA BASADA EN INPUT:");
        System.out.println("-------------------------------------");

        String[] tiposInput = {"COCHE", "MOTOCICLETA", "CAMION"};

        for (String tipoStr : tiposInput) {
            try {
                // Convertir string a enum y crear vehículo por defecto
                TipoVehiculo tipo = TipoVehiculo.valueOf(tipoStr);
                Vehiculo vehiculo = VehiculoFactory.crearVehiculoPorDefecto(tipo);
                System.out.print("Creado dinámicamente: ");
                vehiculo.mostrarInfo();
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de vehículo no válido: " + tipoStr);
            }
        }

        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}

/*
 Implementación adicional de una Bicicleta que implementa la interfaz Vehiculo.
 Esta clase no se utiliza en la demostración principal pero muestra cómo
 extender el sistema con nuevos tipos de vehículos.
 */
class Bicicleta implements Vehiculo {
    private String tipo;
    private int numVelocidades;


     // Constructor para crear una instancia de Bicicleta.

    public Bicicleta(String tipo, int numVelocidades) {
        this.tipo = tipo;
        this.numVelocidades = numVelocidades;
    }

    /*
      Implementación específica de acelerar para una bicicleta.
      Muestra un mensaje indicando que la bicicleta está siendo pedaleada.
     */
    @Override
    public void acelerar() {
        System.out.println("La bicicleta " + tipo + " está siendo pedaleada");
    }

    /*
      Implementación específica de frenar para una bicicleta.
      Muestra un mensaje indicando que utiliza frenos de mano.
     */
    @Override
    public void frenar() {
        System.out.println("La bicicleta está frenando con frenos de mano");
    }

    /*
      Muestra información detallada sobre la bicicleta.
      Incluye tipo, número de velocidades y características generales.
     */
    @Override
    public void mostrarInfo() {
        System.out.println("🚲 Bicicleta: " + tipo + " - " + numVelocidades + " velocidades, ecológica");
    }
}