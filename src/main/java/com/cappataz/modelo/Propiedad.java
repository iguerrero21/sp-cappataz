package main.java.com.cappataz.modelo;

import java.sql.Date;

public class Propiedad {
    private int id;
    private String nombre;
    private String ubicacion;
    private float superficie;
    private String actividadPrimaria;
    private String actividadSecundaria;
    private Date fechaCreacion;
    private int idPropietario;
    
    public Propiedad(int id, String nombre, String ubicacion, float superficie, String actividadPrimaria,
            Date fechaCreacion, int idPropietario) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.superficie = superficie;
        this.actividadPrimaria = actividadPrimaria;
        this.fechaCreacion = fechaCreacion;
        this.idPropietario = idPropietario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    public String getActividadPrimaria() {
        return actividadPrimaria;
    }

    public void setActividadPrimaria(String actividadPrimaria) {
        this.actividadPrimaria = actividadPrimaria;
    }

    public String getActividadSecundaria() {
        return actividadSecundaria;
    }

    public void setActividadSecundaria(String actividadSecundaria) {
        this.actividadSecundaria = actividadSecundaria;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    

}
