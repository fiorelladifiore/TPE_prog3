import java.util.*;

public class Taller {

    private Estado e;
    private Solucion solucion;


    /*
    Árbol de exploración

                Estado inicial
                      [ ]
                       |
        -----------------------------------------------------------------
        |                       |                      |                |
       [M1]                    [M2]                   [M3]            [M4]  para este ejemplo usamos hasta M4 pero
        |                       |                      |               |     sería la N cantidad de máquinas que haya
      -----------------     ---------                      ...
      |        |           |        |
   [M1, M1] [M1, M2]... [M2, M1] [M2, M2]  ....
       |             .                  .
  [M1, M1, M1]...    .                  .
                     .                  .
                  [M1, M3, M4]       [M2, M2, M3, M4, M4]
                   Estado final       Estado final (total de piezas 12)
                   Estado solucion    Estado solucion (no la mejor)
                   (posible mejor)
*/

    public Solucion construirPiezasBacktracking(List<Maquina> maquinasList, int totalPiezasAConstruir){
        e = new Estado(0,  new LinkedList<Maquina>());
        solucion = new Solucion(Integer.MAX_VALUE, 0, new LinkedList<>(), 0);
        backtracking(e, maquinasList, totalPiezasAConstruir);
        // si no hay solcion devolver nulo.
        return solucion;
    }

    private void backtracking(Estado e, List<Maquina> maquinasList, int totalPiezas){
        e.cantidadDeEstados++;
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
    public Solucion construirPiezasGreedy(List<Maquina> maquinasList, int totalPiezas) {
        Collections.sort(maquinasList);

        e = new Estado(0, new ArrayList<>());
        solucion = new Solucion(Integer.MAX_VALUE, 0, new ArrayList<>(), 0);

        if (!maquinasList.isEmpty() && totalPiezas > 0) {
            greedy(e, maquinasList, totalPiezas);
        }
        if (esSolu(e, totalPiezas)){
            return solucion;
        }else{
            return null;
        }
    }

    private boolean esSolu(Estado e, int totalPiezas) { //si pudo llegar a las piezas requeridas
        return e.piezasCreadas == totalPiezas;
    }

    private void greedy(Estado e, List<Maquina> maquinasList, int totalPiezas){
        for(Maquina m : maquinasList){
            e.cantidadDeEstados++;
            while(e.piezasCreadas + m.getCapacidad() <= totalPiezas){
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
