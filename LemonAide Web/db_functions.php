<?php
 
class DB_Functions {
 
    private $db;
 
    function __construct() {
        include_once './db_connect.php';
        // Connect to database
        $this->db = new DB_Connect();
        $this->db->connect();
    }
    // destructor
    function __destruct() {
 
    }
    /**
     * Insert new user
     *  
     */
    public function insertUser($emailId, $password, $nameId, $gcmRegId, $type) {
        // Insert user into database
        $result = mysql_query("INSERT INTO users (username,email,password,push_id,type) VALUES('$nameId','$emailId','$password','$gcmRegId','$type')");        
        if ($result) {
            return true;
        } else {             
            return false;                     
        }
    }
    /**
     * Insert new car
     *  
     */
    public function insertCar($userID, $makeID, $modelID, $yearID) {
        // Insert car into database
        $result = mysql_query("INSERT INTO user_vehicles (user_id,year,make,model) VALUES('$userID','$yearID','$makeID','$modelID')");        
        if ($result) {
            return true;
        } else {             
            return false;                     
        }
    }
    /**
     * Select all user
     * 
     */
     public function getAllUsers() {
        $result = mysql_query("select * FROM users");
        return $result;
    }
    /**
     * Get GCMRegId
     * 
     */
    public function getGCMRegID($emailID){
         $result = mysql_query("SELECT push_id FROM users WHERE email = "."'$emailID'");
         return $result;
    }
}
?>