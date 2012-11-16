<%@ page pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8" />
<title>ユーザ作成</title>
<%@ include file="/WEB-INF/include/jquery_ui.jsp" %>
<style type="text/css">
.button {
	font-size: 12px;
}
</style>
<script type="text/javascript">
$(function() {
	$(".button").button();
});

</script>
</head>
<body>
<s:form action="create_user">
	<s:textfield name="userId" label="ユーザID"/>
	<s:password name="password" label="パスワード"/>
	<s:submit value="ユーザ作成" cssClass="button"/><s:reset value="クリア" cssClass="button"/>
</s:form>
</body>
</html>