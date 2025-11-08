public class Maquina {

    private int capacidad;
    private String nombre;

    public Maquina(int capacidad, String nombre) {
        this.capacidad = capacidad;
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return this.getNombre(); // Simplemente devuelve el nombre
    }

}
