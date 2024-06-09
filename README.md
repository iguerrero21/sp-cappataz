## Seminario de Práctica Informática
### Universidad Siglo 21
### 2024

# Sistema de Gestión Ganadera "Cappataz"

El presente es un trabajo práctico para la cátedra de Seminario de Práctica, de la licenciatura en Informática.

El ejercicio consiste en proyectar, a partir de los requerimientos de un cliente, una aplicación en `Java` + `MySQL` utilizando el Proceso Unificado de Desarrollo de Software.

## Acerca de la aplicación

La arquitectura que se eligió para este proyecto es `Model-View-Controller (MVC)`. El sistema permite la gestión (CRUD) de propiedades, parcelas, animales y lotes de ganado de forma sencilla.

### Características principales

- **Gestión de propiedades:** Permite agregar, modificar, visualizar y eliminar propiedades.
- **Gestión de parcelas:** Cada propiedad puede tener múltiples parcelas, las cuales también se pueden gestionar completamente.
- **Gestión de animales:** Registro y seguimiento de animales, incluyendo detalles como especie, raza, fecha de nacimiento, sexo, entre otros.
- **Gestión de lotes:** Organización y control de lotes de animales.

### Niveles de usuario

- **Administrador:** Control total sobre el sistema. Puede gestionar usuarios, propiedades, parcelas, animales y lotes.
- **Propietario:** Puede visualizar la evolución de sus propiedades y animales.
- **Operario:** Puede ingresar, modificar y visualizar datos de animales, parcelas y lotes.

### Seguridad

Cada usuario realiza su login en el sistema con su email y su contraseña. La contraseña se compara con el hash `SHA-256` que se encuentra guardado en la base de datos. El sistema reconoce el rol del usuario, el cual fue asignado previamente por un administrador, y lo dirige al menú correspondiente.

## Tecnologías utilizadas

- **Java:** Lenguaje de programación principal para la lógica de negocio.
- **MySQL:** Sistema de gestión de bases de datos para almacenar toda la información.
- **JDBC** para conectar con la base de datos.
- **JUnit** y **Hamcrest** para pruebas unitarias.
- **Proceso Unificado de Desarrollo de Software:** Metodología utilizada para la planificación y desarrollo del proyecto.

## Estructura del proyecto

El proyecto sigue el patrón MVC:

- **Modelo (Model):** Representa la estructura de datos y la lógica de negocio.
- **Vista (View):** Interfaz de usuario que interactúa con el modelo.
- **Controlador (Controller):** Maneja las entradas del usuario, interactúa con el modelo y selecciona la vista apropiada para mostrar al usuario.
- Las consultas a la base de datos se ubican en la carpeta **/dao**.
- Parte de la lógica fue cargada en la carpeta **/funciones**.
- Los menú se encuentran en la carpeta **/menu**.
- Las utilidades, como la conexión a la base de datos, o la aplicaión para hashear las contraseñas, se ubican en la carpeta **/util**.


## Instalación y configuración

### Requisitos previos

- Java JDK 11 o superior
- MySQL 8.0 o superior
- JUnit 4.13.2
- Hamcrest-Core 1.3

Las librerías ya se encuentran preinstaladas en la carpeta **/lib**, pero tal vez deban ser autorizadas en el **classpath** de sistema.

### Pasos para la instalación

1. Clona el repositorio:
   ```sh
   git clone https://github.com/iguerrero21/sp-cappataz.git

2. Instalar la base de datos con el script `cappataz_db.sql` en MySQL Workbench. La misma se encuentra en la raíz del proyecto.


## Utilización

Para ingresar al sistema, se debe tener usuario y contraseña:

- Juan Pérez es ADMINSITRADOR. Usuario: juan.perez@example.com
- Carlos Fernández es PROPIETARIO. Usuario carlos.fernandez@example.com
- Marian Gómez es OPERARIO. Usuario mariana.gomez@example.com

En todos los casos, la contraseña es 1234.
