package com.org.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@WebServlet("/chat1")
public class ChatGPTServlet extends HttpServlet {
    private static final String API_KEY = "sk-waVBurNJarI4au3L6dC854B8592e4c8f976894DbDd1a870d";
    private static final String API_URL = "https://api.xiaoai.plus/v1/chat/completions";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userQuestion = request.getParameter("question");
        if (userQuestion == null || userQuestion.trim().isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("问题不能为空！");
            return;
        }

        // 调用 OpenAI API
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String payload = String.format(
                    "{\"model\": \"gpt-4\", \"messages\": [{\"role\": \"system\", \"content\": \"You are a helpful assistant.\"}, {\"role\": \"user\", \"content\": \"%s\"}]}",
                    userQuestion.replace("\"", "\\\"")
            );

            try (OutputStream os = connection.getOutputStream()) {
                os.write(payload.getBytes(StandardCharsets.UTF_8));
            }

            int status = connection.getResponseCode();
            if (status == 200) {
                try (var inputStream = connection.getInputStream()) {
                    response.setContentType("application/json");
                    inputStream.transferTo(response.getOutputStream());
                }
            } else {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("调用 API 时出错！");
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("服务器内部错误：" + e.getMessage());
        }
    }
}

