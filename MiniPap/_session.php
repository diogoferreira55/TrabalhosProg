<?php
session_start();
if (!isset($_SESSION["nomeuser"]) || $_SESSION["nomeuser"] == null) {
    $_SESSION["nomeuser"] = "";
    //echo "nao tem";
} else {
    //echo "tem";
}
//echo isset($_SESSION['nomeuser']) ? 'S' : 'N';

if (isset($_GET['nomeuser']))  {
    $_SESSION["nomeuser"] = $_GET['nomeuser'];
}
//echo "--"; 
//print_r($_SESSION);
echo $_SESSION["nomeuser"];
//session_destroy();
?>