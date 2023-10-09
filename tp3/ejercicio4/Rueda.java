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
public class Rueda {

	public synchronized void realizarActividad() {
		System.out.println(Thread.currentThread().getName() + " esta jugando con la RUEDA");
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " termino de jugar con la RUEDA ");
		} catch (InterruptedException e) {

		}
	}

}