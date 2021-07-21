package com.jpimentel.myappextrasrecyclerfragment;

public class DatosVO {

    private int imagen;
    private String texto;

    private int detalle;
    private int especificaciones;

    public DatosVO() {

    }

    public DatosVO(int imagen, String texto) {
        this.imagen = imagen;
        this.texto = texto;
    }

    public DatosVO(int detalle, int especificaciones) {
        this.detalle = detalle;
        this.especificaciones = especificaciones;
    }

    public int getDetalle() {
        return detalle;
    }

    public void setDetalle(int detalle) {
        this.detalle = detalle;
    }

    public int getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(int especificaciones) {
        this.especificaciones = especificaciones;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
