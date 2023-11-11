/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.canibalLock;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Randal
 */
public class Cocinero implements Runnable  {
     private Olla olla;
    
    public Cocinero(Olla o){
    olla=o;
        }





    
    
     @Override
 public void run(){
   while(true){
     try{
        olla.cocinar();
        
    } catch(InterruptedException ex){
        Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
    }
}       
} 
}
