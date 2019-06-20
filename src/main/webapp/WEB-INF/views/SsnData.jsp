<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title></title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/styles.css" />">

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script
	src="<c:url value="/resources/js/hkhkh//khkk/filtable.js?dev" />"></script>
<script>
	$(function() {
		// Basic Filtable usage - pass in a div with the filters and the plugin will handle it
		$('#data').filtable({
			controlPanel : $('.table-filters')
		});
	});
</script>
</head>

<body>

	<h1>Ssn Table - large table</h1>

	<p>This is a large table of over 500 rows for speed testing.</p>

	<div class="table-filters">
		<label for="filter-country">Country:</label> <input type="text"
			class="input-text" id="filter-country" data-filter-col="3">
	</div>

	<!-- data taken from generatedata.com -->
	<table id="data" class="large-table">
		<thead>
			<tr>
				<th>SSN NO</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>DOB</th>
				<th>GENDER</th>
				<th>PHNO</th>
				<th>STATE</th>
				<th>PHOTO</th>
				<th>Created Date</th>
				<th>Updated Date</th>
			</tr>
		</thead>

		<c:forEach var="data" items="${data}">
			<tbody>
				<tr>
					<td><c:out value="${data.ssnId}"></c:out></td>
					<td><c:out value="${data.fname}"></c:out></td>
					<td><c:out value="${data.lname}"></c:out></td>
					<td><c:out value="${data.dob}"></c:out></td>
					<td><c:out value="${data.gender}"></c:out></td>
					<td><c:out value="${data.phno}"></c:out></td>
					<td><c:out value="${data.state}"></c:out></td>
					<td><img height="100px" width="100px" src="<c:url value="/resources/images/"/><c:out value="${data.photopath}"></c:out>"></td>
					<td><c:out value="${data.createDate}"></c:out></td>
					<td><c:out value="${data.updateDate}"></c:out></td>
				</tr>
			</tbody>
		</c:forEach>

	</table>
${states }
</body>
</html>
