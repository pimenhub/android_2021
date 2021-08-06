<?php

//Incluir la clase de conexion
include_once("connection.php");

//se crea el array que contendra la informacion ya sea para trasladar o recepcionar
$jsonArray = array();

//Definimos los campos que seran utilizados
if(isset($_GET["nombre_cliente"]) && isset($_GET["apellido_cliente"]) 
&& isset($_GET["telefono_cliente"]) && isset($_GET["direccion_cliente"])){
    
    //Declarar variables que definiran los datos a insertar
    $nombre_cliente = $_GET["nombre_cliente"];
    $apellido_cliente = $_GET["apellido_cliente"];
    $telefono_cliente = $_GET["telefono_cliente"];
    $direccion_cliente = $_GET["direccion_cliente"];

    //Declaracion de la consulta a realizar
    $insertar = "INSERT INTO tbl_cliente (nombre_cliente, apellido_cliente, telefono_cliente, direccion_cliente)
                VALUES ('{$nombre_cliente}', '{$apellido_cliente}', {$telefono_cliente}, '{$direccion_cliente}');";

    //Obtenemos el resultado de la conexion y la consulta que se fue a realizar en la base de datos
    $resultado = mysqli_query($connection, $insertar) or die('Error ' . mysqli_error($connection));

    //Agregar el resultado como dato al array
    $jsonArray["tbl_cliente"][] = $resultado;

    //Asignacion del arreglo al JSON para la estructura a manipular
    echo json_encode($jsonArray);
    mysqli_close($connection);
    //echo 'Insercion Exitos';

}
else{
    echo json_encode($jsonArray);
    mysqli_close($connection);
    echo 'Datos no Insertados';
}


?>