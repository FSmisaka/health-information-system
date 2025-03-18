package com.org.controller;

import com.org.factory.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name="UpdateBloodPressureServlet", urlPatterns="/UpdateBloodPressureServlet")
public class UpdateBloodPressureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        int bloodPressure = Integer.parseInt(request.getParameter("bloodPressure"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = df.parse(request.getParameter("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            boolean flag = DAOFactory.getIBloodDAOInstance().updateData(id, bloodPressure, date);
            if (flag) {
                response.sendRedirect("indexBloodPressure.jsp?message=successfulUpdate");
            } else {
                response.sendRedirect("indexBloodPressure.jsp?message=failedUpdate");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
