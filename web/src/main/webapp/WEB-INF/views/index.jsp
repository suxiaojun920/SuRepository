<%@page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>index</title>
	</head>
	<body>
		<c:forEach items="${bookList}" var="b">
			<c:out value="${b.bookId}"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<c:out value="${b.bookName}"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<c:out value="${b.bookAuthor}"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<c:out value="${b.bookPrice}"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<c:out value="${b.bookInfo}"/><br/>
		</c:forEach>
	</body>
</html>