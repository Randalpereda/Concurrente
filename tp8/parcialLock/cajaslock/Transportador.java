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
public class Transportador implements Runnable {

    private Almacen almacen;

    public Transportador(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (true) {
            try {
                
                almacen.repartirCajas();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        }
    }
}