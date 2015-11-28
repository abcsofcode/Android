<?php
include_once './db_functions.php';
//Create Object for DB_Functions clas
$db = new DB_Functions(); 

$userID = 3; // I'll have to update this in a bit
$makeID = $_POST["makeId"];
$modelID = $_POST["modelId"];
$yearID = $_POST["yearId"];

$res = $db->insertCar($userID, $makeID, $modelID, $yearID);

/*
$userID = 2; // I'll have to update this in a bit

$makeID = "Kia";
$modelID = "Soul";
$yearID = "2014";

$res = $db->insertCar($userID, $makeID, $modelID, $yearID);
*/
echo "Make ".$makeID." Model ".$modelID ;
if ($res) {
    echo "Car has been shared successfully with Server";
} else {             
    echo "Error occured while sharing car with Server web app";                    
}
?>