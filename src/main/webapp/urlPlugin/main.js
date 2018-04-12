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

document.getElementById('saveUrlBtn').onclick = function() {
    var urlToSave = window.location.href;
    var title = document.title;
    var folder = document.getElementById('folder').value;

    var stocks = localStorage.stocks && localStorage.stocks.split(',') || ['sh000001'];
    stocks.push(folder);
    localStorage.stocks = stocks;

    httpRequest(urlToSave, title, folder, showResult);
}

var url = document.origin+'/plugin/folder/all';
$.ajax({
    url : url,
    type : "post",
    dataType : "json",
    success : function () {
        alert("suc");
    },
    error : function () {
        alert("error");
    }
});

function getTree() {
    // Some logic to retrieve, or generate tree structure
    var tree = [
        {
            text: "Parent 1",
            nodes: [
                {
                    text: "Child 1",
                    nodes: [
                        {
                            text: "Grandchild 1"
                        },
                        {
                            text: "Grandchild 2"
                        }
                    ]
                },
                {
                    text: "Child 2"
                }
            ]
        },
        {
            text: "Node 2",
            icon: "glyphicon",
            selectedIcon: "glyphicon",
            color: "#000000",
            backColor: "#FFFFFF",
            href: "#node-1",
            selectable: true,
            state: {
                checked: true,
                disabled: false,
                expanded: false,
                selected: true
            },
            tags: ['available'],
            nodes: [
                {
                    text: "Child 1",
                    nodes: [
                        {
                            text: "Grandchild 1"
                        },
                        {
                            text: "Grandchild 2"
                        }
                    ]
                },
                {
                    text: "Child 2"
                }
            ]
        },
        {
            text: "Parent 3"
        },
        {
            text: "Parent 4"
        },
        {
            text: "Parent 5"
        }
    ];

    return tree;
}
/*
$('#tree').treeview({
    data: getTree(),
    onNodeSelected: function (event, data) {
        alert("event");
    }
});
*/




