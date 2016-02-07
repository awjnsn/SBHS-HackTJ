function hello(){
	var input = document.getElementById('in').value;
	var key = document.getElementById('key').value;
	if(input.length == key.length){
		chrome.tabs.executeScript(null,{code:"alert('yo')"});
	}
	else{
		chrome.tabs.executeScript(null,{code:"alert('The length of the input and key need to be the same!')"});
	}
}

document.getElementById('helen').addEventListener('click', hello);