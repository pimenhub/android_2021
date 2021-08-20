<?php

$host = 'localhost';
$username = 'root';
$password = '';
$dbname = 'bd_diccionario';

$conn = mysqli_init();
mysqli_real_connect($conn, $host, $username, $password, $dbname);
mysqli_set_charset($conn, 'utf8');


?>