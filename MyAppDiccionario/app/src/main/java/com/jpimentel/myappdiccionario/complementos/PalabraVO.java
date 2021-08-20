package com.jpimentel.myappdiccionario.complementos;

public class PalabraVO {

    private int id_palabra;
    private String termino_palabra;
    private String significado_palabra;

    public PalabraVO() {
    }

    public PalabraVO(int id_palabra, String termino_palabra, String significado_palabra) {
        this.id_palabra = id_palabra;
        this.termino_palabra = termino_palabra;
        this.significado_palabra = significado_palabra;
    }

    public int getId_palabra() {
        return id_palabra;
    }

    public void setId_palabra(int id_palabra) {
        this.id_palabra = id_palabra;
    }

    public String getTermino_palabra() {
        return termino_palabra;
    }

    public void setTermino_palabra(String termino_palabra) {
        this.termino_palabra = termino_palabra;
    }

    public String getSignificado_palabra() {
        return significado_palabra;
    }

    public void setSignificado_palabra(String significado_palabra) {
        this.significado_palabra = significado_palabra;
    }
}
