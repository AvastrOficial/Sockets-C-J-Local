import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Crear un socket y conectarse al servidor en la IP 127.0.0.1 y puerto 8080
            Socket socket = new Socket("127.0.0.1", 8080);
            System.out.println("Conectado al servidor Correctamente");

            // Crear flujo de entrada y salida para enviar y recibir mensajes
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Enviar un mensaje al servidor
            String message = "Hola desde el cliente Bsz";
            output.println(message); // Enviar mensaje al servidor

            // Leer la respuesta del servidor
            String serverResponse = input.readLine();
            System.out.println("Respuesta del servidor: " + serverResponse);

            // Cerrar la conexión
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
