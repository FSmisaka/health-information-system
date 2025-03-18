package com.org.controller;

import com.org.dao.TargetDAO;
import com.org.factory.DAOFactory1;
import com.org.vo.Target;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import java.util.List;

@WebServlet("/SearchTargetServlet")
public class SearchTargetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String targetIdStr = request.getParameter("id");
        List<Target> targets = null;
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        try {
            TargetDAO targetDAO = DAOFactory1.getTargetDAO();

            if (targetIdStr != null && !targetIdStr.isEmpty()) {
                // 如果用户传递了目标 ID，则根据 ID 查询目标
                int targetId = Integer.parseInt(targetIdStr);
                Target target = targetDAO.getTargetById(targetId);

                if (target != null) {
                    // 将单个目标转换为 List 以便统一处理
                    targets = List.of(target);
                } else {
                    targets = List.of(); // 如果未找到目标，返回空列表
                }
            } else {
                // 如果没有传递 ID，则查询最近五条目标
                targets = targetDAO.getRecentTargets(username,5);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "查询目标时发生错误。");
            return;
        }

        // 将查询结果保存到请求属性中
        request.setAttribute("targets", targets);

        // 转发到 Target.jsp 页面进行显示
        RequestDispatcher dispatcher = request.getRequestDispatcher("/target.jsp");
        dispatcher.forward(request, response);
    }
}

