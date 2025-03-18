package com.org.controller;

import com.org.factory.DAOFactory;
import com.org.vo.BloodOxygen;

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

@WebServlet(name="SearchBloodOxygenServlet", urlPatterns="/SearchBloodOxygenServlet")
public class SearchBloodOxygenServlet extends HttpServlet {
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
            BloodOxygen data = (BloodOxygen) DAOFactory.getIBloodOxygenDAOInstance().searchData(id, date);
            request.setAttribute("id", data.getId());
            request.setAttribute("bloodOxygen", data.getData());
            request.setAttribute("date", data.getDate());

            RequestDispatcher dispatcher = request.getRequestDispatcher("/updateBloodOxygen.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("indexBloodOxygen.jsp?message=failedSearch");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
