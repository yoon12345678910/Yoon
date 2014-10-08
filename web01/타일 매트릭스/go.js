<<<<<<< HEAD
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
=======
		

			var c= 4;
			var ranForm = new Array(6);
			var successForm = new Array(6);
			var faultForm = new Array(6);
			var count = 0;
			var cCount = 0;
			var fCount = 0;
			var mCount = 0;
			var mFlag = true;
			var cFlag = false;
			var clickN=0;
			 while(count < 6) {         
				   var ran = Math.floor(Math.random()*(c*c))+1;     
		           for(var i=0; i<count; i++)
		              if(ranForm[i] == ran) mFlag = false;
		           if(mFlag){
		        	   ranForm[count] = ran;
		                count++;
		           } mFlag = true;
		       } 

		    
		    console.log(ranForm[0]+', '+ranForm[1]+', '+ranForm[2]+', '+ranForm[3]+', '+ranForm[4]+', '+ranForm[5]);
		    create();

		    function create(){
		
				for(var a = 0; a < c; a++){
					$('<tr>').attr('trNo', new String(a)).appendTo('table');	
				}
				
				for(var b= 0; b<c; b++){
					$('tr').append($('<td>').attr('tdNo',new String(b)));
				}
				
			com();
		    }

		function com(){
			for(var a in ranForm){
				$('td').eq(ranForm[a]).addClass('selectedRan');
			}
		    setTimeout("disappear()",1000);

		};	
			
		function disappear(){
			for(var a in ranForm){
				$('td').eq(ranForm[a]).removeClass('selectedRan');
			}
		};
		
	$('td').click(function(event) {
		
				
				if(mCount>=6){
					for(var a in ranForm){
					$('td').eq(ranForm[a]).addClass('selectedRan');
					$('td').eq(successForm[a]).html('OK');
					$('td').eq(faultForm[a]).html('NO');
					}
				}else{
					$('td').eq($('td').index(this)).addClass('selected');
					mCount++;
				 for(var i=0; i<6; i++)
			         if(ranForm[i] == $('td').index(this))cFlag = true;
				 
			         
			         if(cFlag){
			         successForm[cCount]=$('td').index(this);
			         console.log(successForm[cCount]);
			         cCount++;
			         cFlag = false;
			         }else{
			        faultForm[fCount]=$('td').index(this);
			        fCount++;
			        console.log(faultForm[cCount]);
			         }
			         
				}  
			         

	            	  

		});

		
			
>>>>>>> branch 'origin' of https://github.com/yoon12345678910/Yoon.git
