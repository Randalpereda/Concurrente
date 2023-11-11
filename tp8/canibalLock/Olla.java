/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.canibalLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Randal
 */
public class Olla {
  
    private int racion;
    private Lock accesoOlla;
    private Condition esperarCanibal;
    private Condition esperarCocinar;

    
    public Olla( int r){
   
    racion=r;
    accesoOlla=new ReentrantLock(true);
    esperarCanibal=accesoOlla.newCondition();
    esperarCocinar=accesoOlla.newCondition();
    }
    
    public void comer() throws InterruptedException{
    
         try {
             accesoOlla.lock();
            while(racion==0){
                 System.out.println(Thread.currentThread().getName() + " esperando que llenen la olla ");
                esperarCocinar.signal();
                esperarCanibal.await();
                
            }
             
            racion--;
            System.out.println(Thread.currentThread().getName() + " comio una porcion, quedan: " + racion);
         }catch(InterruptedException ex){ }
            
         finally {
            accesoOlla.unlock();
        }
    }
    public void cocinar() throws InterruptedException{
     try {
             accesoOlla.lock();
            while(racion>0){
              
                System.out.println( "Cocinero trakeleto " );   
                esperarCocinar.await();
                
                
            }
            
            racion=5;
            System.out.println( " Cocinando piolon " + racion);
            esperarCanibal.signalAll();
                    }catch(InterruptedException ex){ }
            
         finally {
            accesoOlla.unlock();
        }
    }
    

}
    

