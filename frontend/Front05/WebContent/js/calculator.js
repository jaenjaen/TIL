var tmp = ' ';
	var result = ' ';
	
	function clickButton(num){
		var output = document.getElementById('output');
		var arr = new Array();
		
		if(num == "="){
			if(tmp == ' '){
				checkingSpace();
			}
			else {
				output.value= eval(tmp);
				arr.push(tmp+"= "+eval(tmp));
				
				for(var i=0; i<arr.length;i++){
					result += "-" + arr[i] + '<br>';
				}
				document.getElementById('outputlist').innerHTML = result;
				
				tmp = ' ';
				output.value = "0.0";
			}
		}
		else if(num == 'clear'){
			tmp = ' ';
			output.value = "0.0";
		}
		else {
			tmp += num;
			output.value= tmp;
		}
	}
	
	function checkingSpace(){
		alert("값을 입력해주세요");
	}