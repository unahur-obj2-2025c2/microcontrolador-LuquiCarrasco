package ar.unahur.edu.obj2.patroncommand.funciones;

import java.util.ArrayList;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class Whnz extends Comando{
     private List<Operable> instrucciones = new ArrayList<>();
    
    public Whnz(List<Operable> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public void agregarFunciones(Operable funcion) {
        instrucciones.add(funcion);
    }

    @Override
    protected void doExecute(Programable micro) {
       while (micro.getAcumuladorA() != 0) {
            micro.run(instrucciones);
        }
    }
}
