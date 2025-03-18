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


@WebServlet("/GetAdviceServlet")
public class GetAdviceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String advice = "No matching advice found."; // Default advice
        Target recentTarget = null;

        try {
            // Get the username from the session
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");

            if (username == null) {
                request.setAttribute("error", "User not logged in.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
                return;
            }

            // Get the most recent target for the user
            TargetDAO targetDAO = DAOFactory1.getTargetDAO();
            recentTarget = targetDAO.getRecentTargets(username, 1).stream().findFirst().orElse(null);

            if (recentTarget != null) {
                String focus = recentTarget.getFocus();
                String way = recentTarget.getWay();

                // Get advice based on focus and way
                advice = getAdvice(focus, way);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Error occurred while fetching advice.");
        }

        // Set the advice as a request attribute
        request.setAttribute("advice", advice);

        // Forward to advice.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/advice.jsp");
        dispatcher.forward(request, response);
    }


    /**
     * Returns advice based on focus and way
     */
    private String getAdvice(String focus, String way) {
        if ("weight".equals(focus) && "diet_control".equals(way)) {
            return "你的关注指标是体重，改善方式是饮食控制。所以建议你记录每日的热量摄入，减少高热量、高脂肪食物的摄入，选择富含纤维的食物（如燕麦、水果、蔬菜），并养成少食多餐的习惯，以帮助控制体重和促进健康饮食习惯的形成。";
        } else if ("weight".equals(focus) && "increase_exercise".equals(way)) {
            return "你的关注指标是体重，改善方式是增加运动量。所以建议你每周进行至少150分钟的中等强度有氧运动（如跑步或骑自行车），结合力量训练来提高新陈代谢，同时注意避免因运动后饥饿感过强而导致的暴饮暴食，以有效管理体重。";
        } else if ("blood_sugar".equals(focus) && "diet_control".equals(way)) {
            return "你的关注指标是血糖，改善方式是饮食控制。所以建议你减少精制糖和高碳水化合物的摄入，增加低升糖指数食物（如全谷物、绿叶蔬菜）和优质蛋白质的摄入，餐后监测血糖变化，以调整饮食结构来更好地控制血糖水平。";
        } else if ("blood_sugar".equals(focus) && "increase_exercise".equals(way)) {
            return "你的关注指标是血糖，改善方式是增加运动量。所以建议你选择低强度、长时间的运动（如快走或游泳），每周至少运动5天，以帮助稳定血糖水平，同时注意运动前后监测血糖变化，以确保运动过程中的安全。";
        } else if ("blood_pressure".equals(focus) && "diet_control".equals(way)) {
            return "你的关注指标是血压，改善方式是饮食控制。所以建议你每天盐摄入量控制在5克以下，避免高脂肪和高胆固醇食物，多摄入富含钾、钙、镁的食物（如香蕉、牛奶、坚果），保持充足的水分摄入，以促进血液循环和维持健康血压水平。";
        } else if ("blood_pressure".equals(focus) && "increase_exercise".equals(way)) {
            return "你的关注指标是血压，改善方式是增加运动量。所以建议你每天进行至少30分钟的适度耐力运动（如步行或太极），以帮助降低血压、改善心血管健康，同时避免过于剧烈的运动，以确保血压管理的有效性和安全性。";
        } else {
            return "未找到匹配的建议。";
        }
    }

}
