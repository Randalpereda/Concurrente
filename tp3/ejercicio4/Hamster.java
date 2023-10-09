/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejercicio4;

import tp3.ejercicio4.Hamaca;

/**
 *
 * @author Randal
 */
public class Hamster implements Runnable {

	Rueda r = new Rueda();
	Plato c = new Plato();
	Hamaca h = new Hamaca();

	public Hamster(Rueda r, Hamaca h, Plato c) {
		this.r = r;
		this.h = h;
		this.c = c;

	}

	@Override
	public void run() {
		r.realizarActividad();
		h.realizarActividad();
		c.realizarActividad();

	}

	/*
	 * private Jaula jaula;
	 * 
	 * public Hamster(Jaula jaula) { this.jaula = jaula; }
	 * 
	 * @Override public void run() { while (true) { switch (opcRandom()) { case 1:
	 * jaula.usarHamaca(); break; case 2: jaula.usarRueda(); break; case 3:
	 * jaula.usarPlato(); break; default: break; }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * private int opcRandom() { Random r = new Random(); return r.nextInt(3) + 1; }
	 */

}
