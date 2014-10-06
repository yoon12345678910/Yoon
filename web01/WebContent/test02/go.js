		

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

		
			
