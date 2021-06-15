package com.example.UserLoginServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "user",value = "Naman"),
                @WebInitParam(name = "password",value = "Hello")
        }
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        get request parameters for userID and password
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");

        String userNameValid = "^[A-Z]{1}[a-zA-Z]{2,}";
        if (!user.matches(userNameValid)) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = resp.getWriter();
            out.println("<font color=red> Enter the correct username...!!!</font>");
            requestDispatcher.include(req, resp);
        } else {

//        Get servlet config init params
            String userID = getServletConfig().getInitParameter("user");
            String password = getServletConfig().getInitParameter("password");
            if (userID.equals(user) && password.equals(pwd)) {
                req.setAttribute("user", user);
                req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
            } else {
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
                PrintWriter out = resp.getWriter();
                out.println("<font color=red> Either username or password is wrong.</font>");
                requestDispatcher.include(req, resp);
            }
        }
    }
}
