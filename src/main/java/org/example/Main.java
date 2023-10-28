package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Número de corredores: ");
        int numCorredores = scanner.nextInt();

        Corredor[] corredores = new Corredor[numCorredores];

        for (int i = 0; i < numCorredores; i++) { // Crear corredores
            System.out.println("Datos del corredor " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = scanner.next();
            System.out.print("Símbolo: ");
            char simbolo = scanner.next().charAt(0);
            System.out.print("Velocidad base (1-5): ");
            int velocidadBase = scanner.nextInt();
            System.out.print("Turbo (1-5): ");
            int turbo = scanner.nextInt();
            System.out.print("Evasión (1-5): ");
            int evasión = scanner.nextInt();

            corredores[i] = new Corredor(nombre, simbolo, velocidadBase, turbo, evasión);
        }

        System.out.println("¡Comienza la carrera!");

        for (Corredor corredor : corredores) { // Iniciar corredores
            corredor.start();
        }

        try {
            for (Corredor corredor : corredores) {
                corredor.join(); // Esperar a que todos los corredores terminen
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("¡Carrera terminada!");
        Corredor ganador = corredores[0]; // Encontrar ganador
        for (Corredor corredor : corredores) {
            if (corredor.getPosición() > ganador.getPosición()) {
                ganador = corredor;
            }
        }
        System.out.println("El ganador es " + ganador.getNombre()); // Mostrar ganador
    }
}
