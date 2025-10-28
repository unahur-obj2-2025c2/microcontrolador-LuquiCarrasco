package ar.unahur.edu.obj2.patroncommand.funciones;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class StrAddr extends Comando {
    private Integer addr;
    
    public StrAddr(Integer addr) {
        this.addr = addr;
    }

    @Override
    protected void doExecute(Programable micro) {
        micro.setAddr(addr);
    }

}
