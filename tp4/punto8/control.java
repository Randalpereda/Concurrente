/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.punto8;

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
    public void run() {//"cambio de control2"
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
