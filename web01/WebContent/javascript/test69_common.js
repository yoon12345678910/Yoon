"use strict";
var $ = help;

function help(value){
	var element = null;
	
	if(value instanceof Element){
		element = value;
	}else if(value.charAt(0) =='#'){
		element =  document.getElementById(value.substring(1));
	}else if(value.charAt(0) == '<'){
		element =  document.createElement(
				value.replace(/<|>/g,'')); //g글로벌
	};
	element.text = function(value){
		this.textContent = value;
		return this;
	};
	element.html =function(value){
		this.innerHTML = value;
		return this;
	};	
	element.append = function(child){
		this.appendChild(child);
		return this;
	};
	element.appendTo = function(parent){
		parent.appendChild(this);
		return this;
	};
	element.attr = function(name, value){
		this.setAttribute(name, value);
		return this;
	};
	element.click = function(listener){
		if(listener){
			this.onclick = listener;
		}else {
			var event = new MouseEvent('click',{
				'view': window,
				'bubbles':true,
				'cancleable':true
			});
			$('#btnReset').dispatchEvent(event);
			}
			
		};
	element.val = function(value){
		this.value = value;
		return this;
	};
	element.css = function(name, vlaue){
		this.style[name] = value;
		return this;
	};
	return element;
};



help.toYYYYMMDD = function(date){
	return  date.getFullYear() + '-' +
	(date.getMonth()+1) + '-' +
	date.getDate();
}; 