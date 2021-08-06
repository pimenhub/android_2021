<?php

include_once("connection.php");
$jsonArray = array();

if(isset($_GET["id_cliente"])){
    $id_cliente = $_GET["id_cliente"];
    $nombre_cliente = $_GET["nombre_cliente"];
    $apellido_cliente = $_GET["apellido_cliente"];
    $telefono_cliente = $_GET["telefono_cliente"];
    $direccion_cliente = $_GET["direccion_cliente"];

    $actualizar = "UPDATE tbl_cliente SET nombre_cliente='$nombre_cliente', apellido_cliente='$apellido_cliente',
    telefono_cliente=$telefono_cliente, direccion_cliente='$direccion_cliente'
    WHERE id_cliente= $id_cliente";

    $resultado = mysqli_query($connection, $actualizar) or die ("Error " . mysqli_error($connection));
    $jsonArray["tbl_cliente"][] = $resultado;

    echo json_encode($jsonArray);
    mysqli_close($connection);
}
else{
    echo json_encode($jsonArray);
    mysqli_close($connection);
}


?>