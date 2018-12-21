<%@page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>主页</title>
	</head>
	
	<body>
		<div style="width:1000px; border:solid 1px;">
			<form action="" method="post">
				<table width="100%">
					<tr>
						<td>编号</td>
						<td>名称</td>
						<td>作者</td>
						<td>价格</td>
						<td>信息</td>
					</tr>
					<c:forEach items="${bookList}" var="b">
						<tr>
							<td>${b.bookId}</td>
							<td>${b.bookName}</td>
							<td>${b.bookAuthor}</td>
							<td>${b.bookPrice}</td>
							<td>${b.bookInfo}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5" align="right">
							<a href="loadAll?page=1&rows=10">首页</a>
							<a href="loadAll?page=${currentPage-1}&rows=10">上一页</a>
							<a href="loadAll?page=${currentPage+1}&rows=10">下一页</a>
							<a href="loadAll?page=${maxPage}&rows=10">末页</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>