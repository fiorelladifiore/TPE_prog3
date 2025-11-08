import java.util.*;

public class Solucion {

    private List<String> secuenciaMaquinasPrendidas; // le cambie el tipo de dato a String para que muestre el attr nombre de la maquina
    private int cantPiezasProducidas;
    private int cantMaquinasEncendidas;

    public Solucion(int cantMaquinasEncendidas, int cantPiezasProducidas, List<String> secuenciaMaquinasPrendidas) {
        this.cantMaquinasEncendidas = cantMaquinasEncendidas;
        this.cantPiezasProducidas = cantPiezasProducidas;
        this.secuenciaMaquinasPrendidas = new ArrayList<String>(secuenciaMaquinasPrendidas);
    }

    public int getCantMaquinasEncendidas() {
        return cantMaquinasEncendidas;
    }

    public void setCantMaquinasEncendidas(int cantMaquinasEncendidas) {
        this.cantMaquinasEncendidas = cantMaquinasEncendidas;
    }

    public int getCantPiezasProducidas() {
        return cantPiezasProducidas;
    }

    public void setCantPiezasProducidas(int cantPiezasProducidas) {
        this.cantPiezasProducidas = cantPiezasProducidas;
    }

    public List<String> getSecuenciaMaquinasPrendidas() {
        return secuenciaMaquinasPrendidas;
    }

    public void setSecuenciaMaquinasPrendidas(List<String> secuenciaMaquinasPrendidas) {
        this.secuenciaMaquinasPrendidas = new LinkedList<String>(secuenciaMaquinasPrendidas);
    }

    public void setSolucion(Estado e){ // en lugar de hacer uno por uno el set en el greedy, paso el estado final y seteo todo junto
        this.secuenciaMaquinasPrendidas = new ArrayList<>(e.secuenciaMaquinasPrendidas);
        this.cantPiezasProducidas = e.piezasCreadas;
        this.cantMaquinasEncendidas = e.maquinasPrendidas;
    }

    @Override
    public String toString() {
        return "Solucion{" +
                "cantMaquinasEncendidas=" + cantMaquinasEncendidas +
                ", secuenciaMaquinasPrendidas=" + secuenciaMaquinasPrendidas +
                ", cantPiezasProducidas=" + cantPiezasProducidas +
                '}';
    }
}