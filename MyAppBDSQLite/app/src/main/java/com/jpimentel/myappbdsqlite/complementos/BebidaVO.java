package com.jpimentel.myappbdsqlite.complementos;

public class BebidaVO {

    private int idBebida;
    private String nombreBebida;
    private String saborBebida;
    private String tipoBebida;
    private int precioBebida;

    public BebidaVO() {
    }

    public BebidaVO(int idBebida, String nombreBebida, String saborBebida, String tipoBebida, int precioBebida) {
        this.idBebida = idBebida;
        this.nombreBebida = nombreBebida;
        this.saborBebida = saborBebida;
        this.tipoBebida = tipoBebida;
        this.precioBebida = precioBebida;
    }

    public int getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(int idBebida) {
        this.idBebida = idBebida;
    }

    public String getNombreBebida() {
        return nombreBebida;
    }

    public void setNombreBebida(String nombreBebida) {
        this.nombreBebida = nombreBebida;
    }

    public String getSaborBebida() {
        return saborBebida;
    }

    public void setSaborBebida(String saborBebida) {
        this.saborBebida = saborBebida;
    }

    public String getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public int getPrecioBebida() {
        return precioBebida;
    }

    public void setPrecioBebida(int precioBebida) {
        this.precioBebida = precioBebida;
    }
}
