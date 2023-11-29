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
public class Embotellador implements Runnable {

    private int tipo;
    private Almacen almacen;

    public Embotellador(Almacen almacen, int tipo) {
        this.almacen = almacen;
        this.tipo = tipo;
    }

    @Override
    public void run() {
        while (true) {
            try {
               
                almacen.guardarBotella(tipo);
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }

    }
}