package ar.unahur.edu.obj2.patroncommand.funciones;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class Swap extends Comando{

    @Override
    protected void doExecute(Programable micro) {
        Integer valorAuxiliar = micro.getAcumuladorA();
        micro.setAcumuladorA(micro.getAcumuladorB());
        micro.setAcumuladorB(valorAuxiliar);
    }

}
