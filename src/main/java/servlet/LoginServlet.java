package servlet;

import java.io.IOException;

import dao.UserDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAOImpl userDAO = new UserDAOImpl();
        if (userDAO.validateLogin(username, password)) {
            response.sendRedirect("welcome.jsp");  // Redirect to a welcome page upon successful login
        } else {
            response.getWriter().write("Invalid credentials. Please try again.");
        }
    }
}
