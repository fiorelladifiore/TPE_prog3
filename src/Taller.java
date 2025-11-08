import java.util.*;

public class Taller {

    private Estado e;
    private Solucion solucion;

    public Solucion construirPiezas(List<Maquina> maquinasList, int totalPiezasAConstruir){
        e = new Estado(0,  new LinkedList<Maquina>());
        solucion = new Solucion(Integer.MAX_VALUE, 0, new LinkedList<>());
        backtracking(e, maquinasList, totalPiezasAConstruir);
        System.out.println(solucion.getCantMaquinasEncendidas());
        // si no hay solcion devolver nulo.
        return solucion;
    }

    private void backtracking(Estado e, List<Maquina> maquinasList, int totalPiezas){
        if(e.piezasCreadas == totalPiezas){
            if (e.maquinasPrendidas < solucion.getCantMaquinasEncendidas()){
                solucion.setSolucion(e);
            }
        }else{
            // La poda
            for (Maquina m : maquinasList) {
                e.prender(m);
                if (!poda(e, totalPiezas)){
                    backtracking(e, maquinasList, totalPiezas);
                }
                e.apagar(m);
            }
        }
    }
    
    private boolean poda(Estado e, int totalPiezas){
        return e.piezasCreadas > totalPiezas;
    }

    /** GREEDY -------------------------------------------------------------------------------------------- */
    public Solucion construirPiezasGreedy(List<Maquina> maquinasList, int totalPiezas){
        Collections.sort(maquinasList);
        
        e = new Estado(0, new ArrayList<>());
        solucion = new Solucion(0, 0, new ArrayList<>());

        if(!maquinasList.isEmpty() && totalPiezas > 0){
            greedy(e, maquinasList, totalPiezas);
        }

        return solucion;
    }

    private void greedy(Estado e, List<Maquina> maquinasList, int totalPiezas){
        for(Maquina m : maquinasList){
            while(e.piezasCreadas < totalPiezas){
                e.prender(m);
            }
        }
        
        if(e.piezasCreadas == totalPiezas){
            if(e.maquinasPrendidas < solucion.getCantMaquinasEncendidas()){
                solucion.setSolucion(e);
            }
        }
    }
}
