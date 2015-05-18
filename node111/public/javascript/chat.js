var socket = io.connect();

$(document).ready(function(){

	socket.on('message', function(message){
		$('#messages').append($('<div></div>').text(message.text));
	});
	
	$('#send-form').submit(function(){
		var message = $('#send-message').val();
		userInput(message);
		$('#send-message').val('');
		return false;
	});
	
	
	function userInput(message){
		if(message.charAt(0) == '/'){
			var name = message.split(' ');
			socket.emit('nameChange', name[1]);
		}else{
			socket.emit('message', message);
			$('#messages').append($('<div></div>').html('<i>' + message +' </i>'));
			$('#messages').scrollTop($('#messages').prop('scrollHeight'));
		}
	}
	
});

		
		
		
		
		
		
		

