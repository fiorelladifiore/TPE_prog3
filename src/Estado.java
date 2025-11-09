import java.util.*;

public class Estado {

    public int piezasCreadas;
    public List<Maquina> secuenciaMaquinasPrendidas; // ej [m1 = 0, m2= 2. m3= 4, m5=0]
    public int maquinasPrendidas;

    public Estado(int piezasCreadas, List<Maquina> secuenciaMaquinasPrendidas) {
        this.piezasCreadas = piezasCreadas;
        this.secuenciaMaquinasPrendidas = secuenciaMaquinasPrendidas;
    }

    public void prender(Maquina m){
        secuenciaMaquinasPrendidas.add(m);
        piezasCreadas = piezasCreadas + m.getCapacidad();
        maquinasPrendidas++;
        m.setCantEncendidos(m.getCantEncendidos()+1);
    }

    public void apagar(Maquina m){
        secuenciaMaquinasPrendidas.remove(m);
        piezasCreadas = piezasCreadas - m.getCapacidad();
        maquinasPrendidas--;
        m.setCantEncendidos(m.getCantEncendidos()-1);
    }
}