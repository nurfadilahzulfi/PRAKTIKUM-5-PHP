<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Percobaan 2</title>
</head>
<body>
    <?php 
        $conn = mysqli_connect ("localhost","root","","db_zulfi") or die ("koneksi gagal");
        $hasil = mysqli_query($conn, "select * from liga");
        while ($row = mysqli_fetch_array($hasil)){
            echo "Liga ".$row["negara"];
            echo " mempunyai " . $row[2]; 
            echo " wakil di liga champion <br>";
        }
    ?>
</body>
</html>