// 파일 찾기 이미지 보이기
$('#file').on("change", function(event) {

	 let file = event.target.files[0];
	 let reader = new FileReader();
	 
  	 reader.onload = function(e) {
	 	$('#fileView').attr("src", e.target.result);
	 	$('#fileView').css('display','block');
 	 }
 	 reader.readAsDataURL(file);
 })

// 입력 유효성 검사
function modi_check() {
	
  	let title = $('#title').val();
  	let text = $('#text').val();
  	
  	$('#title_check').text('');
  	$('#text_check').text('');
  	
  	if (title == "") {
  		$('#title_check').text('제목을 입력해주세요!');
  		$('#title_check').css('color', 'red');
  		$('#title').focus();
  		
  		return false;
  	}
  	
  	if (text == "") {
  		$('#text_check').text('내용을 입력해주세요!');
  		$('#text_check').css('color', 'red');
  		$('#text').focus();
  		
  		return false;
  	}
  	
  	if (confirm('저장 하시겠습니까?'))	{
	
  		document.getElementById('boardDetailModi').submit();

  		return true;
  	} else {
	
  		return false;
  	}
}

// 파일 삭제
$(document).ready(function () {
	$('#fileDelete').click(function () {
		
		let fileName = $('#img_path').val();
		let board_idx = $('#board_idx').val();
		
		let inputFile = $("input[name='file']");
		
		let files = inputFile[0].files;

		if (fileName == null) {
			// DB에 파일이 없을 경우 ex) 기존 파일이 없는데 파일 찾기를 한 후 파일 삭제를 누른 경우 
 			$('#fileView').css('display','none');
			$('#file').val("");
		} 
		
		// 선택된 파일이 없을경우
		if (!file && fileName == undefined) {
 			$('#fileView').css('display','none');
			$('#file').val("");
			alert('삭제 할 파일이 없습니다!');
		}
		
		if (files.length == 0 && fileName == '') {
			alert('삭제 할 파일이 없습니다!');
		} else if (fileName != null && files.length == 0) {
			
			// DB에 파일이 있는 경우
			$.ajax({
				url : '/Custom/board/fileDelete?img_path=' + fileName +'&board_idx=' + board_idx,
				success : function () {
					alert('파일 삭제 완료!');
					$('#fileView').css('display','none');
					$('#img_path').val('');
					$('#file').val('');
					
				}, error : function () {
					console.log('Ajax 에러!');
				}
			});			
		}
	});
});

// 파일 저장
$(document).ready(function () {
	$("#uploadBtn").on("click", function (e) {
		let formData = new FormData();
		
		let inputFile = $("input[name='file']");
		
		let files = inputFile[0].files;
		
	
		
		if (files.length > 0) {
			
			for (let i = 0; i < files.length; i++) {
				formData.append("file", files[i]);
			}
			
			$.ajax({
				url : '/Custom/board/boardFile',
				enctype : 'multipart/form-data',
				processData : false,
				contentType : false,
				data : formData,
				type : 'post',
				success : function () {
					alert("임시저장 완료!");				
				}, error : function () {
					console.log('Ajax 에러!');
				}
			});
		} else {
			alert("파일을 선택해주세요!");	
		}
	});
});