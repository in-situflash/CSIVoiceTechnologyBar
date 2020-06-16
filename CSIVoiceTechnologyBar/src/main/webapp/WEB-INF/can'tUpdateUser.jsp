<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
你是普通用户,没有更改用户权限。
<p></p>
<br />
<a href="${pageContext.request.contextPath}/usermanage/selectAllUser" class="btn btn-default ">返回</a>
</body>
</html>