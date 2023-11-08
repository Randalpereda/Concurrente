/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp7;

/**
 *
 * @author randal.pereda
 */
import java.util.logging.Level;
import java.util.logging.Logger;


public class Medidor implements Runnable {

    private Gestor gestor;
    private int temperatura;

    public Medidor(Gestor gestor) {
        this.gestor = gestor;
    }

    public void run() {
        while (true) {
            try {
                temperatura = (int) (Math.random() * (25 - 33 + 1) + 33);//25 temp minima y 33 temperatura max
                System.out.println("---------TEMPERATURA ACTUAL " + temperatura
                        + "--------- MaxPersonas: " + gestor.notificarTemperatura(temperatura));
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}