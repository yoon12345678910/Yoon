

var boardList = [];

function boardForm(title, context,  writer, password){
	this.title = title;
	this.context = context;
	this.writer = writer;
	this.password = password;
	this.date = new Date();
	this.count = 0;
};

function refreshBoardList(){
	var tableView = document.getElementById('tableView');

	var tBody = tableView.firstElementChild;

	for(var i = tBody.children.length - 1; i > 0; i-- ){
		
		tBody.removeChild(tBody.children[i]);
	
	};

	var tr = null;
	var td = null;
	var text = null;
	var a = null;
		
	for(var i = boardList.length -1; i >=0; i--){
		
		  tr = document.createElement('tr');
		  td= document.createElement('td');
		  text = document.createTextNode(parseInt(i)+1);
		  td.appendChild(text);
		  tr.appendChild(td);
		  
		 td= document.createElement('td');
		 a= document.createElement('a');
		 a.setAttribute('bno', new String(i+1));
		 a.href = '#';
		 a.onclick = boardDetail;
		 text = document.createTextNode(boardList[i].title);
		 a.appendChild(text);
		 td.appendChild(a);
		 tr.appendChild(td);
		 
		 td= document.createElement('td');
		 text = document.createTextNode(boardList[i].writer);
		 td.appendChild(text);
		 tr.appendChild(td);
		 
		 td= document.createElement('td');
		 text = document.createTextNode(boardList[i].date);
		 td.appendChild(text);
		 tr.appendChild(td);
		 
		 td= document.createElement('td');
		 text = document.createTextNode(boardList[i].count);
		 td.appendChild(text);
		 tr.appendChild(td);
		  
		  tBody.appendChild(tr);
	};
	
};

function resetBoard(){
	var event = new MouseEvent('click',{});
	document.getElementById('btnCancle').dispatchEvent(event);
};


document.getElementById('btnAdd').onclick = function(event){
	var board = new boardForm(
			document.getElementById('title').value,
			document.getElementById('context').value,
			document.getElementById('writer').value,
			document.getElementById('password').value	
	);
	boardList.push(board);
	resetBoard();
	refreshBoardList();
};

function boardDetail(event){
	event.preventDefault();
	
	var classDetail = document.querySelectorAll('.detail');
	var classCreate = document.querySelectorAll('.create');
	
	
};