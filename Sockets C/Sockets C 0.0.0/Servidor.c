#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>

#define PORT 8080
#define BUFFER_SIZE 1024

int main() {
    int sock;
    struct sockaddr_in server_addr;
    char buffer[BUFFER_SIZE];
    
    // Crear el socket
    if ((sock = socket(AF_INET, SOCK_STREAM, 0)) == -1) {
        perror("Error al crear el socket");
        exit(EXIT_FAILURE);
    }

    // Configurar la dirección del servidor
    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(PORT);
    server_addr.sin_addr.s_addr = inet_addr("127.0.0.1");

    // Conectar al servidor
    if (connect(sock, (struct sockaddr *)&server_addr, sizeof(server_addr)) == -1) {
        perror("Error en connect");
        close(sock);
        exit(EXIT_FAILURE);
    }

    printf("Conectado al servidor\n");

    // Enviar un mensaje al servidor
    const char *message = "Hola desde el cliente";
    if (send(sock, message, strlen(message), 0) == -1) {
        perror("Error al enviar mensaje");
        close(sock);
        exit(EXIT_FAILURE);
    }

    // Leer la respuesta del servidor
    ssize_t bytes_received;
    if ((bytes_received = recv(sock, buffer, BUFFER_SIZE, 0)) == -1) {
        perror("Error al recibir mensaje");
        close(sock);
        exit(EXIT_FAILURE);
    }

    buffer[bytes_received] = '\0';  // Asegurarse de que la cadena esté terminada en '\0'
    printf("Respuesta del servidor: %s\n", buffer);

    // Cerrar el socket
    close(sock);

    return 0;
}
