package org.example.servlettest;

import java.io.*;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/search")
public class SearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchKeyword = req.getParameter("keyword");
        String json;
        try {
            SearchService searchService = new SearchService();
            List<NaverAPIResultItem> result = searchService.searchByKeyword(searchKeyword);
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(result);
        } catch (Exception e) {
            resp.sendError(500);
            json = """
                    {
                    "error": "%s"
                    }
                    """.formatted(e.getMessage());
        }

        // 응답 설정
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // JSON 응답 전송
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
    }
}
