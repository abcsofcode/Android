<html>
<head><title>View Users</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<style>
body {
  font: normal medium/1.4 sans-serif;
}
div.greetblock, div.serverresponse {
  border-collapse: collapse;
  width: 60%;
  margin-left: auto;
  margin-right: auto;
  align: center;
}
table {
	width: 100%;
}
tr > td {
  padding: 0.25rem;
  text-align: center;
  border: 1px solid #ccc;
}
tr:nth-child(even) {
  background: #fff;
 
}
tr:nth-child(odd) {
  background-color: #F7941E;
  color: #fff;
}
tr#header{
background-color: #F7941E;
}
 
div#norecord{
margin-top:10px;
width: 15%;
margin-left: auto;
margin-right: auto;
}
input,select{
cursor: pointer;
}

div.leftdiv{
width: 45%;
padding: 0 10px;
float: left;
border: 1px solid #ccc;
margin: 5px;
height: 320px;
text-align:center;
}
hidediv{
display: none;
}
p.header{
background-color: #F7941E;
padding: 10px;
color: #fff;
text-align:center;
margin-bottom: 10px;
}

</style>
<script>
function sendMsg(){
var msgLength = $.trim($("textarea").val()).length;
var checkedCB = $("input[type='checkbox']:checked").length;
if( checkedCB == 0){
    alert("You must select atleast one User to send message");
}else if(msgLength == 0){
    alert("You left the message field blank, please fill it");
}else{
    var formData = $(".wrapper").find("input").serialize() + "&imgurl="+ $("#festival").val() + "&message=" + $("textarea").val();  
    $.ajax({type: "POST",data: formData, url: "processmessage.php", success:function(res){
        $(".greetblock").slideUp(1000);
        $(".serverresponse").prepend(res).hide().fadeIn(2000);
    }});
}
}
$(function(){
    $(".serverresponse").hide()
    $("input[type='checkbox']").click(function(){
        if($(this).is(':checked')){
            $(this).parent().css("border","3px solid red");
        }else{
            $(this).parent().css("border","0px");
        }
    });
 
    $("div.leftdiv, div.rightdiv").hover(function(){
        $(this).css("background","#FAFAFA");
    },function(){
        $(this).css("background","#fff");
    });
 
    $("#festival").change(function(){
        $("img").attr("src",$(this).val());
    });
 
    $("#sendmsg").click(function(){
        $(".serverresponse").fadeOut(300,function(){
            $(".greetblock").fadeIn(1000);
        });     
    });
});
</script>
</head>
<body>
<?php
    include_once 'db_functions.php';
    $db = new DB_Functions();
    $users = $db->getAllUsers();
    if ($users != false)
        $no_of_users = mysql_num_rows($users);
    else
        $no_of_users = 0;   
?>
<?php
    if ($no_of_users > 0) {
?>
 
<div class="leftdiv">
<p class="header">Users
</p>
<table>
<tr id="header"><td>ID</td><td>Name</td><td>Email</td></tr>
<?php
    while ($row = mysql_fetch_array($users)) {
?> 
<tr>
<td><span><?php echo $row["id"] ?></span></td>
<td><span><?php echo $row["username"] ?></span></td>
<td><span><?php echo $row["email"] ?></span></td>
</tr>
<?php } ?>
</table>
</div>

<?php }else{ ?>
<div id="norecord">
No records in MySQL DB
</div>
<?php } ?>
 
</body>
</html>