/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.canibalLock;

import tp8.canibalLock.Cocinero;
import tp8.canibalLock.Canibal;

/**
 *
 * @author Randal
 */
public class main {
public static void main(String[] args) {
        Olla olla= new Olla(5);
        
        Thread[] canibal = new Thread[15];
        Thread cocinero= new Thread (new Cocinero(olla));
        cocinero.start();
        for (int i = 0; i < 15; i++) {
            canibal[i]= new Thread(new Canibal(olla), "Canibal " + (i + 1));
            canibal[i].start();
        }
        
}
}
