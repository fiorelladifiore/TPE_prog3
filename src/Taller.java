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
    /**
     * Estrategia para la construcción de piezas:
     * 
     * - Candidatos:
     *      Cada máquina disponible representa un candidato posible para ser
     *      utilizado en la construcción de las piezas.
     * 
     * - Estrategia de selección:
     *      Se ordenan las máquinas en orden descendente según su capacidad de
     *      producción.
     *      Se selecciona primero las máquinas de mayor capacidad, ya que permite
     *      alcanzar el objetivo con la menor cantidad de encendidos posibles.
     * 
     * - Criterio de aceptación:
     *      Mientras la suma de piezas construidas no exceda la cantidad total
     *      requerida, se enciende la máquina actual tantas veces como sea posible.
     *      Luego se continua con la siguiente máquina del listado.
     * 
     * - Consideraciones respecto a encontrar o no solución:
     *      Si la suma total de piezas producidas es exactamente igual a la
     *      requerida, se considera que se encontró una solución posible.
     *      En caso contrario, si no es posible alcanzar exactamente el total
     *      solicitado, no se devuelve solución (retorna null).
     */
    public Solucion construirPiezasGreedy(List<Maquina> maquinasList, int totalPiezas) {
        Collections.sort(maquinasList);

        Estado e = new Estado(0, new ArrayList<>());
        Solucion solucion = new Solucion(Integer.MAX_VALUE, 0, new ArrayList<>(), 0);

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
            if(e.maquinasPrendidas < solucion.getCantMaquinasEncendidas() || solucion.getCantMaquinasEncendidas() == 0){
                solucion.setSolucion(e);
            }
        }
    }
}
