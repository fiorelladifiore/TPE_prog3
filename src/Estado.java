import java.util.*;

public class Estado {

    public int piezasCreadas;
    public List<Integer> secuenciaMaquinasPrendidas; // ej [m1 = 0, m2= 2. m3= 4, m5=0]
    public int maquinasPrendidas;

    public Estado(int cantMaquinasEncendidas, int indice, int piezasCreadas, List<Integer> secuenciaMaquinasPrendidas) {
        this.piezasCreadas = piezasCreadas;
        this.secuenciaMaquinasPrendidas = secuenciaMaquinasPrendidas;
    }

    public void prender(Maquina m){
        piezasCreadas = piezasCreadas + m.getCapacidad();
        maquinasPrendidas ++;

    }

    public void apagar(Maquina m){
        piezasCreadas = piezasCreadas - m.getCapacidad();
        maquinasPrendidas --;
    }
}
