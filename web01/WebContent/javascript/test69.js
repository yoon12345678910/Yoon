"use strict";
changeState('create');

var boardList = [];

function changeState(state){
	var stateMap ={create : 'none', detail : 'none'};
	stateMap[state] = '';
	
	var detailClass = document.querySelectorAll('.detail');
	var createClass = document.querySelectorAll('.create');
	
	for(var i = 0; i < detailClass.length; i++){
		$(detailClass[i]).css('display', stateMap.detail);
	};
 	for(var i = 0; i < createClass.length; i++){
 		$(createClass[i]).css('display', stateMap.create);
	};
}

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
	$('#btnReset').click(function(event){
		changeState('create');
	});
};

function refreshBoardList(){

var boardTable = $('#bdTable');
var tbody = boardTable.firstElementChild;

console.log('aa',tbody);
for(var i = tbody.children.length -1 ; i > 0; i--){
	tbody.removeChild(tbody.children[i]); 
	
	console.log('bb',tbody);
};

	for ( var i = boardList .length -1; i >=0; i--){
		$('<tr>')
		.appendTo(tbody)
		.append($('<td>').html(i))
		.append($('<td>')
				.append($('<a>')
						.attr('bno', new String(i))
						.attr('href', '#')
						.click(loadBoardDetail)
						.html(boardList[i].title)))
		.append($('<td>').html(boardList[i].writer))
		.append($('<td>').html($.toYYYYMMDD(boardList[i].date)))
		.append($('<td>').html(boardList[i].count));
		
		};
};

function loadBoardDetail(event){
	event.preventDefault();
	changeState('detail');
		
	var board = boardList[this.getAttribute('bno')];
	$('#no').value = parseInt(this.getAttribute('bno'))+1;
	$('#title').value = board.title;
	$('#content').value = board.content;
	$('#writer').value = board.writer;
	$('#date').value =$. toYYYYMMDD(board.date);
};

$('#btnAdd').click( function(event){
	var board =new BoardAdd (
				$('#title').value,
				$('#content').value,
	        	$('#writer').value,
		    	$('#password').value
			);	
	boardList.push(board);
	resetBoard();	
	refreshBoardList();
});

$('#btnReset').click(function(event){
	changeState('create');
});
