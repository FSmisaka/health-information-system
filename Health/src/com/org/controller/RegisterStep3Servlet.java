package com.org.controller;

import com.org.vo.Target;  // 导入 Target 类
import com.org.vo.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import com.org.dao.UserDAO;
import com.org.dao.HeightWeightDAO;
import com.org.dao.TargetDAO;  // 修改为 TargetDAO

import com.org.vo.HeightWeight;
import java.sql.SQLException;
import java.util.Date;

@WebServlet("/RegisterStep3Servlet")
public class RegisterStep3Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        HeightWeight heightWeight = (HeightWeight) session.getAttribute("heightWeight");

        if (user == null || heightWeight == null) {
            response.sendRedirect("register_step1.jsp");
            return;
        }

        // 获取表单数据
        String focus = request.getParameter("focus");  // 当前主要关注的健康指标
        String way = request.getParameter("way");      // 希望改善的主要方式
        String frequency = request.getParameter("frequency");  // 健康数据追踪频率
        String deadline = request.getParameter("deadline");  // 健康目标完成期限

        // 创建 Target 对象并设置数据
        Target target = new Target();
        target.setUsername(user.getUsername());
        target.setFocus(focus);
        target.setWay(way);
        target.setDeadline(deadline);
        target.setCreatedAt(new Date());  // 设置当前时间

        session.setAttribute("target", target);

        // 获取 DAO 对象并插入数据
        TargetDAO targetDAO = new TargetDAO();

        try {
            System.out.println("Saving User: " + user);
            System.out.println("Saving HeightWeight: " + heightWeight);
            System.out.println("Saving Target: " + target);
            boolean userSaved = UserDAO.saveUser(user);
            boolean targetSaved = targetDAO.insertTarget(target);

            if (targetSaved) {
                response.sendRedirect("register_complete.jsp");  // 注册成功后重定向
            } else {
                request.setAttribute("error", "保存数据失败，请稍后再试！");
                request.getRequestDispatcher("register_step3.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "数据库保存失败！请稍后再试。");
            request.getRequestDispatcher("register_step3.jsp").forward(request, response);
        }
    }
}
