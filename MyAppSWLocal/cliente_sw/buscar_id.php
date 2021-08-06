<?php

include_once("connection.php");

$jsonArray = array();

if(isset($_GET["id_cliente"])){
    $id_cliente = $_GET["id_cliente"];
     $buscarId = "SELECT nombre_cliente, apellido_cliente, telefono_cliente, direccion_cliente 
     FROM tbl_cliente WHERE id_cliente = $id_cliente";
     $resultado = mysqli_query($connection, $buscarId) or die ("Error " . mysqli_error($connection));
     
     
    if(mysqli_num_rows($resultado) > 0){
        $registros = mysqli_fetch_array($resultado);
        $jsonArray["tbl_cliente"][] = $registros;
    }
    else{
        
        $resultadoVacio["nombre_cliente"] = "...";
        $resultadoVacio["apellido_cliente"] = "...";
        $resultadoVacio["telefono_cliente"] = "...";
        $resultadoVacio["direccion_cliente"] = "...";
        $jsonArray["tbl_cliente"][] = $resultadoVacio;

        //$jsonArray["tbl_cliente"][] = $registros;
        //echo "Datos no encontrados";
    }

    echo json_encode($jsonArray);
    mysqli_close($connection);

}
else{
    echo json_encode($jsonArray);
    mysqli_close($connection);
    echo "Datos no encontrados";
}


?>