/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.canibalSemaforo;


/**
 *
 * @author Randal
 */
public class main {
public static void main(String[] args) {
        Olla1 olla1= new Olla1(5);
        
        Thread[] canibal = new Thread[15];
        Thread cocinero= new Thread (new Cocinero1(olla1));
        cocinero.start();
        for (int i = 0; i < 15; i++) {
            canibal[i]= new Thread(new Canibal1(olla1), "Canibal " + (i + 1));
            canibal[i].start();
        }
        
}
}
