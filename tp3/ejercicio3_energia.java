/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

/**
 *
 * @author Randal
 */
public class ejercicio3_energia {
    
    public static void main(String[] args) {
        EnergiaCompartida energiaCompartida = new EnergiaCompartida(20);
        Thread criaturaOscuraThread = new Thread(new CriaturaOscura(energiaCompartida));
        Thread sanadorThread = new Thread(new Sanador(energiaCompartida));

        criaturaOscuraThread.start();
        sanadorThread.start();
    }
}
    class EnergiaCompartida {
    private int energia;

    public EnergiaCompartida(int energiaInicial) {
        this.energia = energiaInicial;
    }
    
    public synchronized void drenarEnergia(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva.");
        }
        if (energia >= cantidad) {
            energia -= cantidad;
            System.out.println("Criatura Oscura drena " + cantidad + " unidades de Energía. Energía restante: " + energia);
        } else {
            System.out.println("No hay suficiente energía para drenar.");
        }
    }

    public synchronized void revitalizarEnergia(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva.");
        }
        energia += cantidad;
        System.out.println("Sanador revitaliza " + cantidad + " unidades de Energía. Energía restante: " + energia);
    }

    public int obtenerEnergia() {
        return energia;
    }
}

     class CriaturaOscura implements Runnable {
        private final EnergiaCompartida energiaCompartida;

        public CriaturaOscura(EnergiaCompartida energiaCompartida) {
            this.energiaCompartida = energiaCompartida;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                energiaCompartida.drenarEnergia(3);
                try {
                    Thread.sleep(100); // Simulamos un tiempo de procesamiento
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

     class Sanador implements Runnable {
        private final EnergiaCompartida energiaCompartida;

        public Sanador(EnergiaCompartida energiaCompartida) {
            this.energiaCompartida = energiaCompartida;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                energiaCompartida.revitalizarEnergia(3);
                try {
                    Thread.sleep(100); // Simulamos un tiempo de procesamiento
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    

