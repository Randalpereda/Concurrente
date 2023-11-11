package tp8.canibalSemaforo;
import java.util.logging.Level;
import java.util.logging.Logger;
import tp8.canibalSemaforo.Olla1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 *
 * @author Randal
 */
public class Cocinero1 implements Runnable  {
     private final Olla1 olla;
    
    public Cocinero1(Olla1 o){
    olla=o;
        }





    
    
     @Override
 public void run(){
   while(true){
     try{
        olla.cocinar();
        
    } catch(InterruptedException ex){
        Logger.getLogger(Cocinero1.class.getName()).log(Level.SEVERE, null, ex);
    }
}       
} 
}
