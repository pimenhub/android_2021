<?php

include_once("connection.php");
$jsonArray = array();
$consuta = "SELECT * FROM tbl_palabra ORDER BY termino_palabra ASC";
$resultado = mysqli_query($conn, $consuta) or die ("Error ". mysqli_error($conn));

if(mysqli_num_rows($resultado) > 0){
    
    while($registro = mysqli_fetch_array($resultado)){
        $jsonArray["tbl_palabra"][] = $registro;
    }
    echo json_encode($jsonArray);
    mysqli_close($conn);

}
else{
    $resultadoVacio["id_palabra"]="...";
    $resultadoVacio["termino_palabra"]="...";
    $resultadoVacio["significado_palabra"]="...";
    $jsonArray["tbl_palabra"][] = $resultadoVacio;
    echo json_encode($jsonArray);
    mysqli_close($conn);
}

?>