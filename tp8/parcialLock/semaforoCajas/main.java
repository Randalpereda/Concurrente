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
public class main {
    public static void main(String[] args) {
        Fabrica fabrica= new Fabrica();
        Thread empaquetador = new Thread(new Empaquetador(fabrica));
        Thread transporte = new Thread (new Transporte(fabrica));
        Thread[] embotelladores = new Thread[40];
        empaquetador.start();
        transporte.start();
        for(int i=0; i<40;i++){
            embotelladores[i]= new Thread (new embotellador(fabrica,i));
            embotelladores[i].start();
        }  
    }  
}