package ar.unahur.edu.obj2.patroncommand.funciones;


import java.util.List;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class Ifnz extends Comando{
    
    private List<Operable> instrucciones;
    
    public Ifnz(List<Operable> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public void agregarFunciones(Operable funcion) {
        instrucciones.add(funcion);
    }

    @Override
    protected void doExecute(Programable micro) {
        if (micro.getAcumuladorA() != 0) {
            micro.run(instrucciones);
        }
    }

}
