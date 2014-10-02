"use strict"; 
changeState('create');

var toYYYYMMDD = new Date();

function changeState(state) {
	var stateMap = {
			create: 'none',
			detail: 'none'
	};

	stateMap[state] = '';

	var detailClass = document.querySelectorAll('.detail');
	var createClass = document.querySelectorAll('.create');
	$('.detail').css('display', stateMap.detail);
	$('.create').css('display', stateMap.create);

}

//게시글을 저장하는 객체 생성자 함수
function Board(title, content, writer, password) {
	this.title = title;
	this.content = content;
	this.writer = writer;
	this.password = password;
	this.date = new Date();
	this.count = 0;
}

function resetForm() {
	$('#btnCancel').click();
}

var boardList = [];

$('#btnCancel').click(function(event) {
	changeState('create');
});

$('#btnDelete').click(function(event){
	var no = $('#no').val();
	boardList.splice(no, 1);
	refreshBoardList();
	
	resetForm();
	
});

$('#btnChange').click(function(evnet){
	var no = $('#no').val();
	
	console.log(no);
	var board = boardList[no-1];
	console.log(board);
	board.title = $('#title').val();
	board.content = $('#content').val();
	board.writer = $('#writer').val();
	refreshBoardList();
	
	
});


$('#btnAdd').click(function(event) {
	var board = new Board(
			$('#title').val(),
			$('#content').val(),
			$('#writer').val(),
			$('#password').val());

	boardList.push(board);		

	resetForm();

	refreshBoardList();
});

function refreshBoardList() {
	var boardTable = $('#boardTable');
	
$('.dataRow').remove();

	for (var i = boardList.length -1; i >=0;  i--) {
		$('<tr>')
			.appendTo(boardTable)
			.attr('class', 'dataRow')
			.append($('<td>').html(i+1))
			.append($('<td>')
					.append($('<a>')
							.attr('bno', new String(i))
							.attr('href', '#')
							.click(loadBoardDetail)
							.html(boardList[i].title)))
			.append($('<td>').html(boardList[i].writer))
			.append($('<td>').html($.toYYYYMMDD(boardList[i].date)))
			.append($('<td>').html(boardList[i].count));
			
	}
}

function loadBoardDetail(event) {
	event.preventDefault();

	changeState('detail');

	var board = boardList[$(this).attr('bno')];
	$('#no').val(parseInt($(this).attr('bno'))+1);
	$('#title').val(board.title);
	$('#content').val(board.content);
	$('#writer').val(board.writer);
	$('#date').val($.toYYYYMMDD(board.date));
}

















