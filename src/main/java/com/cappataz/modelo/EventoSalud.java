package main.java.com.cappataz.modelo;

import java.sql.Date;

public class EventoSalud {
    private int idEvento;
    private int idAnimal;
    private Date fecha;
    private String enfermedad;
    private String tratamiento;
    private int idOperario;
    
    //Getters y Setters
    public int getIdEvento() {
        return idEvento;
    }
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
    public int getIdAnimal() {
        return idAnimal;
    }
    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getEnfermedad() {
        return enfermedad;
    }
    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }
    public String getTratamiento() {
        return tratamiento;
    }
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
    public int getIdOperario() {
        return idOperario;
    }
    public void setIdOperario(int idOperario) {
        this.idOperario = idOperario;
    }

    // Getters y setters
    
}