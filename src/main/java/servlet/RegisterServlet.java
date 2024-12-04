package servlet;

import java.io.IOException;

import dao.UserDAOImpl;
import model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phone_number");
        String address = request.getParameter("address");
        
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            response.getWriter().write("Please fill all the fields.");
            return;
        }
        
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);  // In a real-world scenario, you should hash the password
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);

        UserDAOImpl userDAO = new UserDAOImpl();
        if (userDAO.registerUser(user)) {
            response.sendRedirect("login.jsp");  // Redirect to login page after successful registration
        } else {
            response.getWriter().write("Registration failed. Please try again.");
        }
    }
}
