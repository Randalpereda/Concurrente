/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.punto1;

/**
 *
 * @author Randal
 */

public class SynchronizedCounter {
    
    
private int c = 0;
public synchronized void increment() {c++;}
public void decrement() {c--;}
public synchronized int value() {return c;}
}
