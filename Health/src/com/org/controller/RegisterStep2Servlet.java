package com.org.controller;
import com.org.vo.HeightWeight;
import com.org.vo.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/RegisterStep2Servlet")
public class RegisterStep2Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String heightStr = request.getParameter("height");
        String weightStr = request.getParameter("weight");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("register_step1.jsp");
            return;
        }

        try {
            float height = Float.parseFloat(heightStr);
            float weight = Float.parseFloat(weightStr);

            HeightWeight heightWeight = new HeightWeight(user.getUsername(), height, weight);

            session.setAttribute("heightWeight", heightWeight);

            response.sendRedirect("register_step3.jsp");

        } catch (NumberFormatException e) {
            request.setAttribute("error", "请输入有效的身高和体重！");
            request.getRequestDispatcher("register_step2.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register_step2.jsp");
    }
}
