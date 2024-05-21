package main.java.com.cappataz.modelo;

public class Parcela {
    private int idParcela;
    private String nombreParcela;
    private String ubicacion;
    private double superficie;
    private String uso;
    private int idPropiedad;

    public Parcela(int idParcela, String nombreParcela, String ubicacion, double superficie, String uso,
            int idPropiedad) {
        this.idParcela = idParcela;
        this.nombreParcela = nombreParcela;
        this.ubicacion = ubicacion;
        this.superficie = superficie;
        this.uso = uso;
        this.idPropiedad = idPropiedad;
    }

    public int getIdParcela() {
        return idParcela;
    }

    public String getNombreParcela() {
        return nombreParcela;
    }

    public void setNombreParcela(String nombreParcela) {
        this.nombreParcela = nombreParcela;
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

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public int getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(int idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    
}
