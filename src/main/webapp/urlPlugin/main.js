// query
function httpRequest(urlToSave, title, folder, callback) {
	var stocks = localStorage.stocks || 'sh000001';
	// var url = 'http://hq.sinajs.cn/list=' + stocks;
	var url = 'http://localhost:8079/plugin/save'+'?';
	url = url+'url='+urlToSave;
	url = url+'&'+'title='+title;
	url = url+'&'+'folder='+folder;

    var xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            callback(xhr.responseText);
        }
    }
    xhr.send();
}

// render
/*function showResult(result) {
	var table = '<table><thead><tr><th>股票</th><th>最新价</th><th>涨跌幅</th></tr></thead><tbody>';
	var arr = result.split(';').slice(0, -1);
	arr.forEach(function(item){
		var itemArr = item.split('=')[1].split('"')[1].split(','),
			name = itemArr[0];
			curr = Number(itemArr[3]).toFixed(2);
			yest = Number(itemArr[2]).toFixed(2);
			range = (((curr - yest) / yest) * 100).toFixed(2);
		
		table += '<tr>';
		table += '<td>' + name + '</td>';
		table += '<td>' + curr + '</td>';
		table += '<td>' + range + '</td>';
		table += '</tr>';
	})
	table += '</tbody></table>';
	document.getElementById('stock').innerHTML = table;
}*/

function showResult(result) {
	var json = JSON.parse(result);
	if(json.result == 'suc') {
		var span = '<span>保存成功</span>';
        document.getElementById('stock').innerHTML = span;
    }else{
        var span = '<span>保存失败</span>';
        document.getElementById('stock').innerHTML = span;
	}
}

// add
/*document.getElementById('addBtn').onclick = function() {
	var add = document.getElementById('add'),
		addBtn = document.getElementById('addBtn');
		
	var input = document.createElement('input');
	input.type = 'text';
	input.id = 'newStock';

	var saveBtn = document.createElement('input');
	saveBtn.type = 'button';
	saveBtn.id = 'saveBtn';
	saveBtn.value = 'save';

	add.removeChild(addBtn);
	add.appendChild(input);
	add.appendChild(saveBtn);

	document.getElementById('saveBtn').onclick = function() {
		var newStock = document.getElementById('newStock').value;
		var stocks = localStorage.stocks && localStorage.stocks.split(',') || ['sh000001'];
		stocks.push(newStock);
		localStorage.stocks = stocks;
		httpRequest(showResult);

		add.removeChild(input);
		add.removeChild(saveBtn);
		add.appendChild(addBtn);
	}
}*/
document.getElementById('saveUrlBtn').onclick = function() {
    var urlToSave = window.location.href;
    var title = document.title;
	var folder = document.getElementById('folder').value;

	var stocks = localStorage.stocks && localStorage.stocks.split(',') || ['sh000001'];
	stocks.push(folder);
	localStorage.stocks = stocks;

	httpRequest(urlToSave, title, folder, showResult);
}

// httpRequest(showResult);


