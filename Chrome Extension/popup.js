function hello(){
	var input = document.getElementById('in').value;
	var key = document.getElementById('key').value;
	confirm(key);
}

document.getElementById('helen').addEventListener('click', hello);