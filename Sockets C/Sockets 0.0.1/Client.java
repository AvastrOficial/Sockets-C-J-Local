import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Crear un socket y conectarse al servidor en la IP 127.0.0.1 y puerto 8080
            Socket socket = new Socket("127.0.0.1", 8080);
            System.out.println("Conectado al servidor");

            // Crear flujo de entrada y salida para enviar el archivo
            FileInputStream fileInputStream = new FileInputStream("archivo_a_enviar.txt");
            OutputStream outputStream = socket.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;

            // Leer y enviar el archivo al servidor
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Archivo enviado al servidor Bsz");

            // Cerrar flujos y la conexión
            fileInputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
