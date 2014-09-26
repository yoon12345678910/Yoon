"use strict";
//태그 그룹핑=> 태그를 모둠으로 묶는다. => class 속성

var elements = document.querySelectorAll('.detail');
for(var i=0; i < elements.length; i++){
	elements[i].style.display = 'none';
};

var boardList = [];

function BoardAdd(title, content, writer, password ){
	this.title = title;
	this.content = content;
	this.writer = writer;
	this.password = password;
	this.date = new Date();
	this.count = 0;	
};

function toYYYYMMDD(date){
	return  date.getFullYear() + '-' +
	(date.getMonth()+1) + '-' +
	date.getDate();
	 
}; 

function resetBoard(){
	var event = new MouseEvent('click',{
		'view': window,
		'bubbles':true,
		'cancleable':true
	});
	document.getElementById('btnReset').dispatchEvent(event);
};


function refreshBoardList(){

	var boardTable = document.getElementById('bdTable');
	var tbody = boardTable.firstElementChild;
	
	for(var i = tbody.children.length -1 ; i > 0; i--){
		console.log(tbody.children[i]);
		tbody.removeChild(tbody.children[i]); 
	};
	
	var tr = null;
	var td = null;
	var a = null;
	var text = null;
	for ( var i = boardList .length -1; i >=0; i--){
		
		console.log(boardList .length);
		tr = document.createElement('tr');
		td = document.createElement('td');
		text = document.createTextNode(i+1);
		td.appendChild(text);
		tr.appendChild(td);
		
		
		td = document.createElement('td');
		a = document.createElement('a');
		a.setAttribute('bno', new String(i));
		a.href = '#';
		a.bno  = new String(i);
		a.onclick = loadBoardDetail;
		text = document.createTextNode(boardList[i].title);
		a.appendChild(text);
		td.appendChild(a);
		tr.appendChild(td);

		
		td = document.createElement('td');
		text = document.createTextNode(boardList[i].writer);
		td.appendChild(text);
		tr.appendChild(td);

		td = document.createElement('td');
		text = document.createTextNode(toYYYYMMDD(boardList[i].date));
		td.appendChild(text);
		tr.appendChild(td);
		
		td = document.createElement('td');
		text = document.createTextNode(boardList[i].count);
		td.appendChild(text);
		tr.appendChild(td);
	
		tbody.appendChild(tr);
		
};
};

function loadBoardDetail(event){
	
	//원래기능하지마
	event.preventDefault();
	
	var detailClass = document.querySelectorAll('.detail');
	var createClass = document.querySelectorAll('.create');
	
	for(var i = 0; i < detailClass.length; i++){
		detailClass[i].style.display = '';
	};
	
	for(var i = 0; i < createClass.length; i++){
		createClass[i].style.display = 'none';//감춰라
	};
	
	
	var board = boardList[this.getAttribute('bno')];
	document.getElementById('no').value = parseInt(this.getAttribute('bno'))+1;
	document.getElementById('title').value = board.title;
	document.getElementById('content').value = board.content;
	document.getElementById('writer').value = board.writer;
	document.getElementById('date').value = toYYYYMMDD(board.date);
};

//버튼추가
document.getElementById('btnAdd').onclick = function(event){

	var board =new BoardAdd (
			document.getElementById('title').value,
			document.getElementById('content').value,
	        document.getElementById('writer').value,
		    document.getElementById('password').value
	
	);

	//console.log(title, content, writer, password );
	
	boardList.push(board);

	resetBoard();	
	
	refreshBoardList();
};

//버튼취소
document.getElementById('btnReset').onclick = function(event){
	
	var detailClass = document.querySelectorAll('.detail');
	var createClass = document.querySelectorAll('.create');
	
	for(var i = 0; i < detailClass.length; i++){
		detailClass[i].style.display = 'none';
	};
	
	for(var i = 0; i < createClass.length; i++){
		createClass[i].style.display = '';//감춰라
	};
};
