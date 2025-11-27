import java.util.*;

public class Taller {

    private Estado e;
    private Solucion solucionBack;
    private Solucion solucionGreedy;


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

    public Solucion construirPiezasBacktracking(List<Maquina> maquinasList, int totalPiezasAConstruir) {
        e = new Estado(0, new LinkedList<Maquina>(), 0);
        solucionBack = new Solucion(Integer.MAX_VALUE, 0, new LinkedList<>(), 0);
        backtracking(e, maquinasList, totalPiezasAConstruir);
        // si no hay solcion devolver nulo.
        if(esSoluBack(solucionBack, totalPiezasAConstruir)) { //si se encontró una solución (si las piezas producidas son igual
            return solucionBack;                               //a la cantidad total
        }else {
            return null;
        }
    }

    private void backtracking(Estado e, List<Maquina> maquinasList, int totalPiezas) {
        e.cantidadDeEstados++;
        if (e.piezasCreadas == totalPiezas) {
            if (e.maquinasPrendidas < solucionBack.getCantMaquinasEncendidas()) {
                solucionBack.setSolucion(e);
            }
        } else {
            for (Maquina m : maquinasList) {
                if (e.piezasCreadas + m.getCapacidad() <= totalPiezas) { //evita pasarse del total piezas un paso antes
                    e.prender(m);
                    if (!poda(e)) { //si las maquinas prendidas de mi estado no son mas que las de mi solucion actual
                        backtracking(e, maquinasList, totalPiezas);
                    }
                    e.apagar(m);
                }
            }
        }
    }


    private boolean poda(Estado e) {

        return e.maquinasPrendidas >= solucionBack.getCantMaquinasEncendidas();
    }

    //BACKTRACKING ADICIONAL
    public Solucion construirBacktrackingAdicional(List<Maquina> maquinasList, int totalPiezas) {
        e = new Estado(0, new LinkedList<Maquina>(), 0);
        e.indice = 0;
        solucionBack = new Solucion(Integer.MAX_VALUE, 0, new LinkedList<>(), 0);
        backtrackingAdicional(e, maquinasList, totalPiezas);
        if(esSoluBack(solucionBack, totalPiezas)) {
            return solucionBack;
        }else {
            return null;
        }
    }

    private boolean esSoluBack(Solucion solu, int totalPiezas) { //si pudo llegar a las piezas requeridas
        return solu.getCantPiezasProducidas() == totalPiezas;
    }

    private void backtrackingAdicional(Estado e, List<Maquina> maquinasList, int totalPiezas) {
        e.cantidadDeEstados++;

        if (e.piezasCreadas == totalPiezas) {
            if (e.maquinasPrendidas < solucionBack.getCantMaquinasEncendidas()) {
                solucionBack.setSolucion(e);
            }
        }else{
            // controlar el índice
            for (int i = e.indice; i < maquinasList.size(); i++) {
                    Maquina m = maquinasList.get(i);
                if (e.piezasCreadas + m.getCapacidad() <= totalPiezas){
                int indiceAnterior = e.indice; //guardo el índice actual
                e.prender(m);
                e.indice = i+ 1; //para no repetir la maquina actual
                if (!poda(e)) {
                    backtrackingAdicional(e, maquinasList, totalPiezas);
                }
                e.apagar(m);
                e.indice = indiceAnterior;
            }
        }
    }
    }



    /** GREEDY -------------------------------------------------------------------------------------------- */
    /**
     * Estrategia para la construcción de piezas:
     * <p>
     * - Candidatos:
     * Cada máquina disponible representa un candidato posible para ser
     * utilizado en la construcción de las piezas.
     * <p>
     * - Estrategia de selección:
     * Se ordenan las máquinas en orden descendente según su capacidad de
     * producción.
     * Se selecciona primero las máquinas de mayor capacidad, ya que permite
     * alcanzar el objetivo con la menor cantidad de encendidos posibles.
     * <p>
     * - Criterio de aceptación:
     * Mientras la suma de piezas construidas no exceda la cantidad total
     * requerida, se enciende la máquina actual tantas veces como sea posible.
     * Luego se continua con la siguiente máquina del listado.
     * <p>
     * - Consideraciones respecto a encontrar o no solución:
     * Si la suma total de piezas producidas es exactamente igual a la
     * requerida, se considera que se encontró una solución posible.
     * En caso contrario, si no es posible alcanzar exactamente el total
     * solicitado, no se devuelve solución (retorna null).
     */
    public Solucion construirPiezasGreedy(List<Maquina> maquinasList, int totalPiezas) {
        Collections.sort(maquinasList);

        Estado e = new Estado(0, new ArrayList<>(), 0);
        solucionGreedy = new Solucion(Integer.MAX_VALUE, 0, new ArrayList<>(), 0);

        if (!maquinasList.isEmpty() && totalPiezas > 0) {
            greedy(e, maquinasList, totalPiezas);
        }
        if (esSolu(e, totalPiezas)) {
            return solucionGreedy;
        } else {
            return null;
        }
    }

    private boolean esSolu(Estado e, int totalPiezas) { //si pudo llegar a las piezas requeridas
        return e.piezasCreadas == totalPiezas;
    }

    private void greedy(Estado e, List<Maquina> maquinasList, int totalPiezas) {
        for (Maquina m : maquinasList) {
            e.cantidadDeEstados++;
            while (e.piezasCreadas + m.getCapacidad() <= totalPiezas) {
                e.prender(m);
            }
            if (esSolu(e, totalPiezas)) {
                solucionGreedy.setSolucion(e);
                break;
            }
        }
    }

    // GREEDY ADICIONAL

    public Solucion construirGreedyAdicional(List<Maquina> maquinasList, int totalPiezas) {
        Collections.sort(maquinasList); //ordenadas por mayor capacidad de piezas

        Estado e = new Estado(0, new ArrayList<>(), 0);
        solucionGreedy = new Solucion(Integer.MAX_VALUE, 0, new ArrayList<>(), 0);

        if (!maquinasList.isEmpty() && totalPiezas > 0) {
            greedyAdicional(e, maquinasList, totalPiezas);
        }
        if (esSolu(e, totalPiezas)) {
            return solucionGreedy;
        } else {
            return null;
        }
    }

    private void greedyAdicional(Estado e, List<Maquina> maquinasList, int totalPiezas) {
        while (!maquinasList.isEmpty()) { //iterar hasta agotar las máquinas o llegar a una solución
            e.cantidadDeEstados++;
            Maquina m = maquinasList.removeFirst(); //la use o no la use, la descarto de candidatos

            if (e.piezasCreadas + m.getCapacidad() <= totalPiezas) {
                e.prender(m);
            }

            if (esSolu(e, totalPiezas)) {
                solucionGreedy.setSolucion(e);
                break;
            }
        }
    }


}











