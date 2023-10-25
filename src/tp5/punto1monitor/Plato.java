/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.punto1monitor;

/**
 *
 * @author randal.pereda
 */


public class Plato {

    private int cantidad;
    private int comiendo;

    public Plato(int maximo) {
        cantidad = maximo;
        comiendo = 0;
    }

    Plato() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public synchronized void empezarAComer(String nombre) {
        try {
            while (comiendo >= 3) {
                System.out.println(nombre + "debe esperar para comer");
                this.wait();
            }
        } catch (InterruptedException ex) {        }
        System.out.println(nombre + " empieza a comer");
        comiendo++;
    }

    public synchronized void terminarDeComer(String nombre) {
        System.out.println(nombre + " termino de comer");
        comiendo--;
        this.notify();
    }
}
