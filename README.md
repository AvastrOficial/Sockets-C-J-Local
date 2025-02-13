## Sockets Local
Lenguaje C# y Java

# 0.0.0 Lenguaje C#
## Proyecto de Servidor y Cliente

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
<br>
Dominio ip : http://127.0.0.1:8080/
<br>
Puerto : 8080 
# 0.0.1 JAVA :

Este proyecto implementa un servidor y un cliente en Java que permiten la transferencia de archivos mediante sockets.

## Requisitos

Antes de comenzar, asegúrate de cumplir con los siguientes requisitos:

- Sistema operativo: Kali Linux (o cualquier distribución basada en Debian).
- Java Development Kit (JDK) 8 o superior.

## Instalación

1. **Instalar Java** (si no está instalado):
   ```bash
   sudo apt update
   sudo apt install default-jdk -y
   ```

2. **Verificar la instalación de Java:**
   ```bash
   java -version
   ```
   Debe mostrar una versión de Java instalada.

3. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/AvastrOficial/Sockets-C-J-Local
   cd Sockets-C-J-Local
   ls
   cd Sockets C && cd Sockets Java 0.0.1
   ```

4. **Compilar los archivos Java:**
   ```bash
   javac Server.java Client.java
   ```

## Uso

### Ejecutar el Servidor

1. Iniciar el servidor:
   ```bash
   java Server
   ```
   Esto pondrá el servidor a la escucha en el puerto `8080`.

### Ejecutar el Cliente

1. Asegúrate de que el archivo `archivo_a_enviar.txt` está en el mismo directorio que `Client.java`.
2. Ejecutar el cliente para enviar el archivo al servidor:
   ```bash
   java Client
   ```

## Notas

- El servidor debe ejecutarse antes que el cliente.
- El archivo recibido se guardará como `archivo_recibido.txt` en el servidor.
- Si deseas cambiar el nombre del archivo o el puerto, modifica los valores en los archivos `Server.java` y `Client.java`.




