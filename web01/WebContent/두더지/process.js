var keypadCode = new Array(0, 49, 50, 51, 52, 53, 54, 55, 56, 57);
var pos = 0;

var currentMole = 0;

state();

function state(){
	currentMole =Math.floor(Math.random()*9)+1; 

/*	console.log("random", currentMole);
	console.log(keypadCode[currentMole]);*/
	upMole();
	setTimeout("state()", 750);
}


function upMole(){
	   pos = "b" + keypadCode[ currentMole ];
	  var  url="url('mole.png')";
	    document.all[pos].style.background = url;
	    setTimeout("downMole()",750);
}

function downMole(){
	pos = "b" + keypadCode[ currentMole ];
	document.all[pos].style.background = '';
	document.all[pos].innerHTML = '';
}

function hit(){
	pos = "b" + keypadCode[ currentMole ];
	var  url="url('hit.png')";
	document.all[pos].style.background = url;
	/*document.all[pos].innerHTML = 'hit';
	document.all[pos].style.color = "red";*/
}


function hammer () {
	var keyCode = "b" + (event.keyCode-48);
	
	console.log(keyCode);
	console.log(keypadCode[ currentMole ]);
	if(event.keyCode-48 == keypadCode[ currentMole ]){
		console.log("hit");
		hit();
	}
 }      