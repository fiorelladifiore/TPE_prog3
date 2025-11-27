import java.io.*;
import java.util.*;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("config.txt"));
            int total = Integer.parseInt(br.readLine().trim());
            List<Maquina> maquinas = new ArrayList<>();

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                maquinas.add(new Maquina(Integer.parseInt(partes[1].trim()), partes[0].trim()));
            }
            br.close();

            Taller taller = new Taller();

            Solucion solBack1= taller.construirPiezasBacktracking(new ArrayList<>(maquinas), total);
            Solucion solBack2 = taller.construirBacktrackingAdicional(new ArrayList<>(maquinas), total);

            System.out.println("BACKTRACKING");
            if (solBack1 == null) {
                System.out.println("NO HAY SOLUCIÓN");
            } else {
                System.out.println(solBack1);
                System.out.println(" cantidad de estados generados= " + solBack1.getCantidadDeEstados());
            }
            System.out.println();
            System.out.println("BACKTRACKING ADICIONAL");
            if (solBack2 == null) {
                System.out.println("NO HAY SOLUCIÓN");
            } else {
                System.out.println(solBack2);
                System.out.println(" cantidad de estados generados= " + solBack2.getCantidadDeEstados());
            }
            System.out.println();
            Solucion solGreedy1 = taller.construirPiezasGreedy(new ArrayList<>(maquinas), total);
            System.out.println("GREEDY");
            if (solGreedy1 == null) {
                System.out.println("NO HAY SOLUCIÓN");
            } else {
                System.out.println(solGreedy1);
                System.out.println(" cantidad de estados generados= " + solGreedy1.getCantidadDeEstados());
            }
            System.out.println();
            Solucion solGreedy2 = taller.construirGreedyAdicional(new ArrayList<>(maquinas), total);
            System.out.println("GREEDY ADICIONAL");
            if (solGreedy2 == null) {
                System.out.println(" NO HAY SOLUCIÓN");
            } else {
                System.out.println(solGreedy2);
                System.out.println(" cantidad de estados generados= " + solGreedy2.getCantidadDeEstados());
            }

        } catch (Exception e){
            System.out.println(e.getMessage());

        }
    }

