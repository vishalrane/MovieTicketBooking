<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
	function bookTicket() {
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("myDiv").innerHTML =  JSON.parse(xmlhttp.responseText )["MESSAGE"];
			}
		}
		xmlhttp.open("POST", "rest/movieTicketServices/bookTicket", true);
		xmlhttp.setRequestHeader("Content-type", "application/json");
		xmlhttp.send("{\"showTime\":\""+document.getElementById("showTime").value+"\",\"noOfSeat\":\""+document.getElementById("noOfSeat").value+"\"}");
	}
	
	 
</script>
</head>
<body>
	<table>
		<tr>
			<td>Show Time</td>
			<td><select name="showTime" id="showTime" id="showTime"><option value="_11AM">11AM</option>
					<option value="_2PM">2PM</option>
					<option value="_6PM">6PM</option></select></td>
		</tr>
		<tr>
			<td>Number Of Seats</td>
			<td><input type="text" name="noOfSeat" id="noOfSeat"></td>
		</tr>
	</table>
	<input type="button" value="Book Ticket"  onclick="bookTicket()"/>
	<div id="myDiv"></div>
</body>
</html>