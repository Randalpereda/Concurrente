/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.parcialLock.semaforoCajas;

/**
 *
 * @author Randal
 */
public class Transporte implements Runnable{
    private Fabrica fabrica;
    public Transporte(Fabrica F){
        fabrica=F;
    }

    public void run (){
        try {
            while(true){
            fabrica.transporte();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}