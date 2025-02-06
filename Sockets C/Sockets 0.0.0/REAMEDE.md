0.0.0
# Proyecto de Servidor y Cliente

Este es un proyecto básico que implementa un servidor y un cliente. El servidor escucha conexiones en el puerto 8080 y el cliente se conecta a él para realizar operaciones.

## Requisitos

Asegúrate de tener instalado el compilador `gcc` en tu sistema. Si no lo tienes, puedes instalarlo ejecutando el siguiente comando en la terminal:
```bash
sudo apt install build-essential
```
Compilación de Archivos
Compilar el Servidor

Para compilar el archivo fuente del servidor, ejecuta el siguiente comando en la terminal:
```bash
gcc -o servidor servidor.c
```
Compilar el Cliente

Para compilar el archivo fuente del cliente, ejecuta el siguiente comando en la terminal:
```bash
gcc -o cliente cliente.c
```
Ejecución del Servidor y el Cliente
Ejecutar el Servidor

    Abre una terminal y ejecuta el servidor con el siguiente comando:
```bash
./servidor
```
El servidor comenzará a escuchar conexiones en el puerto 8080.
Ejecutar el Cliente

    Abre otra terminal y ejecuta el cliente con el siguiente comando:
```bash
./cliente
```
El cliente se conectará al servidor en el puerto 8080 para realizar operaciones.
