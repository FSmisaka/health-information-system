package com.org.controller;

import com.org.utils.PasswordUtils;
import com.org.vo.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/RegisterStep1Servlet")
public class RegisterStep1Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String birthdate = request.getParameter("birthdate");
        String gender = request.getParameter("gender");
        String bloodtype = request.getParameter("bloodtype");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        String encryptedPassword = PasswordUtils.hashPassword(password);

        User user = new User();
        user.setUsername(username);
        user.setPassword(encryptedPassword);
        user.setName(name);
        user.setBirthdate(birthdate);
        user.setGender(gender);
        user.setBloodtype(bloodtype);
        user.setPhone(phone);
        user.setEmail(email);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        request.setAttribute("healthTip", "填写基本信息后，会进入健康数据填写步骤。");

        response.sendRedirect("register_step2.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register_step1.jsp");
    }
}

