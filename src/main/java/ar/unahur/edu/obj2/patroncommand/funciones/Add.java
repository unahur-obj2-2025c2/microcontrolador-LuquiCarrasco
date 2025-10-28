package ar.unahur.edu.obj2.patroncommand.funciones;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class Add extends Comando {

    @Override
    protected void doExecute(Programable micro) {
      Integer valor = micro.getAcumuladorA() + micro.getAcumuladorB();
      micro.setAcumuladorA(valor);
      micro.setAcumuladorB(0);
    }

}
