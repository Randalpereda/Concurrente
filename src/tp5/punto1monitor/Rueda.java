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
public class Rueda {
    public synchronized void rodar(String nombre) {
        System.out.println(nombre + " empieza a rodar");
        try {
            Thread.sleep((long) Math.random() * 1500);
        } catch (InterruptedException ex){}
}
    }