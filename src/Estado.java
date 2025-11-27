import java.util.*;

public class Estado {

    public int piezasCreadas;
    public List<Maquina> secuenciaMaquinasPrendidas; // ej [m1 = 0, m2= 2. m3= 4, m5=0]
    public int maquinasPrendidas;
    public int cantidadDeEstados;
    public int indice;

    public Estado(int piezasCreadas, List<Maquina> secuenciaMaquinasPrendidas, int indice) {
        this.piezasCreadas = piezasCreadas;
        this.secuenciaMaquinasPrendidas = secuenciaMaquinasPrendidas;
        this.indice= indice;
        this.cantidadDeEstados = 0;
    }

    public void prender(Maquina m){
        secuenciaMaquinasPrendidas.addLast(m);
        piezasCreadas = piezasCreadas + m.getCapacidad();
        maquinasPrendidas++;
        m.setCantEncendidos(m.getCantEncendidos()+1);
    }

    public int getMaquinasPrendidas() {
        return maquinasPrendidas;
    }

    public void apagar(Maquina m){
        secuenciaMaquinasPrendidas.removeLast();
        piezasCreadas = piezasCreadas - m.getCapacidad();
        maquinasPrendidas--;
        m.setCantEncendidos(m.getCantEncendidos()-1);
    }
}