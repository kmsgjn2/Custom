function insert_check() {
	
	// 입력값 유효성
  	let writer = $('#writer').val();
  	let title = $('#title').val();
  	let text = $('#text').val();
      	
  	$('#writer_check').text('');
  	$('#title_check').text('');
  	$('#text_check').text('');
    	
  	if (writer == "") {
  		$('#writer_check').text('작성자를 입력해주세요!');
  		$('#writer_check').css('color', 'red');
  		$('#writer').focus();
  		
  		return false;
  	}
  	
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
	
  		document.getElementById('boardInsert').submit();

  		return true;

  	} else {
	
  		return false;
  	}
};
  
// 파일 선택시 이미지 보이게 하기
$('#file').on("change", function(event) {
	
	let file = event.target.files[0];
	
	let reader = new FileReader();
	
  	reader.onload = function(e) {
		$('#fileView').attr("src", e.target.result);
   	}
   	 
	reader.readAsDataURL(file);
});
       
// 파일 선택후 이미지 temp 폴더에 임시저장 하기          
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