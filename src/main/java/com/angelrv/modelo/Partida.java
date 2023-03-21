/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.angelrv.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author veneg
 */
public class Partida implements Serializable {
    private String palabra;
    private int intentosFallidos;
    private ArrayList<Character> letrasCorrectas;
    private ArrayList<Character> letrasDisponibles;
    private static final int intentos = 6;
    
    public Partida() {}

    public Partida(String palabra, String diccionario) {
        this.palabra = palabra;
        letrasCorrectas = new ArrayList<Character>();
        letrasDisponibles = new ArrayList<Character>();
        obtenerLetras(diccionario, letrasDisponibles);
        intentosFallidos = 0;
    }

    public Partida(String palabra, int intentosFallidos, String dicCorrectas, String dicDisponibles) {
        this.palabra = palabra;
        this.intentosFallidos = intentosFallidos;
        letrasCorrectas = new ArrayList<Character>();
        letrasDisponibles = new ArrayList<Character>();
        obtenerLetras(dicCorrectas, letrasCorrectas);
        obtenerLetras(dicDisponibles, letrasDisponibles);
    }
    
    
    
    private void obtenerLetras(String cad, ArrayList<Character> lista) {
        char[] letras = cad.toCharArray();
        for (int i = 0; i < letras.length; i++) {
            lista.add(letras[i]);
        }
    }
    
    // Metos para el controlador
    
    public void validarLetra(String letra) {
        boolean acerto = false;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra.charAt(0)) {
                letrasCorrectas.add(letra.charAt(0));
                acerto = true;
                break;
            }
        }
        
        if (acerto == false) {
            intentosFallidos++;
        }
        
        letrasDisponibles.remove((Character)letra.charAt(0));
    }
    
    public boolean quedanIntentos() {
        return intentos == intentosFallidos;
    }
    
    public boolean asertoPalabra() {
        for (int i = 0; i < palabra.length(); i++) {
            if (letrasCorrectas.contains(palabra.charAt(i))) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }
    
    // Funciones para recuperrar datos para la vista
    
    /**
     * 
     * @return La pabra secreta vacia
     */
    public ArrayList<Character> palabraSecreta() {
        ArrayList<Character> secreto = new ArrayList<Character>();
        for (int i = 0; i < palabra.length(); i++) {
            if (letrasCorrectas.contains(palabra.charAt(i))) {
                secreto.add(palabra.charAt(i));  
            }
            else {
                secreto.add('_');
            }
        }
        return secreto;
    }
    
    public ArrayList<Character> getLetrasDisponibles() {
        return letrasDisponibles;
    }
    
    public int getIntentos() {
        return intentos - intentosFallidos;
    }
    
    public int getIntentosFallidos() {
        return intentosFallidos;
    }
    
    public String getPalabra() {
        return palabra;
    }
    
    public String getCadCorrectos() {
        String cad = "";
        for (Character c: letrasCorrectas) {
            cad = cad.concat(c.toString());
        }
        return cad;
    }
    
    public String getCadDisponibles() {
        String cad = "";
        for (Character c: letrasDisponibles) {
            cad = cad.concat(c.toString());
        }
        return cad;
    }
}
