/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.punto4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Randal
 */
public class Productor implements Runnable{
  
    private final Almacen almacen;
    
    public Productor(Almacen almacen) {
        this.almacen=almacen;
}
    
    
    public void run(){
          while (true) {
            try {
               
                Thread.sleep(2000);
                if (almacen.puedeColocar()) {
                    
                    colocandoProducto();
                   
                } else {
                   almacen.esperaProductor();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
     public void colocandoProducto() throws InterruptedException {
        
        
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + ": termino de comer");
    }
}
