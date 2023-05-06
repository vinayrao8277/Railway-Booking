package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainDao;
import dto.Train;

@WebServlet("/addTrains")
public class AddTrains extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
	
	Train train= new Train();
	train.setName(trainName);
	train.setNumber(trainNumber);
	train.setSeat(trainSeat);
	train.setStation(trainStation);
	train.setPrice(trainPrice);
	train.setTime(trainTime);
	train.setDays(trainDays);
	
	TrainDao dao= new TrainDao();
	dao.save(train);
	
	resp.getWriter().print("<h1 style='color:green'>Train Addes Successfully</h1>");
	req.getRequestDispatcher("AddTrains.html").include(req, resp);
}
}
