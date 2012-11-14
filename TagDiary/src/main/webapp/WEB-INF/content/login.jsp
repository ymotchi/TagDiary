<%@ page pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8" />
<title>ログイン</title>
</head>
<body>
<s:form action="/login">
	<s:textfield name="userId"></s:textfield>
	<s:password name="password"></s:password>
	<s:submit value="ログイン"></s:submit><s:reset></s:reset>
</s:form>
</body>
</html>