package org.Tortugas.server;

import org.Tortugas.model.Ardilla;
import org.Tortugas.model.Poema;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT = 8081;
    private static final int MAX_CLIENTS = 100;

    // Lista para mantener un seguimiento de las conexiones de los clientes (Ardillas)
    static List<Ardilla> ardillasConectadas = new ArrayList<>();

    // Mapa que mantiene un seguimiento de las conexiones de los clientes (Ardillas) y sus respectivos ObjectOutputStream
    static Map<Ardilla, ObjectOutputStream> clientes = new HashMap<>();

    // ExecutorService gestiona un conjunto de hilos para manejar las conexiones de los clientes
    static ExecutorService pool = Executors.newFixedThreadPool(MAX_CLIENTS);

    public static void main(String[] args) {
        System.out.println("Servidor de Ardillas Atómicas está en ejecución...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                // Acepta nuevas conexiones de clientes y las delega a un nuevo hilo de ManejadorCliente
                pool.execute(new ManejadorCliente(serverSocket.accept()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Clase interna que maneja la conexión con un cliente individual
    static class ManejadorCliente implements Runnable {
        private Socket socket;

        ManejadorCliente(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Establece un ObjectOutputStream para enviar datos al cliente
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                // Crea una nueva Ardilla y la agrega al mapa de clientes
                Ardilla ardilla = new Ardilla();
                ardillasConectadas.add(ardilla); // Agrega la ardilla a la lista de ardillas conectadas
                clientes.put(ardilla, outputStream);

                // Mostrar mensaje cuando una ardilla se conecta
                System.out.println("Ardilla conectada: " + ardilla);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
