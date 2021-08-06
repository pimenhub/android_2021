<?php

include_once("connection.php");
$jsonArray = array();

if(isset($_GET["id_cliente"])){
    $id_cliente = $_GET["id_cliente"];
    $eliminar = "DELETE FROM tbl_cliente WHERE id_cliente = $id_cliente";
    $resultado = mysqli_query($connection, $eliminar) or die ("Error " . mysqli_error($connection));
    $jsonArray["tbl_cliente"][] = $resultado;
    echo json_encode($jsonArray);
    mysqli_close($connection);

}
else{

    echo json_encode($jsonArray);
    mysqli_close($connection);
}



?>