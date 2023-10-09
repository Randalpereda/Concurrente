/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc;

/**
 *
 * @author Randal
 */
public class CarreraMultithread {
    public static void main(String[] args) {
        Corredor corredor1 = new Corredor("Corredor 1");
        Corredor corredor2 = new Corredor("Corredor 2");
        Corredor corredor3 = new Corredor("Corredor 3");

        corredor1.start();
        corredor2.start();
        corredor3.start();

        try {
            corredor1.join();
            corredor2.join();
            corredor3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Determinar el corredor que hizo la mayor distancia
        Corredor ganador = corredor1;
        for (Corredor corredor : new Corredor[]{corredor2, corredor3}) {
            if (corredor.getDistanciaRecorrida() > ganador.getDistanciaRecorrida()) {
                ganador = corredor;
            }
        }

        System.out.println("La carrera ha terminado.");
        System.out.println("El corredor ganador es " + ganador.getNombre() + " con una distancia de " + ganador.getDistanciaRecorrida() + " metros.");
    }
}

