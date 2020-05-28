$(function () {
	
	//비디오 교체
	$('button[value^=pre').on('click',function() {
		var txt = $(this).val();
		var src = "";
		
		switch(txt){
		case 'prePanda':
			src = "media_img/KungFuPanda_Sample.mp4";
			break;
		case 'preAvg':
			src = "media_img/avengers.mp4";
			break;
		case 'preBb':
			src="media_img/BigBuck.theora.ogv";
			break;
		};
		
		$('video').attr('src',src);
	})
	//storage저장
	$('button[value^=heart]').on('click',function() {
		var txt = $(this).val();
		var key = 0;
		var vals= [];
		
		switch(txt){
		case 'heartPanda':
			key = 1001;
			vals.push('media_img/movie_image2.jpg');
			vals.push('쿵푸팬더');
			vals.push('3000');
			break;
		case 'heartAvg':
			key = 1002;
			vals.push('media_img/TheAvengers2012Poster.jpg');
			vals.push('어벤저스');
			vals.push('3000');
			break;
		case 'heartBb':
			key = 1003;
			vals.push('media_img/BigBuck.jpg');
			vals.push('빅벅');
			vals.push('3000');
			break;
		};
		
		if(window.localStorage){
			if(localStorage.getItem(key)){
				alert("이미 리스트에 존재하는 아이템입니다.");
				}
			else{
				localStorage.setItem(key,vals);
				alert(key+": "+vals.toString());
			}
		}
		else{
			alert("본 환경은 찜 리스트를 지원하지 않습니다.");
		}
	});
});
