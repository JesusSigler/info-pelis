# info-pelis

Requisitos:
---------------------------------------------
Maven

SQL server

Tomcat - eclipse o netbeans

Modificar password de conexión a la base de datos en las clases ServicePelis.java y ServiceUsuarios.java en src/main/java/com/aula114/service/ del método conectar()
 
 -------------------------------------------

Importar Base de datos
----------------------------------------------
En terminal:

Conectar con base de datos

mysql -u root -p

Crear base de datos

create database peliculas;

salir del prompt de mysql

exit;

importar Base de datos

mysql -u root -p peliculas < peliculas.sql

Generar war
-----------------------------------------------

Desde terminal (Sin IDE, opcional)

mvn clean package install

Ir al directorio /target recien generado y copiar el .war al directorio webapp de tomcat.

Arrancar tomcat
-----------------------------------------------

cd apache-tocmat/bin

./startup.sh

Abrir navegador
-----------------------------------------------
En la barra de direcciones: localhost:8080/peliculas

usuario: admin
password: 1234

El resto de usuarios no tendrán accesos a las funcionalidades de gestión.

Usuario normal: 

Usuario: Marco
password: 1234

Nota: si el proyecto es abierto desde IDE saltarse los pasos del terminal( a excepción de la creación e importación de la base de datos).
-------------------------------------------------------------------------------------------------------------
Al subir la imagen de una pelicula se guarda su nombre en la base de datos pero no se mueve a la carpeta de destino, hay que moverla manualmente a la carpeta peliculas/resources/imagenes/pelis

Si es abierto desde netBeans y la carpeta NetBeansProjects está situada en la carpeta home del usuario, la imagen se moverá desde el escritorio hasta la carpeta imagenes/pelis, ya que el método renameTo funciona con el IDE pero no funciona si la aplicación se despliega en tomcat o con tomme.

La ruta colocada de destino es esta: "../../NetBeansProjects/Peliculasv3/src/main/webapp/resources/imagenes/pelis/";

Desplegar con tomme
--------------------------------------------------------------------------------------------------------------

mvn clean package install

mvn tomee:run

En el navegador: localhost:8080/peliculas




