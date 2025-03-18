package com.org.controller;

import com.org.dao.TargetDAO;
import com.org.vo.Target;
import com.org.factory.DAOFactory1;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet("/AddTargetSubmitServlet")
public class AddTargetSubmitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户选择的健康目标数据
        String focus = request.getParameter("focus");
        String way = request.getParameter("way");
        String deadline = request.getParameter("deadline");

        // 假设 username 是从 session 获取的
        String username = (String) request.getSession().getAttribute("username");

        // 创建 Target 对象并设置数据
        Target target = new Target(0, username, new Date(), focus, way, deadline);

        // 获取 TargetDAO 并插入数据
        try {
            TargetDAO targetDAO = DAOFactory1.getTargetDAO();
            targetDAO.insertTarget(target);

            // 数据插入成功后重定向到成功页面
            response.sendRedirect("index.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            // 数据插入失败时可以转发到错误页面
            request.setAttribute("errorMessage", "目标创建失败，请稍后再试！");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
