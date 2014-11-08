
var pic1;
var pic2;
var gender;
var Snum =1;
var sLeague = 0;
var lLeague = 32;
var image=[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32];
var selected=new Array(16);

var ran1, ran2, url;
var league=32;
var img=0, sel=0;
var i=0;

function shuffle(arr){
	if(arr instanceof Array)
	{
		var length = arr.length;
		if(length == 1) return arr;

		var i = length * 2;
		while(i > 0){
			var idx1 = Math.floor(Math.random()* length);
			var idx2 = Math.floor(Math.random()* length);
			if(idx1 == idx2) continue;
			var temp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = temp;
			i--;
		}
	}else{	alert("No Array Object");	}
	return arr;
}

function first()
{
	if(league==2){
		finishseen(image[img-2])
	}else{
	selected[sel]=image[img-2];
	sel++;
	repeat();
	}
}
function second()
{
	if(league==2){
		finishseen(image[img-1])
	}else{
	selected[sel]=image[img-1];
	sel++;
	repeat();
	}
}

function repeat()
{		
	show();
	league--;
	if(league==17||league==9||league==5||league==3)
	{
		sLeague =0;
		lLeague = lLeague/2; 
	}
	
	if(league==16||league==8||league==4||league==2)
	{
		
		document.getElementById('content').innerHTML=league +"강";
		if(league == 2){
			document.getElementById('content').innerHTML="결승전";
			
		}
		img=0;
		sel=0;
		image=new Array(selected.length);
		for(i=0;i<selected.length;i++)
		{
			image[i]=selected[i];
		}		
		selected=new Array(selected.length/2);
		image=shuffle(image);		
		show();
	}
}

function show()
{
	pic1 = document.getElementById('first');
	pic2 = document.getElementById('second');
    console.log(gender);
	url="url('http://cfs.tistory.com/custom/blog/162/1623443/skin/images/"+gender+image[img]+".png')";
	pic1.style.background=url;
	img++;

	url="url('http://cfs.tistory.com/custom/blog/162/1623443/skin/images/"+gender+image[img]+".png')";
	pic2.style.background=url;
	img++;
	
}
function finishseen(a)
{
	document.getElementById('content').innerHTML="우승";
	document.getElementById('number').innerHTML="1/1";
	var vs = document.getElementById('vs');

	pic1 = document.getElementById('first');
	pic2 = document.getElementById('second');
	
	
	
	url="url('http://i.stack.imgur.com/eLsS8.png')";
	vs.style.background=url;
	
	url="url('http://cfs.tistory.com/custom/blog/162/1623443/skin/images/"+gender+a+".png')";
	pic1.style.background=url;
	
	url="url('win.png')";
	pic2.style.background=url;	
}


function open1(value)
{
	sLeague++;
	document.getElementById('number').innerHTML=sLeague+"/"+lLeague/2;
	
	  var info = value.split(',')[1];

	  if(Snum==value.split(',')[0]){
		  this.gender=value.split(',')[1];
	 
		  	if(value.split(',')[1] =='m'){
		  		document.getElementById('selectBtn').innerHTML="남자 연예인";
		  		}else{
		  			document.getElementById('selectBtn').innerHTML="여자 연예인";
		  		}
	   
		  	Snum++;
		  	image=shuffle(image);
		  	document.getElementById('content').innerHTML="32강";
		 
		  	show();
			
	  }else if('m' == value.split(',')[1]){
		  first();
	  }else if('g' ==  value.split(',')[1]){
		  second();

	  }
}


