"use strict";

function help(value){
	return document.getElementById(value);
};

changeState('create');

function changeState(state){
	var stateMap ={
			create : 'none',
			detail : 'none'
	};
	stateMap[state] = '';
	
var detailClass = document.querySelectorAll('.detail');
var createClass = document.querySelectorAll('.create');
	
	for(var i = 0; i < detailClass.length; i++){
		detailClass[i].style.display = stateMap.detail;
	};
	
	for(var i = 0; i < createClass.length; i++){
		createClass[i].style.display = stateMap.create;//감춰라
	};
}

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
	help('btnReset').dispatchEvent(event);
};


function refreshBoardList(){

var boardTable = help('bdTable');
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
	changeState('detail');
		
	var board = boardList[this.getAttribute('bno')];
	help('no').value = parseInt(this.getAttribute('bno'))+1;
	help('title').value = board.title;
	help('content').value = board.content;
	help('writer').value = board.writer;
	help('date').value = toYYYYMMDD(board.date);
};

//버튼추가
help('btnAdd').onclick = function(event){

	var board =new BoardAdd (
			help('title').value,
			help('content').value,
	        help('writer').value,
		    help('password').value
			);	
	boardList.push(board);
	resetBoard();	
	refreshBoardList();
};

//버튼취소
help('btnReset').onclick = function(event){
	changeState('create');
};
