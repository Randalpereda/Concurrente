/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.canibalSemaforo;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Randal
 */
public class Olla1 {

    private int racion;
    private Semaphore olla;
    private Semaphore cocinero;
    private Semaphore canibal;

    public Olla1(int r) {
        olla = new Semaphore(1);
        cocinero = new Semaphore(0);
        canibal = new Semaphore(r);

        racion = r;

    }

    public void comer() throws InterruptedException {

        try {
            olla.acquire();
            if (racion == 0) {
                System.out.println(Thread.currentThread().getName() + " esperando que llenen la olla ");
                cocinero.release();
            }
            canibal.acquire();

            racion--;
            System.out.println(Thread.currentThread().getName() + " comio una porcion, quedan: " + racion);
            olla.release();
        } catch (InterruptedException ex) {
        }

    }

    public void cocinar() throws InterruptedException {
        try {
            cocinero.acquire();
            racion = 5;
            System.out.println(" Cocinando piolon " + racion);
            canibal.release(5);
        } catch (InterruptedException ex) {
        }

    }

}
