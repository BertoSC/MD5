package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {


     if (args.length < 1) {
        System.err.println("Uso: java VerificadorMD5 <ruta-del-archivo>");
        return;
    }

    String rutaArchivo = args[0]; // Obtener la ruta del archivo del argumento de la línea de comandos

    // Crear el comando a ejecutar
    String comando = "certutil -hashfile \"" + "C:\\Users\\VSPC-BLACKFRIDAY\\Desktop\\Otro\\pom.xml" + "\" MD5";

        try {
        // Iniciar el proceso
        Process proceso = Runtime.getRuntime().exec(comando);

        // Obtener el flujo de entrada del proceso
        InputStream flujoEntrada = proceso.getInputStream();
        BufferedReader lector = new BufferedReader(new InputStreamReader(flujoEntrada));

        String linea;
        while ((linea = lector.readLine()) != null) {
            // Imprimir la salida (checksum MD5)
            System.out.println(linea);
        }

        // Esperar a que el proceso se complete
        int codigoSalida = proceso.waitFor();
        if (codigoSalida != 0) {
            System.err.println("El proceso terminó con el código: " + codigoSalida);
        }

    } catch (
    IOException e) {
        System.err.println("Ocurrió una IOException: " + e.getMessage());
    } catch (InterruptedException e) {
        System.err.println("El proceso fue interrumpido: " + e.getMessage());
    }
}
}

