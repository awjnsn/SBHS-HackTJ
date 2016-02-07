function hello(){
	var input = document.getElementById('in').value;
	var key = document.getElementById('key').value;
	if(input.length == key.length){
		var out = '';
		for(var i = 0; i < input.length; i++){
			out += String.fromCharCode(input.charCodeAt(i) ^ key.charCodeAt(i));
		}
		//alert(out);
		var a = "alert('";
		var b = "')";
		var arg = a.concat(out,b);
		chrome.tabs.executeScript(null,{code:arg});
	}
	else{
		chrome.tabs.executeScript(null,{code:"alert('The length of the input and key need to be the same!')"});
	}
}

document.getElementById('helen').addEventListener('click', hello);