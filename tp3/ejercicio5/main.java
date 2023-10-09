/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejercicio5;

/**
 *
 * @author Randal
 */
public class main {
  public static void main(String[] args) {
      
        Estacion estacion = new Estacion("Neuquen");
        Auto a0 = new Auto("121-797", "Mercedez", "ZF-120", 50, estacion);
        Auto a1 = new Auto("722-797", "Nii-san", "ara-ara", 50, estacion);
        Auto a2 = new Auto("6321-797","Ferrari", "fachesco", 50, estacion);
        Auto a3 = new Auto("44421-797", "Ford", "F-100", 50, estacion);
        Auto a4 = new Auto("2231-797","Chevrolet", "Che-1928", 50, estacion);

        Auto colAutos[] = {a0, a1, a2, a3, a4};
        Thread misHilos[] = new Thread[4];

        for (int i = 0; i < misHilos.length; i++) {
            misHilos[i] = new Thread(colAutos[i]);
        }
        
        for(Thread hilo: misHilos){
            hilo.start();
        }

    }
}
