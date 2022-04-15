// 관리자가 게시물 삭제
function boardDelete() {
	
	let checkBoxArr = [];
	
	$("input:checkbox[name='board_idx']:checked").each(function() {
		// 체크된 값을 뽑아서 배열에 저장
		checkBoxArr.push($(this).val());
	})
	
	if (checkBoxArr != 0) {
		// 체크된 값이 있으면
		$.ajax({
			url : '/Custom/board/adminboardDelete',
			type : 'post',
			data : {checkBoxArr},
			success : function(result) {
				// ajax 처리후 화면 리로드
				location.reload();
			}, error : function() {
			   console.log('Ajax 에러!');
			}
		});
	} else {
		// 체크된 값이 없으면
		alert('삭제 할 게시물을 체크해주세요!');
	}
}