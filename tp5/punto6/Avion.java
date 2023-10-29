/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.punto6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Randal
 */
public class Avion implements Runnable {

    private final Torre pista;

    public Avion(Torre pista) {

        this.pista = pista;
    }

    @Override
    public void run() {
        while (true) {
            try {

                Thread.sleep((long) ((Math.random() * 20) * 1000));//llegando al cruce
                if (pista.puedoAterrizar()) {

                    pista.aterrizando();
                    Thread.sleep((long) ((Math.random() * 20) * 1000));//tiempo en tierra
                    pista.despegar();
                    Thread.sleep(20000);
                } else {
                    //Si no apudo acceder espera 
                    //System.out.println(Thread.currentThread().getName() + ": no pudo acceder a la pista, se queda esperando");
                    Thread.sleep(5000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Avion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
