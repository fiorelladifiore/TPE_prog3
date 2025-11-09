public class Maquina implements Comparable<Maquina> {

    private int capacidad;
    private String nombre;
    private int cantEncendidos;

    public Maquina(int capacidad, String nombre) {
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.cantEncendidos = 0;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantEncendidos() {
        return cantEncendidos;
    }

    public void setCantEncendidos(int cantEncendidos) {
        this.cantEncendidos = cantEncendidos;
    }

    @Override
    public int compareTo(Maquina other){ // comparable para hacer el sort x capacidad
        return other.capacidad - this.capacidad;
    }

    public String toString() {
        return this.getNombre(); // Simplemente devuelve el nombre
    }

}
