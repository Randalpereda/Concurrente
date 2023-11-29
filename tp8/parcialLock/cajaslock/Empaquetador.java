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
public class Empaquetador implements Runnable {

    private Almacen almacen;

    public Empaquetador(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (true) {
            try {
               
                almacen.empaquetarCaja();
                Thread.sleep(1000);
                almacen.reponerCajas();
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        }

    }
}