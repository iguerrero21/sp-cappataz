package main.java.com.cappataz.modelo;

import java.sql.Date;

public class Lote {
    private int id;
    private String nombre;
    private int idPropietario;
    private int idParcela;
    private Date fechaCreacion;
    
    public Lote(int id, String nombre, int idPropietario, int idParcela, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.idPropietario = idPropietario;
        this.idParcela = idParcela;
        this.fechaCreacion = fechaCreacion;
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

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public int getIdParcela() {
        return idParcela;
    }

    public void setIdParcela(int idParcela) {
        this.idParcela = idParcela;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    
}
