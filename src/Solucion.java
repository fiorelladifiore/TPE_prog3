import java.util.*;

public class Solucion {

    private List<Integer> secuenciaMaquinasPrendidas;
    private int cantPiezasProducidas;
    private int cantMaquinasEncendidas;

    public Solucion(int cantMaquinasEncendidas, int cantPiezasProducidas, List<Integer> secuenciaMaquinasPrendidas) {
        this.cantMaquinasEncendidas = cantMaquinasEncendidas;
        this.cantPiezasProducidas = cantPiezasProducidas;
        this.secuenciaMaquinasPrendidas = secuenciaMaquinasPrendidas;
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

    public List<Integer> getSecuenciaMaquinasPrendidas() {
        return secuenciaMaquinasPrendidas;
    }

    public void setSecuenciaMaquinasPrendidas(List<Integer> secuenciaMaquinasPrendidas) {
        this.secuenciaMaquinasPrendidas = secuenciaMaquinasPrendidas;
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
