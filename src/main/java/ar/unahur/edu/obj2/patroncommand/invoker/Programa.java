package ar.unahur.edu.obj2.patroncommand.invoker;

import java.util.ArrayList;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.funciones.Add;
import ar.unahur.edu.obj2.patroncommand.funciones.Ifnz;
import ar.unahur.edu.obj2.patroncommand.funciones.LodAddr;
import ar.unahur.edu.obj2.patroncommand.funciones.Lodv;
import ar.unahur.edu.obj2.patroncommand.funciones.Nop;
import ar.unahur.edu.obj2.patroncommand.funciones.Operable;
import ar.unahur.edu.obj2.patroncommand.funciones.StrAddr;
import ar.unahur.edu.obj2.patroncommand.funciones.Swap;
import ar.unahur.edu.obj2.patroncommand.funciones.Whnz;
import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class Programa {
    List<Operable> instrucciones;

    
    public Programa() {
        instrucciones = new ArrayList<>();
    }

    public void agregarNop() {
        instrucciones.add(new Nop());
    }

    public void agregarAdd() {
        instrucciones.add(new Add());
    }

    public void agregarSwap() {
        instrucciones.add(new Swap());
    }

    public void agregarLod(Integer direccionMemoria) {
        instrucciones.add(new LodAddr(direccionMemoria));
    }

    public void agregarStr(Integer direccionMemoria){
        instrucciones.add(new StrAddr(direccionMemoria));
    }

    public void agregarLodv(Integer val) {
        instrucciones.add(new Lodv(val));
    }

    public void vaciarLista(){
        instrucciones.clear();
    }

    public void run(Programable micro){
        micro.run(instrucciones);
    }

    public void agregarIfnz(List<Operable> i) {
        instrucciones.add(new Ifnz(i));
    }

    public void agregarWhnz(List<Operable> i) {
        instrucciones.add( new Whnz(i));
    }
}
