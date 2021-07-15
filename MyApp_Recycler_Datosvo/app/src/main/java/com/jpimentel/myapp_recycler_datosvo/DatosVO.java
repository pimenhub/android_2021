package com.jpimentel.myapp_recycler_datosvo;

public class DatosVO {

    private String nombreR;
    private String calidadR;
    private int imagenR;

    public DatosVO() {
    }

    public DatosVO(String nombreR, String calidadR, int imagenR) {
        this.nombreR = nombreR;
        this.calidadR = calidadR;
        this.imagenR = imagenR;
    }

    public String getNombreR() {
        return nombreR;
    }

    public void setNombreR(String nombreR) {
        this.nombreR = nombreR;
    }

    public String getCalidadR() {
        return calidadR;
    }

    public void setCalidadR(String calidadR) {
        this.calidadR = calidadR;
    }

    public int getImagenR() {
        return imagenR;
    }

    public void setImagenR(int imagenR) {
        this.imagenR = imagenR;
    }
}
