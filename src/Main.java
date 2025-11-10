import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Maquina> maquinas = new ArrayList<Maquina>();
        maquinas.add(new Maquina(7, "M1"));
        maquinas.add(new Maquina(3, "M2"));
        maquinas.add(new Maquina(4, "M3"));
        maquinas.add(new Maquina(1, "M4"));


        int objetivo = 12;

        Taller taller = new Taller();
        //Solucion sol = taller.construirPiezas(maquinas, objetivo);
        //Solucion sol = taller.construirPiezasGreedy(maquinas, objetivo);

        System.out.println(sol.toString());
    }
}