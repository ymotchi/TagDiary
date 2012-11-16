<%@ page pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8" />
<title>ログイン</title>
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
<s:form action="login">
	<s:textfield name="userId" label="ユーザID"/>
	<s:password name="password" label="パスワード"/>
	<s:submit value="ログイン" cssClass="button"/><s:reset value="クリア" cssClass="button"/>
</s:form>
</body>
</html>