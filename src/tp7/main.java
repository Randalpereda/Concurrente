/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp7;

/**
 *
 * @author randal.pereda
 */
public class main {

    public static void main(String[] args) {
        Gestor gestor = new Gestor();

        Medidor medi = new Medidor(gestor);

        Thread medidor = new Thread(medi);
        
        int cantVisitante = 20;
        Thread[] visitantes = new Thread[cantVisitante];

       for (int i = 0; i < (cantVisitante / 2); i++) {
            visitantes[i] = new Thread(new Visitante(gestor, false), VERDE + "Visitante " + i);
        }

        for (int i = (cantVisitante / 2); i < cantVisitante; i++) {
            visitantes[i] = new Thread(new Visitante(gestor, true), AZUL + "Jubilado " + i);
        }

        medidor.start();
        for (int i = 0; i < cantVisitante; i++) {
            visitantes[i].start();
        }
    }

    public static final String AZUL = "\u001B[33m";
    public static final String VERDE = "\u001B[32m";
}