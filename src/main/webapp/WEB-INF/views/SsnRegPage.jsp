<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Datepicker - Default functionality</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	$(function() {
		$("#dob").datepicker({
			dateFormat : 'yy-mm-dd',
			maxDate : "-1d"
		});
	});
	
</script>
</head>
<body>
	<form:form action="save" method="post" modelAttribute="ssnRegEntity"  enctype="multipart/form-data">
		<center>Enrollment For SSN(Social Security Number )</center>
	First Name :
	<form:input path="fname" required="true" pattern="[A-Za-z]+"
			title="First name aplhabetic only" size="20" />

		<br> Last Name :
	<form:input path="lname" ng-model="lname" required="true"
			pattern="[A-Za-z]+" title="Last name aplhabetic only" size="20" />

		<br> Date of Birth:
	<form:input path="dob" required="true" />
		<br> Gender :
	<form:radiobutton path="gender" value="male" required="true" />
	Male
	<form:radiobutton path="gender" value="female" required="true" />
	Female
	<br> Phno :
	<form:input path="phno" required="true" maxlength="10"
			pattern="[0-9]{10}" title="Ten letter Numeric  ssn code" />
		<br> Select State:
	<form:select path="state" >
			<form:options items="${states}" itemValue="stateName"
				itemLabel="stateName" />
		</form:select>
		<br> Choose File
		<input type="file" name="file"><br>
		<input type="reset">
		<input type="submit" value="Enroll">
	</form:form>
	${ssn }
</body>
</html>