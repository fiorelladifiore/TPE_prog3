import java.util.*;

public class Estado {

    private int cantMaquinasEncendidas;
    private int piezasRestantesPorConstruir;
    private List<Integer> secuenciaMaquinasPrendidas; // ej [m1 = 0, m2= 2. m3= 4, m5=0]
    private int indice;


    public Estado(int cantMaquinasEncendidas, int indice, int piezasRestantesPorConstruir, List<Integer> secuenciaMaquinasPrendidas) {
        this.cantMaquinasEncendidas = cantMaquinasEncendidas;
        this.indice = indice;
        this.piezasRestantesPorConstruir = piezasRestantesPorConstruir;
        this.secuenciaMaquinasPrendidas = secuenciaMaquinasPrendidas;
    }

    public int getCantMaquinasEncendidas() {
        return cantMaquinasEncendidas;
    }

    public void setCantMaquinasEncendidas(int cantMaquinasEncendidas) {
        this.cantMaquinasEncendidas = cantMaquinasEncendidas;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public int getPiezasRestantesPorConstruir() {
        return piezasRestantesPorConstruir;
    }

    public void setPiezasRestantesPorConstruir(int piezasRestantesPorConstruir) {
        this.piezasRestantesPorConstruir = piezasRestantesPorConstruir;
    }

    public List<Integer> getSecuenciaMaquinasPrendidas() {
        return secuenciaMaquinasPrendidas;
    }

    public void setSecuenciaMaquinasPrendidas(List<Integer> secuenciaMaquinasPrendidas) {
        this.secuenciaMaquinasPrendidas = secuenciaMaquinasPrendidas;
    }

    // aplica (enciende) la máquina en la posición current indice
    public void prender(Maquina m) {
        cantMaquinasEncendidas++;
        piezasRestantesPorConstruir = getPiezasRestantesPorConstruir() - m.getCapacidad();
        secuenciaMaquinasPrendidas.add(indice);
        indice++; // avanzar al siguiente índice después de decidir
    }

    // deshace la última aplicación (asume que la última añadida corresponde al índice-1)
    public void apagar(Maquina m) {
        cantMaquinasEncendidas --;
        piezasRestantesPorConstruir += m.getCapacidad();
        secuenciaMaquinasPrendidas.remove(secuenciaMaquinasPrendidas.size() - 1);
        indice--;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "cantMaquinasEncendidas=" + cantMaquinasEncendidas +
                ", piezasRestantesPorConstruir=" + piezasRestantesPorConstruir +
                ", secuenciaMaquinasPrendidas=" + secuenciaMaquinasPrendidas +
                ", indice=" + indice +
                '}';
    }
}
