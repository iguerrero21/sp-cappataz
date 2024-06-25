package main.java.com.cappataz.modelo;

import java.sql.Date;

/**
 * Clase que representa una propiedad dentro del sistema.
 * Almacena información sobre la propiedad, como su identificador, nombre,
 * ubicación, superficie, tipo de propiedad, fecha de registro y el
 * identificador del propietario.
 */
public class Propiedad {
    private int idPropiedad;
    private String nombrePropiedad;
    private String ubicacion;
    private double superficie;
    private String tipoPropiedad;
    private Date fechaRegistro;
    private int idPropietario;

    /**
     * Constructor para crear una nueva propiedad.
     *
     * @param idPropiedad     El identificador único de la propiedad.
     * @param nombrePropiedad El nombre de la propiedad.
     * @param ubicacion       La ubicación geográfica de la propiedad.
     * @param superficie      La superficie total de la propiedad en hectáreas.
     * @param tipoPropiedad   El tipo de propiedad (e.g., agrícola, ganadera).
     * @param fechaRegistro   La fecha en que la propiedad fue registrada en el
     *                        sistema.
     * @param idPropietario   El identificador del propietario de la propiedad.
     */
    public Propiedad(int idPropiedad, String nombrePropiedad, String ubicacion, double superficie, String tipoPropiedad,
            Date fechaRegistro, int idPropietario) {
        this.idPropiedad = idPropiedad;
        this.nombrePropiedad = nombrePropiedad;
        this.ubicacion = ubicacion;
        this.superficie = superficie;
        this.tipoPropiedad = tipoPropiedad;
        this.fechaRegistro = fechaRegistro;
        this.idPropietario = idPropietario;
    }

    public Propiedad() {
        //TODO Auto-generated constructor stub
    }

    // Getters y Setters
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
