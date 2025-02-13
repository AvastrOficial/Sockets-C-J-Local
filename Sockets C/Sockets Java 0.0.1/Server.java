import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Crear un servidor que escucha en el puerto 8080
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Servidor escuchando en el puerto 8080...");

            // Aceptar la conexión del cliente
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado desde " + clientSocket.getInetAddress());

            // Crear flujo de entrada y salida para recibir archivo
            InputStream inputStream = clientSocket.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream("archivo_recibido.txt");
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            
            // Leer y guardar el archivo enviado por el cliente
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            
            System.out.println("Archivo recibido y guardado como 'archivo_recibido.txt'");

            // Cerrar flujos y conexión
            fileOutputStream.close();
            inputStream.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
