package com.org.controller;

import com.org.dao.UserDAO;
import com.org.vo.User;
import com.org.utils.PasswordUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取表单提交的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 通过用户名查询用户信息
        UserDAO userDAO = null;
        try {
            userDAO = new UserDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        User user = userDAO.getUserByUsername(username);  // 根据用户名查询用户

        // 检查用户是否存在
        if (user != null) {
            // 对比密码，假设我们存储的是密码的哈希值
            boolean isPasswordValid = PasswordUtils.verifyPassword(password, user.getPassword());

            if (isPasswordValid) {
                // 密码正确，登录成功，存储用户信息到session中
                HttpSession session = request.getSession();
                session.setAttribute("username", user.getUsername());  // 将username存入session
                session.setAttribute("user_id", user.getUserId());
                System.out.println("user_id: " + user.getUserId());


                // 重定向到用户首页或其他页面
                response.sendRedirect("index.jsp");
            } else {
                // 密码错误，跳转到登录页面并提示错误信息
                request.setAttribute("errorMessage", "用户名或密码错误");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            // 用户名不存在，跳转回登录页面并提示错误信息
            request.setAttribute("errorMessage", "用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
