package com.jpimentel.myappfirebasedatabase2021.complementos;


public class DataVO {

    private String idContacto;
    private String nombreContacto;
    private String apellidoContacto;
    private int telefonoContacto;

    public DataVO() {
    }

    public DataVO(String idContacto, String nombreContacto, String apellidoContacto, int telefonoContacto) {
        this.idContacto = idContacto;
        this.nombreContacto = nombreContacto;
        this.apellidoContacto = apellidoContacto;
        this.telefonoContacto = telefonoContacto;
    }
    public DataVO(String nombreContacto, String apellidoContacto, int telefonoContacto) {
        this.nombreContacto = nombreContacto;
        this.apellidoContacto = apellidoContacto;
        this.telefonoContacto = telefonoContacto;
    }

    public String getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(String idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getApellidoContacto() {
        return apellidoContacto;
    }

    public void setApellidoContacto(String apellidoContacto) {
        this.apellidoContacto = apellidoContacto;
    }

    public int getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(int telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
    //Convertir la informacion que devuelve la base de datos en Firebase

    @Override
    public String toString() {
        String info = "Nombre: "+nombreContacto+"\n"+
                "Apellido: "+apellidoContacto+"\n"+
                "Telefono: "+telefonoContacto+"\n";
        return info;
    }
}
