package com.org.controller;

import com.org.factory.DAOFactory;
import com.org.vo.BloodPressure;

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

@WebServlet(name="SearchBloodPressureServlet", urlPatterns="/SearchBloodPressureServlet")
public class SearchBloodPressureServlet extends HttpServlet {
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
            BloodPressure bp = (BloodPressure)DAOFactory.getIBloodDAOInstance().searchData(id, date);
            request.setAttribute("id", bp.getId());
            request.setAttribute("bloodPressure", (int)bp.getData());
            request.setAttribute("date", bp.getDate());

            RequestDispatcher dispatcher = request.getRequestDispatcher("/updateBloodPressure.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("indexBloodPressure.jsp?message=failedSearch");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
