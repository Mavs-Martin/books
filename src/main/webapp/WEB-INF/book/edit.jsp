<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/">Home</a>

	<form:form action='/books/process/edit/${book.id}' method='PUT'
		modelAttribute="book">
	<input type="hidden" name="_method" value="put"/>
	<form:hidden path="seller"/>

		<form:label path="title">Title:</form:label>
		<form:input type="text" path="title" />
		<form:errors path="title" />
		<br>

		<form:label path="author">Author:</form:label>
		<form:input type="text" path="author" />
		<form:errors path="author" />
		<br>

		<form:label path="thoughts">My thoughts:</form:label>
		<form:input type="text" path="thoughts" />
		<form:errors path="thoughts" />
		<br>

		<input type='submit' value='Edit Book'>


	</form:form>

</body>
</html>