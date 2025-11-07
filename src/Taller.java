import java.util.List;

public class Taller {

private Estado estadoMin;

private Estado e;


public Solucion construirPiezas(List<Maquina> maquinasList, int totalPiezas){
    Solucion solu = new Solucion();
    solu.setSecuenciaDeMaquina(estadoMin.secuenciaActual()); //seteamos todos los datos q lleva la solución
    solu.setCantPiezasProducidas(estadoMin.cantPiezas);// tmb podria ser totalPiezas
    solu.setCantEncendidas(estadoMin.cantEncendidas);
    solu.setCosto(estadoMin.costoEstado);

    e = new Estado();

    this.backtracking(0, e, maquinasList, totalPiezas);
    return solu;
}


private void backtracking(Estado e, List<Maquina> maquinasList, int totalPiezas){
    if(e.getTotalPiezasActual() > totalPiezas){ //explore todo el arbol?
        if (e.getTotalPiezasActuales().equals(totalPiezas)) {//es solucion?
            if(e.cantEncendidasActual() < estadoMin.cantEncendidasActual()){
                cantEncendidosMin = e.cantEncendidasActual();

            }
        }
        return;
    }else{
        //recorrer
        Maquina m = maquinasList.get(e.indice());
        aplicar(maquinasList)// aumemtar el indice
        this.backtracking(e, maquinasList, totalPiezas);

    }


}

// alternativa con indice
private void backtrackingConIndice(int index, List<Maquina> maquinasList, int totalPiezas){
    if(index == maquinasList.size()){
        if(// chequeo de estados){
        // seteo de estado minimo
    }else{
        Maquina aux = maquinasList.get(index);

        e.aplicar(aux, totalPiezas);

        backtrackingConIndice(index + 1, maquinasList, totalPiezas);

        e.remove(aux);
    }
}



}
