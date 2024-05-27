package main.java.com.cappataz.modelo;

import java.sql.Date;

/**
 * Clase que representa a un propietario en el sistema.
 * Un propietario es un tipo de usuario con privilegios específicos y se
 * caracteriza
 * por tener un conjunto de propiedades a su nombre.
 *
 * Implementa la interfaz Usuario para asegurar que se cumplan los contratos de
 * la entidad Usuario.
 */
public class Propietario implements IUsuario {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private int idRol;

    /**
     * Constructor para crear un nuevo propietario.
     *
     * @param idUsuario  El identificador único del usuario.
     * @param nombre     El nombre del propietario.
     * @param apellido   El apellido del propietario.
     * @param email      El correo electrónico del propietario.
     * @param contrasena La contraseña del propietario.
     */    
    public Propietario(int idUsuario, String nombre, String apellido, String email, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.idRol = 2; // Rol de Propietario
    }

    // Getters y Setters
    @Override
    public int getIdUsuario() {
        return idUsuario;
    }

    // public void setIdUsuario(int idUsuario) {
    //     this.idUsuario = idUsuario;
    // }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getContrasena() {
        return contrasena;
    }

    @Override
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    @Override
    public int getIdRol() {
        return idRol;
    }

    @Override
    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
}
