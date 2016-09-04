<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Location List</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" crossorigin="anonymous">
<link
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"
	rel="stylesheet">
</head>
<body>

<%@include file="navigation.jsp" %>

	<div class="row">
		<div class="col-md-4 col-md-offset-4">
	<legend>Location List</legend>
	 
			<table id="list" class="table table-hover">
				<thead>
					<tr>
						<th>Location ID</th>
						<th>Name</th>
						<th>Status</th>
						<th>Edit</th>
						<th></th>
					</tr>
				</thead>
				 <tbody>
				 	 
				<c:forEach items="${locations}" var="temp">
					<tr>
						<td>${temp.location_id}</td>
						<td>${temp.name}</td>
						<td><c:choose>
									<c:when test="${temp.status==1}">
										<span class="label label-success">Active</span>
									</c:when>
									<c:otherwise>
										<span class="label label-danger">Inactive</span>
									</c:otherwise>
								</c:choose>
						</td>
						<td><a class="btn btn-primary"
							href="<c:url value='/edit-${temp.location_id}-location' />">Edit</a></td>
						<td>
						<c:choose>
									<c:when test="${temp.status==1}">
										<a class="btn btn-danger" href="<c:url value='/location/${temp.location_id}/0' />" >Deactivate</a>
									</c:when>
									<c:otherwise>
										<a class="btn btn-success" href="<c:url value='/location/${temp.location_id}/1' />" >Activate</a>
									</c:otherwise>
								</c:choose>
								</td>
					</tr>
				</c:forEach>
				 </tbody>
			
			</table><br />
			<a href="<c:url value='/locationForm' />" class="btn btn-primary pull-right">Add New</a>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->

	
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.12.3.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#list').DataTable();
		});
	</script>

</body>
</html>