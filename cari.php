<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nur Fadilah Zulfi</title>
</head>
<body>
    <?php
    $conn = mysqli_connect("localhost","root","","db_saya") or die ("koneksi gagal cuk");
    $hasil2 = mysqli_query($conn,"SELECT * FROM login WHERE username = 'username' && password = 'password' ");
    $row = mysqli_fetch_array($hasil2);
    $username = $_POST['username'];
    $password = $_POST['password'];

        if(($username==$row["username"] && $password==$row["password"])){
            echo "selamat datang";
        }
        else{
            echo "username atau password salah";
        }
        
        //  while($row = mysqli_fetch_array($hasil)){
        //    echo $row["kode"];
        //    echo $row["negara"];
        //    echo $row["champion"] . "<br>";
       // }
       
    ?>
</body>
</html>