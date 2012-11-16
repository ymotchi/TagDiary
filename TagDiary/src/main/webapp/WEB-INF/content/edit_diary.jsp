<%@ page pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8" />
<title>日記を編集</title>
<%@ include file="/WEB-INF/include/jquery_ui.jsp" %>
<style type="text/css">
#canvas {
	position: absolute;
	left: 10px;
	top: 10px;
	width: 1024px;
	height: 768px;
	border: 1px solid #000000;
	overflow: scroll;
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
#popup_menu {
	position: absolute;
	display: none;
}
</style>
<script type="text/javascript">
// Struts2が"data[]=foo&data[]=bar"形式に対応していないため
$.ajaxSettings.traditional = true;

$(function() {
	var $targetTag = null;
	$(".tag").resizable().draggable().click(function() {
		// resizable, draggableを使うと、
		// クリック時にフォーカスさせないと、テキストが編集できない
		$(this).focus();
	}).live("contextmenu", function(e) {
		$targetTag = $(this);
		$("#popup_menu").offset({left: e.pageX, top: e.pageY}).show();
		e.preventDefault();
	});
	$("#canvas").dblclick(function(e) {
		var $canvas = $(this);
		$("<div class=\"tag\" contenteditable=\"true\"></div>").appendTo($canvas).offset({left: e.pageX, top: e.pageY}).resizable().draggable().click(function() {
			// resizable, draggableを使うと、
			// クリック時にフォーカスさせないと、テキストが編集できない
			$(this).focus();
		});
	}).click(function() {
		$("#popup_menu").hide();
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
	$("#popup_menu").menu().css("z-index", 99999);
	$("#delete_tag").click(function() {
		$("#popup_menu").hide();
		if ($targetTag != null) {
			$targetTag.remove();
			$targetTag = null;
		}
	});
});
</script>
</head>
<body>
<div id="canvas">
	<ul id="popup_menu">
		<li><a href="javascript:void(0);" id="delete_tag"><span class="ui-icon ui-icon-trash"></span>削除</a></li>
	</ul>
	<c:forEach var="tag" items="${tag}">
		<div class="tag" contenteditable="true" style="left: ${tag.x}px; top: ${tag.y}px; width: ${tag.width}px; height: ${tag.height}px;">${f:escapeXml(tag.contents)}</div>
	</c:forEach>
</div>
<div id="button-area"><button type="button" id="save">保存</button></div>
</body>
</html>