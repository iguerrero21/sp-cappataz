package main.java.com.cappataz.modelo;

import java.util.Date;
public interface Usuario {
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
