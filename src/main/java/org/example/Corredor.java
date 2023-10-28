package org.example;

import java.util.Random;

public class Corredor extends Thread { // Clase que extiende de Thread
    private String nombre;
    private char simbolo;
    private int velocidadNormal;
    private int turbo;
    private int esquivar;
    private int posicion;

    public Corredor(String nombre, char simbolo, int velocidadNormal, int turbo, int esquivar) { // Constructor
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.velocidadNormal = velocidadNormal;
        this.turbo = turbo;
        this.esquivar = esquivar;
        this.posicion = 0;
    }

    @Override
    public void run() { // Método que se ejecuta al iniciar el hilo
        Random rand = new Random();
        while (posicion < 100) {
            int avance = calcularAvance(rand);
            if (avance > 0) {
                posicion += avance;
            }
            System.out.println(nombre + " (" + simbolo + "): " + obtenerCarrera());
            try {
                Thread.sleep(1000); // Simula un segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int calcularAvance(Random rand) { // Método que calcula el avance
        int avance = rand.nextInt(velocidadNormal + 1);
        if (rand.nextInt(5) < turbo) {
            avance *= 2; // Turbo activado
        }
        if (rand.nextInt(5) >= esquivar) {
            avance = 0; // Tropezó
        }
        return avance;
    }

    private String obtenerCarrera() { // Método que devuelve la carrera
        StringBuilder carrera = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            if (i == posicion) {
                carrera.append(simbolo);
            } else {
                carrera.append("_");
            }
        }
        return carrera.toString();
    }

    public int getPosición() {
        return posicion;
    }
    public String getNombre() {
        return nombre;
    }
}





