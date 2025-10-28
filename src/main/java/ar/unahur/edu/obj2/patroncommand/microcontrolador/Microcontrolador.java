package ar.unahur.edu.obj2.patroncommand.microcontrolador;


import java.util.Arrays;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.exception.ExceptionFueraDeRango;
import ar.unahur.edu.obj2.patroncommand.funciones.Operable;


public class Microcontrolador implements Programable {
    private Integer acumuladorA;
    private Integer acumuladorB;
    private Integer programCounter;
    private List<Integer> memoriaDatos = Arrays.asList(new Integer[1024]);

    

    public Microcontrolador() {
        this.reset();
    }

    @Override
    public void run(List<Operable> operaciones) {
        operaciones.forEach(o -> o.execute(this));
    }

    @Override
    public void incProgramCounter() {
        programCounter += 1;
    }

    @Override
    public Integer getProgramCounter() {
        return programCounter;
    }

    @Override
    public void setAcumuladorA(Integer value) {
        acumuladorA = value;
    }

    @Override
    public Integer getAcumuladorA() {
        return acumuladorA;
    }

    @Override
    public void setAcumuladorB(Integer value) {
        acumuladorB = value;
    }

    @Override
    public Integer getAcumuladorB() {
        return acumuladorB;
    }

    @Override
    public void setAddr(Integer addr) {

        memoriaDatos.set(addr, acumuladorA);
    }

    @Override
    public Integer getAddr(Integer addr) {
        return memoriaDatos.get(addr);
    }

    @Override
    public void reset() {
        acumuladorA = 0;
        acumuladorB = 0;
        programCounter = 0;
        memoriaDatos = Arrays.asList(new Integer[1024]);
    }

    public void chequearRango(Integer addr){
        if (addr < 0 || addr >= 1024){
            throw new ExceptionFueraDeRango("El valor esta fuera de Rango");
        }
    }

    @Override
    public Programable copiar() {
        Microcontrolador nuevo = new Microcontrolador();
        nuevo.acumuladorA = this.acumuladorA;
        nuevo.acumuladorB = this.acumuladorB;
        nuevo.programCounter = this.programCounter;
        return nuevo;
    }

    @Override
    public void copiarDesde(Programable programable) {
        programCounter = programable.getProgramCounter();
        acumuladorA = programable.getAcumuladorA();
        acumuladorB = programable.getAcumuladorB();
    }


}
