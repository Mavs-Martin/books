<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/">Home</a>

	<h1>${book.seller.userName} read ${book.title} by ${book.author }</h1>

	<p>Here are ${book.seller.userName} thoughts:</p>

	<p>${book.thoughts }</p>

<c:if test="${book.seller.id == user_id}">
	<form action="/books/delete/${book.id }" method="POST">
		<input type="hidden" name="_method" value="delete" /> <input
			type="submit" value="delete" />

<a href="/books/edit/${book.id }">Edit</a>

	</form>
</c:if>	
	
	
	
	
	
	
</body>
</html>