package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainDao;
import dto.Train;

@WebServlet("/traindelete")
public class DeleteTrain extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	int trainNumber=Integer.parseInt(req.getParameter("tnumber"));
	
	TrainDao dao= new TrainDao();
	dao.delete(trainNumber);
	
    List<Train> list=dao.fetchAll();
	
	if(list.isEmpty())
	{
		resp.getWriter().print("<h1 style='color:red'>No Train Information Is Available</h1>");
		req.getRequestDispatcher("ManagementHome.html").include(req, resp);
	}
	else
	{
		resp.getWriter().print("<h1 style='color:red'> Deleted Successfully...</h1>");
		resp.getWriter().print("<h1 style='color:blue'>Train Number is: "+trainNumber+" </h1>");
		req.setAttribute("list", list);
		req.getRequestDispatcher("FetchTrainInfo.jsp").include(req, resp);
	}
}
}
