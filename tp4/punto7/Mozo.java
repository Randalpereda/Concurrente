/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.punto7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Randal
 */
public class Mozo implements Runnable {

    private Confiteria silla;

    public Mozo(Confiteria silla) {

        this.silla = silla;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("....... mozo inventando pollos.......");
                
                silla.pideBebida();

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Mozo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
