function join_check() {
	
	let name = $('#name').val();
	let birth = $('#birth').val();
	let nick = $('#nick').val();
	let email = $('#email').val();
	let address = $('#address').val();
	
	let phone = $('#phone').val();
	let phone_reg = RegExp(/^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$/);
	
	let pswd = $('#pswd').val();
	let repeat_pswd = $('#repeat_pswd').val();
		
	
	$('#name_check').text('');
	$('#birth_check').text('');
	$('#nick_check').text('');
	$('#email_check').text('');
	$('#address_check').text('');
	$('#phone_check').text('');
	$('#pswd_check').text('');
	$('#repeat_pswd_check').text('');
	
	if (name == "") {
		$('#name_check').text('이름을 입력해주세요!');
		$('#name_check').css('color', 'red');
		$('#name').focus();
		
		return false;
	}
	
	if (birth == "") {
		
		$('#birth_check').html('생년월일을 입력해주세요! </br> ex)2022-04-08');
		$('#birth_check').css('color', 'red');
		$('#birth').focus();
		
		return false;
	}
	
	if (nick == "") {
		$('#nick_check').text('닉네임을 입력해주세요!');
		$('#nick_check').css('color', 'red');
		$('#nick').focus();
		
		return false;
	}
	
	if (email == "") {
		$('#email_check').text('이메일을 입력해주세요!');
		$('#email_check').css('color', 'red');
		$('#email').focus();
		
		return false;
	}
	
	if (address == "") {
		$('#address_check').text('주소를 입력해주세요!');
		$('#address_check').css('color', 'red');
		$('#address').focus();
		
		return false;
	}
	
	if (!phone_reg.test(phone)) {
		$('#phone_check').html('번호 형식에 맞게 입력해주세요! <br> ex)010-1234-5678');
		$('#phone_check').css('color', 'red');
		$('#phone').focus();
		
		return false
	}
	
	if (pswd == "") {
		$('#pswd_check').text('비밀번호를 입력해주세요!');
		$('#pswd_check').css('color', 'red');
		$('#pswd').focus();
		
		return false;
	}
	
	if (repeat_pswd == "") {
		$('#repeat_pswd_check').text('비밀번호 확인를 입력해주세요!');
		$('#repeat_pswd_check').css('color', 'red');
		$('#repeat_pswd').focus();
		
		return false;
	}
	
	if (pswd != repeat_pswd) {
		$('#pswd_check').text('비밀번호가 서로 일치하지않습니다!');
		$('#pswd_check').css('color', 'red');
		$('#repeat_pswd').focus();
		
		return false;
	}
	
	if (confirm('저장 하시겠습니까?')) {
		
		document.getElementById('register').submit();
		
		return true;
	} else {
		
	 return false;

	}
}

$('#nick').blur(function(){
	
	let nick = $('#nick').val();
	let nick_reg = RegExp(/^[\w\Wㄱ-ㅎㅏ-ㅣ가-힣]{2,30}$/);
	
	$.ajax({
		url : '/Custom/user/nickCheck?custom_user_nick=' + nick,
		type : 'post',
		success : function(result) {
			if (result == 0) {
				$('#nick_check').text('사용할 수 있는 닉네임 입니다!');
				$('#nick_check').css('color', 'green');
			} else {
				$('#nick_check').text('사용할 수 없는 아이디입니다!');
				$('#nick_check').css('color', 'red');
				$('#nick').focus();
			}
			if (!nick_reg.test(nick)) {
				$('#nick_check').text('닉네임은 2글자 이상 30글자 이하로 입력해주세요!');
				$('#nick_check').css('color', 'red');
				$('#nick').focus();
			}
		}, error : function() {
			console.log('Ajax 에러!');
		}
	})
});

$('#email').blur(function() {
	
	let email = $('#email').val();
	let email_reg = RegExp(/^[a-z0-9\.\-_]+@([a-z0-9\-]+\.)+[a-z]{2,6}$/);
	
	$.ajax({
		url : '/Custom/user/emailCheck?custom_user_email=' + email,
		type : 'post',
		success : function(result) {
			if (result == 0) {
				$('#email_check').text('사용할 수 있는 이메일 입니다!');
				$('#email_check').css('color', 'green');
			} else {
				$('#email_check').text('사용할 수 없는 이메일입니다!');
				$('#email_chekc').css('color', 'red');
				$('#email').focus();
			}
			if (!email_reg.test(email)) {
				$('#email_check').text('이메일 형식에 맞게 입력해주세요!');
				$('#email_check').css('color', 'red');
				$('#email').focus();
			}
		}, error : function() {
			console.log('Ajax 에러!');
		}
	})
});