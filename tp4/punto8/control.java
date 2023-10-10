/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.punto8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Randal
 */
public class control implements Runnable{
    private GestorLinea gestorLinea;
    
    
    
    
    public control(GestorLinea g) {
   
        this.gestorLinea=g;
    }

    @Override
    public void run() {
        try {
                gestorLinea.cambiaLineas();
        } catch (InterruptedException ex) {
            Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //To change body of generated methods, choose Tools | Templates.
    }
}
