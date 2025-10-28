package ar.unahur.edu.obj2.patroncommand.invoker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Microcontrolador;
import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;
import ar.unahur.edu.obj2.patroncommand.funciones.*;

public class ProgramaTest {
    private Programa p = new Programa();
    private Programable micro = new Microcontrolador();

    @BeforeEach
    void setUp(){
        p.vaciarLista();
        micro.reset();
    }

    @Test
    void hacerAvanzar3PosicionesElProgramCounter(){
        Integer cantidadDePosiciones = 3; 
        for (int i = 0; i < cantidadDePosiciones; i++) {
            p.agregarNop();
        }

        p.run(micro);

        assertEquals(cantidadDePosiciones, micro.getProgramCounter());
    }

    @Test 
    void sumar20Mas17(){
        p.agregarLodv(20);
        p.agregarSwap();
        p.agregarLodv(17);
        p.agregarAdd();

        p.run(micro);

        assertEquals(37, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        assertEquals(4, micro.getProgramCounter()); 
    } 

    @Test 
    void sumar2Mas8Mas5(){
        p.agregarLodv(2);
        p.agregarStr(0);
        p.agregarLodv(8);
        p.agregarSwap();
        p.agregarLodv(5);
        p.agregarAdd();
        p.agregarSwap();
        p.agregarLod(0);
        p.agregarAdd();

        p.run(micro);

        assertEquals(15, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
    }

    @Test
    void utilizarComnadoIFNZ(){
        List<Operable> inst = new ArrayList<>();
        inst.add(new Add());
        inst.add(new Swap());
        inst.add(new Nop());
        p.agregarLodv(2);
        p.agregarIfnz(inst);
        p.run(micro);


        assertEquals(2, p.instrucciones.size());
        assertEquals(2, micro.getAcumuladorB());
        assertEquals(5, micro.getProgramCounter());
    }

    @Test
    void utilizarComnadoWhnz(){
        List<Operable> inst = new ArrayList<>();
        inst.add(new Add());
        inst.add(new Swap());
        inst.add(new Nop());
        p.agregarLodv(2);
        p.agregarWhnz(inst);
        p.run(micro);

        assertEquals(2, p.instrucciones.size());
        assertEquals(2, micro.getAcumuladorB());
        assertEquals(5, micro.getProgramCounter());
    }
}

