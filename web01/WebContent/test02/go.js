var cell = 3;
var level = 1;
var RanForm;
var SuccessForm;
var FaultForm;
var count;
var selectCount;
var faultCount;
var clickCount;
var ranFlag;
var existFlag;

create();

function levelUp() {
	cell++;
	level++;
	create();
}

function removeTable() {
	$('#t1').empty();
}

function create() {

	$('#d1').html("Level : " + level);

	RanForm = new Array(6);
	SuccessForm = new Array();
	FaultForm = new Array();

	randomCount = 0;
	selectCount = 0;
	faultCount = 0;
	clickCount = 0;
	ranFlag = true;
	existFlag = false;

	while (randomCount < 6) {

		var ran = Math.floor(Math.random() * (cell * cell));

		for (var i = 0; i < randomCount; i++)
			if (RanForm[i] == ran)
				ranFlag = false;

		if (ranFlag) {
			RanForm[randomCount] = ran;
			randomCount++;
		}
		ranFlag = true;
	}

	for (var a = 0; a < cell; a++) {
		$('<tr>').fadeIn(1500).appendTo('table');
	}
	for (var b = 0; b < cell; b++) {
		$('tr').append($('<td>').attr('tdNo', new String(b)));
	}
	paint();
}

function paint() {
	for ( var a in RanForm) {
		$('td').eq(RanForm[a]).addClass('selectedTrue');
	}
	setTimeout("disappear()", 1000);
};

function disappear(event) {

	$('td').removeClass('selectedTrue');
};

function decision() {

	if (clickCount == 6) {
		for ( var a in RanForm) {
			$('td').eq(RanForm[a]).addClass('selectedTrue');
			$('td').eq(SuccessForm[a]).html('OK');
			$('td').eq(SuccessForm[5]).html('V');
			$('td').eq(FaultForm[a]).html('NO').css('color', 'red');
		}

		if (SuccessForm.length == 6) {
			setTimeout(function() {
				removeTable();
				levelUp();
			}, 2000);

		} else {
			setTimeout(function() {
				removeTable();
				create();
			}, 2000);
		}

	}
};

$(document).on('click', 'td', function(event) {

	if (clickCount < 6) {

		++clickCount;

		$('td').eq($('td').index(this)).addClass('selected');

		for (var i = 0; i < 6; i++)
			if (RanForm[i] == $('td').index(this))
				existFlag = true;

		if (existFlag) {
			SuccessForm[selectCount] = $('td').index(this);
			selectCount++;
			existFlag = false;

		} else {
			FaultForm[faultCount] = $('td').index(this);
			faultCount++;
		}

		decision();

	}
});