package dao;

import model.User;

public interface UserDAO {
    boolean registerUser(User user);  // Register new user
    boolean validateLogin(String username, String password);  // Validate login
}
