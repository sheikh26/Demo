<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="stag" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Student Management</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
 href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<link rel="stylesheet"
 href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
 src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js">
</script>
<script
 src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js">
</script>
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Student Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Students</a></li>
			</ul>
		</nav>
	</header>
	</br>
 <div class="container my-2">
        <div class="card">
            <div class="card-body">
             <p class="my-5">
                <a href="/registration" class="btn btn-success">
                Add User</a>
             </p>
   <div class="col-md-10">
   <table class="table table-striped table-responsive-md">
      <tr>
         <th>First Name</th>
         <th>Last Name</th>
         <th>Email Id</th>
         <th></th>
         <th></th>
      </tr>
      <c:forEach items="${studentList}" var="student">
         <tr>
            <td>${student.firstName}</td>
            <td>${student.lastName}</td>
            <td>${student.emailId}</td>
            <td>
               <a class="btn btn-warning" href="/edit?id=${student.id}" >
               Edit</a>
            </td>
            <td>
               <form action="/delete?id=${student.id}" method="post">
                  <input class="btn btn-danger" type="submit" value="Delete" />
               </form>
            </td>
         </tr>
      </c:forEach>
   </table>
     </div>
   </div>
  </div>
</div>
</body>
</html>
