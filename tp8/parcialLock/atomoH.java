/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.parcialLock;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Randal
 */
public class atomoH implements Runnable  {
     private Espacio e;
    
    public atomoH(Espacio es){
    e=es;
        }





    
    
     @Override
 public void run(){
   boolean entro=false;
   while(!entro){
     try{
        flotando();
        e.Hlisto();
          entro=true;
    } catch(InterruptedException ex){
        Logger.getLogger(atomoH.class.getName()).log(Level.SEVERE, null, ex);
    }
   }    
}
private void flotando() {
        try {
            System.out.println("flota");
            int llegando = (int) (Math.random() * 10);
            Thread.sleep(llegando * 3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(atomoH.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}