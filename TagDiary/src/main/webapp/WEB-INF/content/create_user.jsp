<%@ page pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8" />
<title>ユーザ作成</title>
</head>
<body>
<s:form action="/create_user">
	<s:textfield name="userId" label="ユーザID"></s:textfield>
	<s:password name="password" label="パスワード"></s:password>
	<s:submit value="ユーザ作成"></s:submit>
</s:form>
</body>
</html>