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

@WebServlet("/trainEdit")
public class TrainEdit extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int trainNumber=Integer.parseInt(req.getParameter("tnumber"));
		String trainName=req.getParameter("tname");
		int trainSeat=Integer.parseInt(req.getParameter("tseat"));
		String station=req.getParameter("tstation");
		String [] trainStation=station.split(",");
		
		String price=req.getParameter("tprice");
		String [] trainPrice=price.split(",");
		
		String time=req.getParameter("ttime");
		String [] trainTime=time.split(",");
		
		String days=req.getParameter("tday");
		String [] trainDays=days.split(",");
		
		
		TrainDao dao= new TrainDao();
		Train train=dao.find(trainNumber);
		train.setNumber(trainNumber);
		train.setName(trainName);
		train.setSeat(trainSeat);
		train.setStation(trainStation);
		train.setPrice(trainPrice);
		train.setTime(trainTime);
		train.setDays(trainDays);
		dao.edit(trainNumber);
		
		List<Train> list=dao.fetchAll();
		
		resp.getWriter().print("<h1 style='color:green'> Updated Successfully...</h1>");
		resp.getWriter().print("<h1 style='color:blue'>Train Number is: "+trainNumber+" </h1>");
		req.setAttribute("list", list);
		req.getRequestDispatcher("FetchTrainInfo.jsp").include(req, resp);
	}
}
