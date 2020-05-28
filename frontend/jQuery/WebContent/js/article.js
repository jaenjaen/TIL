
$(function() {
	
	var firstP = $('p:eq(1)');
	//alert(firstP.html()); // == text()
	
	$('a[class=more]').click(function() {
		//alert("clicked");
		if(firstP.is(':hidden')){ //안보이면?
			firstP.slideToggle('slow');
			$(this).html('read less');
		}
		else{ //보이면?
			firstP.slideToggle('slow');
			$(this).html('read more');
		}
	});
	
	var speech = $('div.speech');
	var defaultSize = speech.css('fontSize');
	var num = parseInt(defaultSize,10);
	
	$('#switcher>button').click(function() {
		switch(this.id){
		case 'switcher-large':
			num+=5;
			break;
		case 'switcher-small':
			num-=5;
			break;
		default: num = parseInt(defaultSize,10);
		};
		
		//이거 없으면 안돌아감
		speech.animate({fontSize:num+'px'},'slow');
	})
});