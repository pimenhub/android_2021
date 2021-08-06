<?php

include_once("connection.php");
$jsonArray = array();
$consulta = "SELECT * FROM tbl_cliente";
$resultado = mysqli_query($connection, $consulta) or die ("Error " . mysqli_error($connection));

if(mysqli_num_rows($resultado) > 0){

    while($registro = mysqli_fetch_array($resultado)){
    $jsonArray["tbl_cliente"][] = $registro;
    }

    echo json_encode($jsonArray);
    mysqli_close($connection);
}
else{
    
    $resultadoVacio["id_cliente"] = "...";
    $resultadoVacio["nombre_cliente"] = "...";
    $resultadoVacio["apellido_cliente"] = "...";
    $resultadoVacio["telefono_cliente"] = "...";
    $resultadoVacio["direccion_cliente"] = "...";
    $jsonArray["tbl_cliente"][] = $resultadoVacio;
    echo json_encode($jsonArray);
    mysqli_close($connection);

}

?>