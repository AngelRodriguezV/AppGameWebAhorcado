/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author veneg
 */
public class Palabra {
    private ArrayList<String> palabras;
    
    public Palabra() {
        palabras = new ArrayList<String>();
        String linea = "TEC,ITO,OAXACA,PATRONES,JAVA,GIT,DOCKER,MICROPROCESADOR,SOFTWARE,HARDWARE\n" +
"ALGORITMO,PROGRAMACION,CRIPTOGRAFIA,REDES,INTERNET,SEGURIDAD,BASEDEDATOS\n" +
"SISTEMAOPERATIVO,VIRTUALIZACION,MULTIMEDIA,INTERFAZ,ENCODIFICACION,DECODIFICACION\n" +
"CONTROLADOR,COMPRESION,DECOMRESION,MEMORIA,CACHE,KERNEL,NUBE,SERVIDOR,CLIENTE\n" +
"FIREWALL,ENRUTADOR,SWITCH,PUERTO,SOCKET,PROCESAMIENTO,GRAFICOS,AUDIO,VIDEO\n" +
"ENTRADA,SALIDA,PERIFERICOS,USB,BLUETOOTH,WIFI,ETHERNET,TCP,IP,DNS,HTTP,HTTPS\n" +
"SSL,TLS,ARP,ICMP,VPN";
        palabras.addAll(Arrays.asList(linea.split("[,\\n]")));
        
    }
    
    public String getPalabra() {
        Random rand = new Random();
        int indice = (int)rand.nextInt(palabras.size());
        return palabras.get(indice);
    }
}
