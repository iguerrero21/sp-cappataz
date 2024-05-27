package main.java.com.cappataz.modelo;

import java.sql.Date;

/**
 * Interfaz que define el contrato para los objetos Usuario.
 * Provee métodos para obtener y establecer las propiedades de un usuario.
 * Estos incluyen información personal básica, credenciales y fechas de
 * auditoría.
 */
public interface IUsuario {
    
    // Getters y Setters
    int getIdUsuario();

    String getNombre();

    void setNombre(String nombre);

    String getApellido();

    void setApellido(String apellido);

    String getEmail();

    void setEmail(String email);

    String getContrasena();

    void setContrasena(String contrasena);

    Date getFechaCreacion();

    Date getFechaActualizacion();

    int getIdRol();

    void setIdRol(int idRol);
}
