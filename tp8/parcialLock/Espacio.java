/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.parcialLock;

/**
 *
 * @author Randal
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Randal
 */
public class Espacio {
    
    private int recipiente,h,o,k;

    private final Lock accesoO;
    private final Condition esperarH;
    private final Condition esperarO;

    
    public Espacio ( int t){
    h=0;
    o=0;
    k=t;
    recipiente=0;
    
    accesoO=new ReentrantLock(true);
    esperarH=accesoO.newCondition();
    esperarO=accesoO.newCondition();
    }
    public void Olisto() throws InterruptedException{
        
         try {
             accesoO.lock();
             boolean ultimo=true;
             o++;
           
         esperarH.signalAll();
            while(h<2){
                 System.out.println(Thread.currentThread().getName() + " esperando  ");
                ultimo=false;
                esperarO.await();
                
            }
               
            if(ultimo){
           System.out.println(Thread.currentThread().getName() + " Es el Ultimo oxigeno llama hacer agua ");
           hacerAgua();
            }
           
         }catch(InterruptedException ex){ 
         throw ex;}
            
         finally {
            accesoO.unlock();
        }
    }
    
    
    public void Hlisto() throws InterruptedException{
        
         try {
             accesoO.lock();
             boolean ultimo=true;
             h++;
             esperarO.signalAll();
            while(h<2 || o<1){
                 System.out.println(Thread.currentThread().getName() + " esperando  ");
                ultimo=false;
                esperarH.await();
                
            }
             
            if(ultimo){
           System.out.println(Thread.currentThread().getName() + " Es el Ultimo hidrogeno llama hacer agua ");
            hacerAgua();
            }
           
         }catch(InterruptedException ex){
           throw ex;}
            
         finally {
            accesoO.unlock();
        }
    }
    
     public void hacerAgua() throws InterruptedException{
     
         try {
             accesoO.lock();
             System.out.println("haciendo agua");
             
             h=h-2;
             o--;
             System.out.println("h es "+h);
             System.out.println("0 es "+o);
             recipiente++;
             System.out.println("r es "+recipiente);
             Thread.sleep( 3000);
             if(recipiente==k){
                 System.out.println("recipiente 0 envasado +1");
                 recipiente=0;
             }
        }catch(InterruptedException ex){ 
             }
         finally {
              
            accesoO.unlock();
           
        }
     }
    
}