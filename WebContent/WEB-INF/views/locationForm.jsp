<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location Form</title>
<style type="text/css">
form .error {
	color: #ff0000;
}
</style>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" crossorigin="anonymous">
</head>
<body>
	<%@include file="navigation.jsp"%>
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<form:form method="POST" class="form-horizontal" id="form"
				modelAttribute="location">
				<fieldset>
					<!-- Form Name -->
					<legend>Location Details</legend>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="textinput">City
						</label>
						<div class="col-sm-10">
							<form:input path="name" id="name" required="required"
								class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="pull-right">
								<c:choose>
									<c:when test="${edit}">
										<input type="submit" class="btn btn-primary" value="Update" />
									</c:when>
									<c:otherwise>
										<input type="submit" class="btn btn-primary" value="Save" />
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#form").validate({
				rules : {
					name : {
						required : true,
						minlength : 5
					}
				},
				messages : {
					name : {
						required : "This is rquired",
						minlength : "Minimum length is 5"
					}
				},
				submitHandler : function(form) {
					form.submit();
				}
			});
		});
	</script>
</body>
</html>