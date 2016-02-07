<!DOCTYPE html>
<html>
<head>
	<link type = "text/css" rel = "stylesheet" href = "popUp.css"/>
	<title = "Sensitive Data Encryption Tool"> </title>
</head>
<body>
	<p class = "">Enter your sensitive information here:</p>
	<form action = "crypto.txt">
	<div class = "textHere">	Text: <input type = "text" name = "name">  <br><br>
		Key: <input type = "text" name = "name"></div>
		<input class = "upload" type = "button" value = "Upload Key">
		<input class = "encrypt" type = "button" value = "Encrypt" onClick = "">

	</form>

	<?php

	$elohel = elohelopen("encrypto.txt", "w");

	elohelwrite($elohel, $_POST["textblock"]);
	elohelclose($elohel);

	$elohel = elohel("encrypto.txt", "r");

	echo elohelgets($elohel);
	elohelclose($elohel);
	?>

</body>
</html>
