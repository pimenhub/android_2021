package com.jpimentel.myappcine;

public class DatosVO {
    private int imagenPelicula;
    private String nombrePelicula;
    private String duracionPelicula;
    private int precioBoletoPelicula;

    private int sinopsisPelicula;
    private int directoresActoresPelicula;
    private int puntuacioRecaudacionPelicula;



    public DatosVO() {
    }

    public DatosVO(int imagenPelicula, String nombrePelicula, String duracionPelicula, int precioBoletoPelicula) {
        this.imagenPelicula = imagenPelicula;
        this.nombrePelicula = nombrePelicula;
        this.duracionPelicula = duracionPelicula;
        this.precioBoletoPelicula = precioBoletoPelicula;
    }

    public DatosVO(int sinopsisPelicula, int directoresActoresPelicula, int puntuacioRecaudacionPelicula) {
        this.sinopsisPelicula = sinopsisPelicula;
        this.directoresActoresPelicula = directoresActoresPelicula;
        this.puntuacioRecaudacionPelicula = puntuacioRecaudacionPelicula;
    }

    public int getImagenPelicula() {
        return imagenPelicula;
    }

    public void setImagenPelicula(int imagenPelicula) {
        this.imagenPelicula = imagenPelicula;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getDuracionPelicula() {
        return duracionPelicula;
    }

    public void setDuracionPelicula(String duracionPelicula) {
        this.duracionPelicula = duracionPelicula;
    }

    public int getPrecioBoletoPelicula() {
        return precioBoletoPelicula;
    }

    public void setPrecioBoletoPelicula(int precioBoletoPelicula) {
        this.precioBoletoPelicula = precioBoletoPelicula;
    }

    public int getSinopsisPelicula() {
        return sinopsisPelicula;
    }

    public void setSinopsisPelicula(int sinopsisPelicula) {
        this.sinopsisPelicula = sinopsisPelicula;
    }

    public int getDirectoresActoresPelicula() {
        return directoresActoresPelicula;
    }

    public void setDirectoresActoresPelicula(int directoresActoresPelicula) {
        this.directoresActoresPelicula = directoresActoresPelicula;
    }

    public int getPuntuacioRecaudacionPelicula() {
        return puntuacioRecaudacionPelicula;
    }

    public void setPuntuacioRecaudacionPelicula(int puntuacioRecaudacionPelicula) {
        this.puntuacioRecaudacionPelicula = puntuacioRecaudacionPelicula;
    }
}
