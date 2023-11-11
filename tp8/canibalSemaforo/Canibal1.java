/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.canibalSemaforo;

import tp8.canibalLock.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Randal
 */
public class Canibal1 implements Runnable {

    private final Olla1 olla;

    public Canibal1(Olla1 o) {
        olla = o;
    }

    @Override
    public void run() {
        boolean comio = true;
        while (comio) {
            llegandoaComer();
            try {
                olla.comer();
                comio = false;

            } catch (InterruptedException ex) {
                Logger.getLogger(Canibal1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void llegandoaComer() {
        try {
            int llegando = (int) (Math.random() * 10);
            Thread.sleep(llegando * 3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Canibal1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
