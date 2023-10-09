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
import java.util.Random;

class Corredor extends Thread {
    private String nombre;
    private int distanciaRecorrida;

    public Corredor(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
    }
public String getNombre(){
return nombre;
}
    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    @Override
    public void run() {
        while (distanciaRecorrida < 100) {
            int distanciaAvanzada = new Random().nextInt(10) + 1;
            distanciaRecorrida += distanciaAvanzada;
            System.out.println(nombre + " ha recorrido " + distanciaRecorrida + " metros.");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre + " ha terminado la carrera!");
    }
}

