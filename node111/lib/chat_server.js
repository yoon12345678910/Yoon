var socketio = require('socket.io');
var io;
var guestNumber = 1;
var chat = 'chat';
var name;
var nickName = {};
var nameUsed = [];

exports.listen = function(server){
	io = socketio.listen(server);
	io.set('log level', 1);
	
	io.sockets.on('connection', function(socket){
		name = 'Guest' + guestNumber;
		
		nickName[socket.id] = name;
		console.log("들어옴", nickName);
		
		socket.join(chat);
		
		handleNameChange(socket, nickName, nameUsed);
		handleMessageBroadcasting(socket);
		handleClientDisconnection(socket);
		guestNumber++;
	});
	
	
	function handleNameChange(socket, nickName, nameUsed){
		socket.on('nameChange', function(name){
			var previousName = nickName[socket.id];
			var previousIndex = nameUsed.indexOf(previousName);
			
			nameUsed.push(name);
			nickName[socket.id] = name;
			
			delete nameUsed[previousIndex] ;
			console.log("닉네임지우기", nameUsed);
		});
	}
	
	function handleMessageBroadcasting(socket){
		socket.on('message', function(message){
			socket.broadcast.to(chat).emit('message', 
					{text: nickName[socket.id] + ':' + message});
		});
	};
	
	function handleClientDisconnection(socket){
		socket.on('disconnect', function(){
			guestNumber--;
			console.log("나감",name);
		});
	}
}







