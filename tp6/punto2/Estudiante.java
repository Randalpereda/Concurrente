/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.punto2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Randal
 */
public class Estudiante implements Runnable{
  
    private final Sala mesa;
    
    public Estudiante(Sala mesa) {
        this.mesa=mesa;
}
    
    
    public void run(){
    try{
        llegando();
        mesa.entrarSala();
        
         estudiando();
         mesa.liberaMesa();
        
    } catch(InterruptedException ex){
        Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
    }
}   
    
     
    
    private void estudiando() {
        try {
            System.out.println(Thread.currentThread().getName() + " esta ESTUDIANDO-------");
            int llegando = (int) (Math.random() * 10);
            Thread.sleep(llegando * 5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void llegando() {
        try {
            int llegando = (int) (Math.random() * 10);
            Thread.sleep(llegando * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
