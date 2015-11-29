<?php
include_once './db_functions.php';
//Create Object for DB_Functions clas
$db = new DB_Functions(); 


$emailID = $_POST['email'];
//$emailID = "ardell@emails.com";

$userIdQuery = $db->getUserID($emailID);	

$userID = mysql_fetch_assoc($userIdQuery); 

echo "Email ".$emailID ;

print(json_encode($userID));


?>
