#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>

#define PORT 8080
#define BUFFER_SIZE 1024

int main() {
    int server_fd, client_fd;
    struct sockaddr_in server_addr, client_addr;
    socklen_t client_len = sizeof(client_addr);
    char buffer[BUFFER_SIZE];

    // Crear el socket
    if ((server_fd = socket(AF_INET, SOCK_STREAM, 0)) == -1) {
        perror("Error al crear el socket");
        exit(EXIT_FAILURE);
    }

    // Configurar la dirección del servidor
    server_addr.sin_family = AF_INET;
    server_addr.sin_addr.s_addr = INADDR_ANY;
    server_addr.sin_port = htons(PORT);

    // Enlazar el socket al puerto
    if (bind(server_fd, (struct sockaddr *)&server_addr, sizeof(server_addr)) == -1) {
        perror("Error en bind");
        close(server_fd);
        exit(EXIT_FAILURE);
    }

    // Escuchar conexiones entrantes
    if (listen(server_fd, 3) == -1) {
        perror("Error en listen");
        close(server_fd);
        exit(EXIT_FAILURE);
    }

    printf("Servidor esperando conexiones en el puerto %d...\n", PORT);

    // Aceptar una conexión entrante
    if ((client_fd = accept(server_fd, (struct sockaddr *)&client_addr, &client_len)) == -1) {
        perror("Error en accept");
        close(server_fd);
        exit(EXIT_FAILURE);
    }

    printf("Conexión aceptada de %s:%d\n", inet_ntoa(client_addr.sin_addr), ntohs(client_addr.sin_port));

    // Leer el mensaje del cliente
    ssize_t bytes_read;
    if ((bytes_read = read(client_fd, buffer, BUFFER_SIZE)) == -1) {
        perror("Error al leer del socket");
        close(client_fd);
        close(server_fd);
        exit(EXIT_FAILURE);
    }

    buffer[bytes_read] = '\0';  // Asegurarse de que la cadena esté terminada en '\0'
    printf("Mensaje recibido: %s\n", buffer);

    // Enviar una respuesta al cliente
    const char *response = "Mensaje recibido con éxito.";
    if (send(client_fd, response, strlen(response), 0) == -1) {
        perror("Error al enviar mensaje");
        close(client_fd);
        close(server_fd);
        exit(EXIT_FAILURE);
    }

    // Cerrar los sockets
    close(client_fd);
    close(server_fd);

    return 0;
}
