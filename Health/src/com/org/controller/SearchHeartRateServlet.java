package com.org.controller;

import com.org.factory.DAOFactory;
import com.org.vo.HeartRate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name="SearchHeartRateServlet", urlPatterns="/SearchHeartRateServlet")
public class SearchHeartRateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = df.parse(request.getParameter("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            HeartRate data = (HeartRate) DAOFactory.getIHeartRateDAOInstance().searchData(id, date);
            request.setAttribute("id", data.getId());
            request.setAttribute("heartRate", (int)data.getData());
            request.setAttribute("date", data.getDate());

            RequestDispatcher dispatcher = request.getRequestDispatcher("/updateHeartRate.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("indexHeartRate.jsp?message=failedSearch");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
