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
public class Empaquetador implements Runnable{
    private Fabrica fabrica;
    public Empaquetador(Fabrica F){
        fabrica=F;
    }
    

    public void run (){
        while(true){
            try {
                fabrica.sacarCaja();
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}