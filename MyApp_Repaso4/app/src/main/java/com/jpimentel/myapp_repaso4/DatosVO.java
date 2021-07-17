package com.jpimentel.myapp_repaso4;

public class DatosVO {

    private String marca;
    private int precio;
    private int imagen;

    public DatosVO() {
    }

    public DatosVO(String marca, int precio, int imagen) {
        this.marca = marca;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
