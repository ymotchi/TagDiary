<%@ page pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8" />
<title>日記を編集</title>
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/themes/ui-lightness/jquery-ui.css" type="text/css" />
<style type="text/css">
#canvas {
	position: absolute;
	left: 10px;
	top: 10px;
	width: 1024px;
	height: 768px;
	border: 1px solid #000000;
	overflow: hidden;
}
#button-area {
	position: absolute;
	left: 50px;
	top: 800px;
	width: 1024px;
	height: 20px;
	text-align: center;
}
.tag {
	position: absolute;
	width: 140px;
	height: 80px;
	border: 1px solid #000000;
	background-color: #ffffff;
	padding: 3px;
	word-break: break-all;
	word-wrap: break-word;
	overflow: hidden;
}
</style>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
<script type="text/javascript">
$.ajaxSettings.traditional = true;

$(function() {
	$(".tag").resizable().draggable().click(function() {
		// resizable, draggableを使うと、
		// クリック時にフォーカスさせないと、テキストが編集できない
		$(this).focus();
	});
	$("#canvas").dblclick(function(e) {
		var $canvas = $(this);
		$("<div class=\"tag\" contenteditable=\"true\"></div>").css({left: e.pageX - $canvas.offset().left, top: e.pageY - $canvas.offset().top}).appendTo(this).resizable().draggable().click(function() {
			// resizable, draggableを使うと、
			// クリック時にフォーカスさせないと、テキストが編集できない
			$(this).focus();
		});
	});
	$("#save").button().click(function() {
		var data = $(".tag").map(function() {
			var $tag = $(this);
			var position = $tag.position();
			return position.left + "," + position.top + "," + $tag.width() + "," + $tag.height() + "," + $tag.text();
		}).get();
		$.post('<s:url action="save"/>', {data: data}).success(function() {
			alert("保存しました");
		}).error(function() {
			alert("保存に失敗しました");
		});
	});
});
</script>
</head>
<body>
<div id="canvas">
	<c:forEach var="tag" items="${tag}">
		<div class="tag" contenteditable="true" style="left: ${tag.x}px; top: ${tag.y}px; width: ${tag.width}px; height: ${tag.height}px;">${f:escapeXml(tag.contents)}</div>
	</c:forEach>
</div>
<div id="button-area"><button type="button" id="save">保存</button></div>
</body>
</html>