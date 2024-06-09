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

Cada usuario realiza su login en el sistema con su email y su contraseña. La contraseña se compara con el hash `md5` que se encuentra guardado en la base de datos. El sistema reconoce el rol del usuario, el cual fue asignado previamente por un administrador, y lo dirige al menú correspondiente.

## Tecnologías utilizadas

- **Java:** Lenguaje de programación principal para la lógica de negocio.
- **MySQL:** Sistema de gestión de bases de datos para almacenar toda la información.
- **Proceso Unificado de Desarrollo de Software:** Metodología utilizada para la planificación y desarrollo del proyecto.

## Estructura del proyecto

El proyecto sigue el patrón MVC:

- **Modelo (Model):** Representa la estructura de datos y la lógica de negocio.
- **Vista (View):** Interfaz de usuario que interactúa con el modelo.
- **Controlador (Controller):** Maneja las entradas del usuario, interactúa con el modelo y selecciona la vista apropiada para mostrar al usuario.

## Instalación y configuración

### Requisitos previos

- Java JDK 11 o superior
- MySQL 8.0 o superior

### Pasos para la instalación

1. Clona el repositorio:
   ```sh
   git clone https://github.com/tuusuario/cappataz.git

2. Instalar la base de datos con el script `cappataz_db.sql` con MySQL Workbench.


## Utilización

Para ingresar al sistema, se debe tener usuario y contraseña:

- Juan Pérez es ADMINSITRADOR. Usuario: juan.perez@example.com
- Carlos Fernández es PROPIETARIO. Usuario carlos.fernandez@example.com
- Marian Gómez es OPERARIO. Usuario mariana.gomez@example.com

En todos los casos, la contraseña es 1234.
