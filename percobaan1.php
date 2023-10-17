<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Koneksi Database MySQL</title>
</head>
<body>
    <h1>Demo koneksi database MySQL</h1>
    <?php 
        $conn = mysqli_connect ("localhost","root","","db_zulfi");
        if($conn){
            echo "server terkoneksi";
        }else{
            echo "server tidak terkoneksi";
        }
    ?>
</body>
</html>