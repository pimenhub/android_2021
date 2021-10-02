package com.jpimentel.myappfirebasedb.complementos;

public class DataVO {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;

    public DataVO() {
    }

    public DataVO(String id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    //Convertir el retorno deseado desde firebase
    @Override
    public String toString() {
        return nombre;
    }
}
