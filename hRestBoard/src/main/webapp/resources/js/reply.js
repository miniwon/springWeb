
$(function(){

$('#replyConfirm').click(function(){
/*	var param = {	bno		: $("#bno").val(),
					replyer	: $("#replyer").val(),
					reply	: $("#reply").val()
				}; */
	var param = $("#replyFrm").serialize();
//alert(param);
//console.log(param);
$.ajax({
type: "post",
url: "../replies/new",
data: param,
success: function(result){
// alert(result);
$("#reply").val(""); },
error: function(err){alert("error"); console.log(err); }
}); // ajax
}); // click

replyList();
function replyList(){
$.ajax({
	type	: 'get',
	url		: "../replies",
	// data	: 보내는 데이터 없음
	dataType: "json",	// 라이브러리 필요
	success	: function(result){
//	alert(result);
//	console.log(result); },
let replyTbl = $("#replyList");
replyTbl.empty();

for (row of result) {
var tr = $("<tr/>");
tr.append($("<td/>").html(row['rno']));
tr.append($("<td/>").html(row['replyer']));
tr.append($("<td/>").html(row['reply']));
tr.append("<td><button class='modify'>수정</button></td>")
tr.append("<td><button class='delete'>삭제</button></td>")
replyTbl.append(tr);
}
},

	error	: function(err){
		alert("error");
		console.log(err);
	}
		
	});
} // for

// 삭제 버튼을 클릭했을 때
// *********************************************
// 동적으로 생성된 버튼은 일반적인 이벤트 발생 불가
//			--> on()
//$(".delete").on("click", (function(){
//alert("잠수충잊어");
//}));

//$("#replyList").on("click","button", function(){alert("잠수충잊어");
//		var btn = $(this);
		
//		if(btn.text() == "수정")
//		{ alert("수정"); }
//		else if(btn.text() == "삭제")
//		{ alert("삭제"); }
//});

$("#replyList").on("click",".delete", function(){
var btn = $(this);
//alert(btn.text());
let rno = $(this).parents("tr").children().eq(0).text();
//alert(replyNo);

$.ajax({
type: "delete",
url: "../replies/" + rno,
success: function(result){replyList();},
error: function(err){
alert("에러");}
});


});
$("#replyList").on("click",".modify", function(){alert("수정");});	

});