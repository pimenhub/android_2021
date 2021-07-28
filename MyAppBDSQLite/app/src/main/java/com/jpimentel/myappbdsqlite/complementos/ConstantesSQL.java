package com.jpimentel.myappbdsqlite.complementos;

public class ConstantesSQL {

    //Constantes para la utilizacion de las consultas SQL principales DDL
    //Base de datos
    public static final String BD_BEBIDA = "bd_bebida";
    //Tablas
    public static final String TABLA_BEBIDA = "tbl_bebida";
    //Campos de las tablas
    public static final String CAMPO_ID = "id_bebida";
    public static final String CAMPO_NOMBRE = "nombre_bebida";
    public static final String CAMPO_SABOR = "sabor_bebida";
    public static final String CAMPO_TIPO = "tipo_bebida";
    public static final String CAMPO_PRECIO = "precio_bebida";

    //Consultas con CREATE
    public static final String CREAR_TABLA_BEBIDA = "CREATE TABLE "+TABLA_BEBIDA+
            " ("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_NOMBRE+" TEXT NOT NULL,"+
            CAMPO_SABOR+" TEXT NOT NULL, "+CAMPO_TIPO+" TEXT NOT NULL, "+CAMPO_PRECIO+" INTEGER NOT NULL);";

    //Consultas con DROP
    public static final  String BORRAR_TABLA = "DROP TABLE IF EXISTS "+TABLA_BEBIDA;

    //Version
    public static final int VERSION = 1;

}
