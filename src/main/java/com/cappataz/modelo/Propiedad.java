package main.java.com.cappataz.modelo;

import java.sql.Date;

public class Propiedad {
    private int idPropiedad;
    private String nombrePropiedad;
    private String ubicacion;
    private double superficie;
    private String tipoPropiedad;
    private Date fechaRegistro;
    private int idPropietario;

    public Propiedad(int idPropiedad ,String nombrePropiedad, String ubicacion, double superficie, String tipoPropiedad,
            Date fechaRegistro, int idPropietario) {
        this.idPropiedad = idPropiedad;
        this.nombrePropiedad = nombrePropiedad;
        this.ubicacion = ubicacion;
        this.superficie = superficie;
        this.tipoPropiedad = tipoPropiedad;
        this.fechaRegistro = fechaRegistro;
        this.idPropietario = idPropietario;
    }

    // Getters
    public int getIdPropiedad() {
        return idPropiedad;
    }

    public String getNombrePropiedad() {
        return nombrePropiedad;
    }

    public void setNombrePropiedad(String nombrePropiedad) {
        this.nombrePropiedad = nombrePropiedad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public String getTipoPropiedad() {
        return tipoPropiedad;
    }

    public void setTipoPropiedad(String tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }
}
