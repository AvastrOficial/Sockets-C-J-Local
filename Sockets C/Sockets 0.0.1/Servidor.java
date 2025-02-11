
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

            // Crear flujo de entrada y salida para leer y enviar mensajes
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            // Leer el mensaje del cliente
            String message = input.readLine();
            System.out.println("Mensaje recibido del cliente: " + message);

            // Enviar una respuesta al cliente
            String response = "Hola desde el servidor Bsz";
            output.println(response);

            // Cerrar la conexión
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
