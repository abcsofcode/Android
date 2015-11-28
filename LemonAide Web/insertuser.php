<?php
include_once './db_functions.php';
//Create Object for DB_Functions clas
$db = new DB_Functions(); 

$emailID = $_POST["emailId"];
$passwordID = $_POST["passwordId"];
$nameID = $_POST["emailId"];
$regId = $_POST["regId"];
$res = $db->insertUser($emailID, $passwordID, $nameID, $regId);

/*
$emailID = "name@email.com";
$passwordID = "password";
$nameID = "Name McName";
$regId = "aBcd345";
$res = $db->insertUser($emailID, $passwordID, $nameID, $regId);
*/
echo "Email Id ".$emailID." RegId ".$regId ;
if ($res) {
    echo "GCM Reg Id bas been shared successfully with Server";
} else {             
    echo "Error occured while sharing GCM Reg Id with Server web app";                    
}
?>