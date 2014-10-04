var keypadCode = new Array(0, 49, 50, 51, 52, 53, 54, 55, 56, 57);
var pos = 0;

var currentMole = 0;

state();

function state(){
	currentMole =Math.floor(Math.random()*9)+1; 
	
	console.log("random", currentMole);
	console.log(keypadCode[currentMole]);
	upMole();
	setTimeout("state()", 2000);
}


function upMole(){
	   pos = "b" + keypadCode[ currentMole ];
	  var  url="url('http://img3.wikia.nocookie.net/__cb20131108163037/pokemon/ko/images/c/cf/050_PGL.png')";
	    document.all[pos].style.background = url;
	    setTimeout("downMole()",1000);
}

function downMole(){
	pos = "b" + keypadCode[ currentMole ];
	document.all[pos].style.background = '';
	
}


function hammer () {
		        var keyCode = "b" + (event.keyCode-48);
		        
		        console.log(keyCode);
		        console.log(event.keyCode);
		        
		        document.all[keyCode].innerHTML = "yellow";
 }      