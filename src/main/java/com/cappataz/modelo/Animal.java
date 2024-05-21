package main.java.com.cappataz.modelo;

import java.sql.Date;

public class Animal {
    private int id;
    private String tagId;
    private String tagRFID;
    private String especie;
    private String raza;
    private Date fechaNac;
    private Character sexo;
    private Boolean castrado;
    private int idCategoria;
    private int idLote;
    private int idPropietario;

    public Animal() {
        //constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTagRFID() {
        return tagRFID;
    }

    public void setTagRFID(String tagRFID) {
        this.tagRFID = tagRFID;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Boolean getCastrado() {
        return castrado;
    }

    public void setCastrado(Boolean castrado) {
        this.castrado = castrado;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }
    
}
