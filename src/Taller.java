import java.util.*;

public class Taller {

    private Estado e;
    private Solucion solucion;

    public Solucion construirPiezas(List<Maquina> maquinasList, int totalPiezasAConstruir){
        e = new Estado(0, 0, totalPiezasAConstruir, new LinkedList<>());
        solucion = new Solucion(9999, 0, new LinkedList<>());
        backtracking(e, maquinasList, totalPiezasAConstruir);
        System.out.println("asd");
        return solucion;
    }

    private void backtracking(Estado e, List<Maquina> maquinasList, int totalPiezas){
        if(e.getIndice() >= maquinasList.size()){ // Ya generé todos los estados posibles.
            if (e.getPiezasRestantesPorConstruir() == 0 && e.getCantMaquinasEncendidas() < solucion.getCantMaquinasEncendidas()) {//es solucion?
                System.out.println("Encontre solucion!!");
                System.out.println(e.getSecuenciaMaquinasPrendidas());
                solucion.setCantMaquinasEncendidas(e.getCantMaquinasEncendidas());
                solucion.setCantPiezasProducidas(totalPiezas);
                //solucion.getSecuenciaMaquinasPrendidas().clear();
                //solucion.setSecuenciaMaquinasPrendidas(e.getSecuenciaMaquinasPrendidas());
            }
        }else{
            int indice = e.getIndice();
            Maquina m = maquinasList.get(indice);

            // La enciendo
            e.prender(m);
            backtracking(e, maquinasList, totalPiezas);
            e.apagar(m);

            // No la enciendo, y avanzo a la siguiente.
            e.setIndice(indice + 1);
            backtracking(e, maquinasList, totalPiezas);
            e.setIndice(indice);
        }
    }

    private boolean construiTodasLasPiezas(int totalPiezas) {
        return totalPiezas <= 0;
    }
}
