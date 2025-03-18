package com.org.controller;

import com.org.factory.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;

@WebServlet(name="AddWeightServlet", urlPatterns="/AddWeightServlet")
public class AddWeightServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        double data = Double.parseDouble(request.getParameter("weight"));

        try {
            boolean flag = DAOFactory.getIWeightDAOInstance().addData(id, data);
            if(flag) {
                response.sendRedirect("indexWeight.jsp?message=successfulInsert");
            } else {
                response.sendRedirect("indexWeight.jsp?message=failedInsert");
            }
        } catch (Exception e) {
            try {
                boolean flag = DAOFactory.getIWeightDAOInstance().updateData(id, data, new Date());
                if(flag) {
                    response.sendRedirect("indexWeight.jsp?message=successfulUpdate");
                } else {
                    response.sendRedirect("indexWeight.jsp?message=failedUpdate");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
