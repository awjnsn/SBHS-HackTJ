function hello(){
	chrome.tabs.executeScript({
		file: 'alert.js'
	});
}

document.getElementById('helen').addEventListener('click', hello);