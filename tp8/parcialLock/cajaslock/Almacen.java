/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.parcialLock.cajaslock;

/**
 *
 * @author Randal
 */
public class Almacen {
    private int capacidad, cajaVino, cajaAgua;

    public Almacen() {
        this.capacidad = 100;
        this.cajaVino = 10;
        this.cajaAgua = 10;
    }

    public synchronized void guardarBotella(int tipo) throws InterruptedException {
        
        if (tipo == 1) {
            while (cajaAgua == 0) {
                System.out.println(Thread.currentThread().getName() + "Caja de agua llena, debe esperar");
                this.wait();
            }
            cajaAgua--;
            System.out.println(Thread.currentThread().getName() + " Preparo botella caja le queda:"+cajaAgua);
        } else {
            while (cajaVino == 0) {
                System.out.println(Thread.currentThread().getName() + "Caja de vino llena, debe esperar");
                this.wait();
            }
            cajaVino--;
            System.out.println(Thread.currentThread().getName() + "Preparo botella de vino caja le queda:"+cajaVino);
        }
        this.notifyAll();
    }

    public synchronized void empaquetarCaja() throws InterruptedException {
        while (cajaAgua != 0 && cajaVino != 0) {
            
            this.wait();
        }
        if (cajaAgua == 0) {
            cajaAgua = -1;
            capacidad = capacidad-10;
            System.out.println(Thread.currentThread().getName() + "  EMPA guardo caja de agua");
        }
        if (cajaVino == 0) {
            cajaVino = -1;
            capacidad =capacidad-10;
            System.out.println(Thread.currentThread().getName() + "EMPA guardo caja de vino");
        }

        this.notifyAll();
    }

    public synchronized void reponerCajas() throws InterruptedException {
        /*while (cajaAgua != -1 && cajaVino != 0) {
            System.out.println(Thread.currentThread().getName() + " esperando que se vacien las cajas");
            this.wait();
        }*/
        if (cajaAgua == -1) {
            cajaAgua = 10;
            System.out.println(Thread.currentThread().getName() + " repuso caja de agua");
        } 
        if (cajaVino == -1) {
                cajaVino = 10;
                System.out.println(Thread.currentThread().getName() + " repuso caja de vino");
            }
    }

    public synchronized void repartirCajas() throws InterruptedException {
        while (capacidad > 0) {
            
            this.wait();
        }
        capacidad = 100;
        System.out.println(Thread.currentThread().getName() + " reparte las cajas");
        this.notifyAll();
    }
}