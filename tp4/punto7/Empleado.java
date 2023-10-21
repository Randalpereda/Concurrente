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
public class Empleado implements Runnable {

    private Confiteria silla;

    public Empleado(Confiteria silla) {

        this.silla = silla;
    }

    @Override
    public void run() {
        // libre
        boolean comio = false;

        try {
            
            Thread.sleep((long) ((Math.random() * 20) * 1000));//llegando a la confiteria
            while (!comio) {
               
                if (silla.solicitarSilla()) {
                    int n=(int) (Math.random() * 3) + 1;
                    switch (n) {
                        case 1:
                            silla.llamarMozo();
                            
                            break;
                        case 2:
                            silla.llamarCocinero();
                            break;
                        default:
                            System.out.println("...byc");
                            silla.llamarMozoyCocinero();
                            break;
                    }
                    
                   
                   
                    silla.terminaEmpleado();
                    comio = true;
                } else {
                    System.out.println(Thread.currentThread().getName() + " ''silla ocupada'' espera...");
                    Thread.sleep(15000);
                }
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
