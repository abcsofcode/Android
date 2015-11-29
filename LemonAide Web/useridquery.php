<?php
include_once './db_functions.php';
//Create Object for DB_Functions clas
$db = new DB_Functions(); 

/*
$userID = 3; // I'll have to update this in a bit
$makeID = $_POST["makeId"];
$modelID = $_POST["modelId"];
$yearID = $_POST["yearId"];

$res = $db->insertCar($userID, $makeID, $modelID, $yearID);
*/
/*
$userID = 2; // I'll have to update this in a bit

$makeID = "Kia";
$modelID = "Soul";
$yearID = "2014";

$res = $db->insertCar($userID, $makeID, $modelID, $yearID);
*/

//$emailID = $_POST["emailId"];
$emailID = "ardell@emails.com";

$userIdQuery = $db->getUserID($emailID);	

$userID = mysql_fetch_assoc($userIdQuery); 

echo "Email ".$emailID ;

print(json_encode($userID));

/*
if ($res) {
    echo "User id successfully queried";
} else {             
    echo "Error occured while getting user ID";                    
}
*/
?>
