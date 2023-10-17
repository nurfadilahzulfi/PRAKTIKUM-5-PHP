<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Koneksi database dengan mysqli_fetch_row</title>
</head>
<body>
<?php 
        $conn = mysqli_connect ("localhost","root","","db_zulfi") or die ("koneksi gagal");
        $hasil = mysqli_query($conn, "select * from liga");
        while ($row = mysqli_fetch_array($hasil)){
            echo "Liga ".$row[1]; //array asosiatif
            echo " mempunyai " . $row[2]; //array numeris
            echo " wakil di liga champion <br>";
        }
    ?>
</body>
</html>