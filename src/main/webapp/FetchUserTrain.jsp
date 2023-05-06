<%@page import="java.util.Arrays"%>
<%@page import="dto.Train"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Railway</title>
</head>
<body>
<% List<Train> list=(List <Train>)request.getAttribute("list"); %>

<table border='1'>

<tr>
<th>Train Number</th>
<th>Train Name</th>
<th>From Station</th>
<th>To Station</th>
<th>Available Seats</th>
<th>Time Of Departure</th>
<th>Time Of Arrival</th>
<th>Available Days</th>
<th>Book Tickets</th>
</tr>

<%for(Train train: list){ %>
<tr>
<th><%= train.getNumber() %></th>
<th><%= train.getName() %></th>
<th><%= train.getStation()[0] %></th>
<th><%= train.getStation()[train.getStation().length-1] %></th>
<th><%= train.getSeat() %></th>
<th><%= train.getTime()[0] %></th>
<th><%= train.getTime()[train.getTime().length-1] %></th>
<th><%= Arrays.toString(train.getDays()) %></th>
<th><a href=''><button>Book Ticket</button></a></th>
</tr>
<% }%>

</table>
<br>
<br>
<a href='UserHome.html'><button>Home</button></a>
</body>
</html>