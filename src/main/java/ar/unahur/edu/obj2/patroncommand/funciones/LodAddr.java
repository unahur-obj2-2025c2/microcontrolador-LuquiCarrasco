package ar.unahur.edu.obj2.patroncommand.funciones;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class LodAddr extends Comando {
    private Integer addr;
    
    public LodAddr(Integer addr) {
        this.addr = addr;
    }

    @Override
    protected void doExecute(Programable micro) {
        micro.setAcumuladorA(micro.getAddr(addr));
    }

}
