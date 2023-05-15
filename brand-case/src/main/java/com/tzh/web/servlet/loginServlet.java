package com.tzh.web.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String style = request.getParameter("style");
        if (style == null){
            response.sendRedirect("staff.html");
        }else{
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.equals("tzh")==true && password.equals("3385369312")==true){
                response.sendRedirect("adm.html");
            }
        }
    }
}
