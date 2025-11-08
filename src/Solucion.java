import java.util.*;

public class Solucion {

    private List<Maquina> secuenciaMaquinasPrendidas;
    private int cantPiezasProducidas;
    private int cantMaquinasEncendidas;

    public Solucion(int cantMaquinasEncendidas, int cantPiezasProducidas, List<Maquina> secuenciaMaquinasPrendidas) {
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

    public String getNombresMaquinasPrendidas() {
        return secuenciaMaquinasPrendidas.toString();
    }

    public void setSecuenciaMaquinasPrendidas(List<Maquina> secuenciaMaquinasPrendidas) {

        this.secuenciaMaquinasPrendidas = new LinkedList<>(secuenciaMaquinasPrendidas);
    }

    @Override
    public String toString() {
        return "Solucion{" +
                "cantMaquinasEncendidas=" + cantMaquinasEncendidas +
                ", secuenciaMaquinasPrendidas=" + getNombresMaquinasPrendidas()+
                ", cantPiezasProducidas=" + cantPiezasProducidas +
                '}';
    }
}
