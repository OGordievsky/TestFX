package service;

import model.User;
import repository.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public boolean checkLogin(String login, String password) {
        return userRepository.getPassByLogin(login).equals(password);
    }

    public boolean addUser(User user, String password){
        return userRepository.addUser(user, password);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User getUser(String stId) {
        return userRepository.getUser(stId);
    }

    public boolean updateUser(User user) {
        return userRepository.updateUser(user);
    }

    public boolean delete(User user) {
        if (user != null){
            return userRepository.delete(user.getId());
        }
        return false;
    }
}