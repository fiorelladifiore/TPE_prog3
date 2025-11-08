import java.util.*;

public class Estado {

    public int piezasCreadas;
    public List<String> secuenciaMaquinasPrendidas; // ej [m1 = 0, m2= 2. m3= 4, m5=0]
    public int maquinasPrendidas;

    public Estado(int cantMaquinasEncendidas, int piezasCreadas, List<String> secuenciaMaquinasPrendidas) {
        this.piezasCreadas = piezasCreadas;
        this.secuenciaMaquinasPrendidas = secuenciaMaquinasPrendidas;
    }

    public void prender(Maquina m){
        secuenciaMaquinasPrendidas.add(m.getNombre()); // agregue esta linea para que agregue el nombre de la maq a la secuencia
        piezasCreadas = piezasCreadas + m.getCapacidad();
        maquinasPrendidas ++;
    }

    public void apagar(Maquina m){
        secuenciaMaquinasPrendidas.remove(m.getNombre());
        piezasCreadas = piezasCreadas - m.getCapacidad();
        maquinasPrendidas --;
    }
}
