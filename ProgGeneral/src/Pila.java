// Clase genérica Pila
class Pila<T> {
    private java.util.ArrayList<T> elementos = new java.util.ArrayList<>();

    public void apilar(T elemento) {
        elementos.add(elemento);
    }

    public T desapilar() {
        if (!elementos.isEmpty()) {
            return elementos.remove(elementos.size() - 1);
        }
        return null;
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }
}