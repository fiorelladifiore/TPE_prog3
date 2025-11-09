import java.util.*;

public class Solucion {

    private List<Maquina> secuenciaMaquinasPrendidas;
    private int cantPiezasProducidas;
    private int cantMaquinasEncendidas;

    public Solucion(int cantMaquinasEncendidas, int cantPiezasProducidas, List<Maquina> secuenciaMaquinasPrendidas) {
        this.cantMaquinasEncendidas = cantMaquinasEncendidas;
        this.cantPiezasProducidas = cantPiezasProducidas;
        this.secuenciaMaquinasPrendidas = new ArrayList<Maquina>(secuenciaMaquinasPrendidas);
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

    public List<Maquina> getSecuenciaMaquinasPrendidas() {
        return secuenciaMaquinasPrendidas;
    }

    public void setSecuenciaMaquinasPrendidas(List<Maquina> secuenciaMaquinasPrendidas) {
        this.secuenciaMaquinasPrendidas = new LinkedList<Maquina>(secuenciaMaquinasPrendidas);
    }

    public void setSolucion(Estado e){
        this.clearSolucion();
        
        this.secuenciaMaquinasPrendidas = new ArrayList<>(e.secuenciaMaquinasPrendidas);
        this.cantPiezasProducidas = e.piezasCreadas;
        this.cantMaquinasEncendidas = e.maquinasPrendidas;
    }

    private void clearSolucion(){
        this.secuenciaMaquinasPrendidas.clear();
        this.cantPiezasProducidas = 0;
        this.cantMaquinasEncendidas = 0;
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