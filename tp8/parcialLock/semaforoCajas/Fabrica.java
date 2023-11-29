/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.parcialLock.semaforoCajas;

import java.util.concurrent.Semaphore;
/**
 *
 * @author Randal
 */
public class Fabrica {
    private Semaphore  empaquetador, transporte,
            mutexVino, mutexAgua, trabarEmbotellador,esperarCaja, esperarEmpaquetador;

    private int cajaVino, cajaAgua, cajasAlmacenadas;
    private char cajaReponer;

    public Fabrica() {
        this.empaquetador = new Semaphore(0);
        this.transporte = new Semaphore(0);
        this.mutexAgua = new Semaphore(1);
        this.mutexVino = new Semaphore(1);
        trabarEmbotellador= new Semaphore(1,true);
        esperarCaja= new Semaphore(0);
        esperarEmpaquetador= new Semaphore(0);
        this.cajaAgua = 0;
        this.cajaVino = 0;
        this.cajasAlmacenadas = 0;
        this.cajaReponer='-';

    }

    public void embotellarAgua() throws InterruptedException {
        mutexAgua.acquire();
        cajaAgua++;
        System.out.println("Se embotello una botella de agua, total: " + cajaAgua);
        if (cajaAgua >= 4) {
            trabarEmbotellador.acquire();
            System.out.println("envio caja de Agua");
            cajaReponer='a';
            empaquetador.release();
            esperarCaja.acquire();
            
        }
        mutexAgua.release();

    }

    public void embotellarVino() throws InterruptedException {
        mutexVino.acquire();
        cajaVino++;
        System.out.println("Se embotello una botella de vino, total: " + cajaVino);
        if (cajaVino >= 4) {
            trabarEmbotellador.acquire();
            System.out.println("envio caja de vino");
            cajaReponer='v';
            empaquetador.release();
            esperarCaja.acquire();
        }
        mutexVino.release();

    }

    public void sacarCaja() throws InterruptedException {
        empaquetador.acquire();
        System.out.println("sacando caja");
        
        System.out.println("caja guardada");
        cajasAlmacenadas++;
        System.out.println("cantidad de cajas en almacen "+ cajasAlmacenadas);
        
        if (cajasAlmacenadas >= 4) {
            transporte.release();
            esperarEmpaquetador.acquire();
        }

        if(cajaReponer=='a'){
            System.out.println("reponer caja de agua");
            cajaAgua=0;
        }else{
            System.out.println("reponer caja de vino");
            cajaVino=0;
        }
        esperarCaja.release();
        trabarEmbotellador.release();

    }



    public void transporte() throws InterruptedException {
        transporte.acquire();
   
        System.out.println("sacando cajas");
        cajasAlmacenadas = 0;
        System.out.println("viaje iniciado");
        esperarEmpaquetador.release();

    }
}