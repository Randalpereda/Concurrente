/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.punto2;

/**
 *
 * @author Randal
 */
public class mainSalaEstudio {
    
    public static void main(String[] args) {

		Sala mesa = new Sala();

		Thread[] estudiante = new Thread[10];

		for (int i = 0; i < estudiante.length; i++) {
			estudiante[i] = new Thread(new Estudiante(mesa), "Estudiante " + (i + 1));
		}

        for (Thread estudiante1 : estudiante) {
            estudiante1.start();
        }
	}
}
