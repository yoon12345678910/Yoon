
//사진 girl1, girl2
var pic1;// = document.getElementById('girl1');
var pic2;// = document.getElementById('girl2');
var main;// = document.getElementById('main');
var pro;// = document.getElementById('process');
var fin;// = document.getElementById('finish');
var winner;// = document.getElementById('winner');
var mimage;// = document.getElementById('image');
var fimage;// = document.getElementById('fimage');
var pimage;// = document.getElementById('pimage');

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
			
			console.log(idx1);
			console.log(idx2);
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
	if(league==2){finishseen(image[img-2])}
	else{

	selected[sel]=image[img-2];
	sel++;
	repeat();}
}
function second()
{
	if(league==2){finishseen(image[img-1])}
	else{
	selected[sel]=image[img-1];
	sel++;
	repeat();}
}
function start()
{
	main = document.getElementById('main');
	pro = document.getElementById('process');
	fin = document.getElementById('finish');
	
	main.style.display='block';
	fin.style.display='none';
	pro.style.display='none';
}

function repeat()
{		
	
	show();
	leaguecheck();
	league--;
	if(league==16||league==8||league==4||league==2)
	{
	/*	main = document.getElementById('main');
		pro = document.getElementById('process');
		fin = document.getElementById('finish');
		
		main.style.display='none';
		fin.style.display='none';
		pro.style.display='block';*/
		
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
	pic1 = document.getElementById('firstImage');
	pic2 = document.getElementById('secondImage');

	url="url('http://cfs.tistory.com/custom/blog/162/1623443/skin/images/g"+image[img]+".png')";
	pic1.style.backgroundImage=url;
	img++;

	url="url('http://cfs.tistory.com/custom/blog/162/1623443/skin/images/g"+image[img]+".png')";
	pic2.style.backgroundImage=url;
	img++;
	
}
function finishseen(a)
{
	/*main = document.getElementById('main');
	pro = document.getElementById('process');
	fin = document.getElementById('finish');
	fimage = document.getElementById('fimage');
	winner = document.getElementById('winner');
	main.style.display='none';
	pro.style.display='none';
	fin.style.display='block';*/
	
	/*url="url('http://cfs.tistory.com/custom/blog/162/1623443/skin/images/fin_win.png')";
	fimage.style.backgroundImage=url;
	url="url('http://cfs.tistory.com/custom/blog/162/1623443/skin/images/g"+a+".png')";
	winner.style.backgroundImage=url;	*/
}
function leaguecheck()
{
	/*mimage = document.getElementById('image');
	pimage = document.getElementById('pimage');
	
	if(league>17){ mimage.style.backgroundImage="url('http://cfs.tistory.com/custom/blog/162/1623443/skin/images/all_32.png')"; pimage.style.backgroundImage="url('http://cfs.tistory.com/custom/blog/162/1623443/skin/images/pro_32.png')"; }
	else if(league>9){ mimage.style.backgroundImage="url('http://cfs.tistory.com/custom/blog/162/1623443/skin/images/all_16.png')"; pimage.style.backgroundImage="url('http://cfs.tistory.com/custom/blog/162/1623443/skin/images/pro_16.png')"; }
	else if(league>5){ mimage.style.backgroundImage="url('http://cfs.tistory.com/custom/blog/162/1623443/skin/images/all_8.png')"; pimage.style.backgroundImage="url('http://cfs.tistory.com/custom/blog/162/1623443/skin/images/pro_8.png')"; }
	else if(league>3){ mimage.style.backgroundImage="url('http://cfs.tistory.com/custom/blog/162/1623443/skin/images/all_4.png')"; pimage.style.backgroundImage="url('http://cfs.tistory.com/custom/blog/162/1623443/skin/images/pro_4.png')"; }
	else { mimage.style.backgroundImage="url('http://cfs.tistory.com/custom/blog/162/1623443/skin/images/all_final.png')"; pimage.style.backgroundImage="url('http://cfs.tistory.com/custom/blog/162/1623443/skin/images/pro_final.png')"; }
*/}

function open()
{
	/*pro = document.getElementById('process');
	fin = document.getElementById('finish');
	main = document.getElementById('main');
	
	pro.style.display='none';
	fin.style.display='none';
	main.style.display='block';*/
		
	image=shuffle(image);
	leaguecheck();
	show();
}


