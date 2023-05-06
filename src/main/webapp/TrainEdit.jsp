<%@page import="java.util.Arrays"%>
<%@page import="dto.Train"%>
<%@page import="dao.TrainDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int trainNumber=Integer.parseInt(request.getParameter("tnumber"));
TrainDao dao= new TrainDao();
Train train=dao.find(trainNumber);
%>

<h1>Enter train Details...</h1>
<form action="trainEdit" method="post">
<table>
<tr>
<th>Train Number</th>
<td><input type="number" value='<%= train.getNumber() %>' readonly="readonly" name='tnumber'></td>
</tr>

<tr>
<th>Train Name</th>
<td><input type="text" value="<%= train.getName() %>" name='tname'></td>
</tr>

<tr>
<th>Number of Seats</th>
<td><input type="number" value="<%=train.getSeat() %>" name='tseat'></td>
</tr>

<tr>
<th>Stations</th>
<td><textarea rows="5" cols="30" name='tstation' > 
<% for(String station: train.getStation())
	{
	out.print(station+",");
	}%> </textarea></td>
</tr>

<tr>
<th>Ticket Price</th>
<td><textarea rows="5" cols="30" name='tprice'> 
<% for(String price: train.getPrice()) 
{
	out.print(price+",");
}
%></textarea></td>
</tr>

<tr>
<th>Time</th>
<td><textarea rows="5" cols="30" name='ttime'>
<% for(String time: train.getTime())
	{
	   out.print(time+",");
	}
	%></textarea></td>
</tr>

<tr>
<th>Day</th>
<td><textarea rows="5" cols="30" name='tday'> 
<%for(String day: train.getDays()) 
{
	out.print(day+",");
}
%></textarea></td>
</tr>
<tr>
<td>
<button type="reset">Cancel</button>
</td>
<td>
<button>Update</button>
</td>
</tr>

</table>
</form>
<br>
<a href='ManagementHome.html'><button>Home</button></a>

</body>
</html>