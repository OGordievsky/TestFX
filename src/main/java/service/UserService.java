package service;

import model.User;
import repository.UserRepository;

public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public boolean checkLogin(String login, String password) {
        return userRepository.getPassByLogin(login).equals(password);
    }

    public boolean addUser(User user, String password){
        return userRepository.addUser(user, password);
    }
}
