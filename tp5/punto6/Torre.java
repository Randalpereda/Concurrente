/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.punto6;

/**
 *
 * @author Randal
 */
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Torre {

    private Semaphore pista;
    private Semaphore aterrisajes;
    private int cant;

    public Torre() {
        pista = new Semaphore(1);
       
        cant=0;
    }

    public synchronized boolean puedoAterrizar() {

        boolean pudoAcceder = pista.tryAcquire();
        notifyAll();
        return pudoAcceder;
    }

    public  void aterrizando() throws InterruptedException {
        
        cant++;
        System.out.println(Thread.currentThread().getName() + ": aterrizando  en la pista");
        Thread.sleep(5000);
        System.out.println("--------pista libre--------");
        pista.release();

    }

    public void despegar() throws InterruptedException {
        boolean despego = false;
        while (!despego) {

            if (cant == 5 && pista.tryAcquire()) {

                System.out.println(Thread.currentThread().getName() + ": despegando  en la pista");
                Thread.sleep(5000);
                System.out.println("--------pista libre--------");
                 cant=0;
                pista.release();
               
                despego = true;
            }
        }
    }

}
