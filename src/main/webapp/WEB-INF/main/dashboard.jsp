<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Dash</h1>
<a href="/users/logout">Logout</a>
<a href="/books/create">Add Book</a>

	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${allBooks}">
				<tr>
					<td><a href="/books/${book.id}"><c:out value="${book.title}" /></a></td>
					<td><c:out value="${book.author}" /></td>
					<td><c:out value="${book.seller.userName}" /></td>
					
					<td>
					<c:if test="${book.seller.id == user_id}">
					<a href="/books/edit/${book.id }">Edit</a>
					
					<form action="books/delete/${book.id }" method="post">
				
					<input type="hidden" name="_method" value="delete"/>
					<input type="submit" value="delete"/>
					</form>
					</c:if>
					
						<c:if test="${book.seller.id != user_id}">
					<a href="/books/${book.id}">View</a>
					</c:if>
					
					</td>
					
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>