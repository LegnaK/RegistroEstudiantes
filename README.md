RegistroEstudiantes
===================

Sencilla aplicación en Java para el manejo de estudiantes con SqLite

La aplicación hace uso del sistema de gestión de base de datos SqLite 3.7.15

La versión de la aplicación actual es la 1b.0.0

===================

Al momento de inicial la aplicacioón, los datos de ingreso son: 
*Usuario:    Admin
*Password:   Admin

El driver al querer acceder a la base de datos en donde se almacenan los datos de los usuarios (login.db). Si no existe este mismo la crea, al igual que una tabla con los datos anteriores por defecto.

Al momento de crear grupos, el driver verifica si existe o no la base de datos (grupos.db). En esta tabla es donde se guardan los grupos, que mismamente contendran a los estudiantes.
