/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejercicio4;

/**
 *
 * @author Randal
 */
public class Plato {
public synchronized void realizarActividad() {
		System.out.println(Thread.currentThread().getName() + " esta usando el plato de COMIDA");
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " termino de usar el plato de COMIDA");
		} catch (InterruptedException e) {

		}
	}

}