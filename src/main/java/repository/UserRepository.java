package repository;

import model.User;
import repository.connection.DataBaseConnection;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private final DataBaseConnection dataBaseConnection = new DataBaseConnection();

    public User getUser() {
        return new User();
    }

    public String getPassByLogin(String login) {
        String sql = "SELECT password FROM users WHERE login = ?";
        try (PreparedStatement prSt = dataBaseConnection.getDbConnection().prepareStatement(sql)) {
            prSt.setString(1, login);
            ResultSet set = prSt.executeQuery();
            if (set.next()){
               return set.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addUser(User user, String password) {
        String sql = "INSERT INTO users (name, title, login, password, location, gender) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        int result = 0;
        try (PreparedStatement prSt = dataBaseConnection.getDbConnection().prepareStatement(sql)){
            prSt.setString(1, user.getName());
            prSt.setString(2, user.getTitle());
            prSt.setString(3, user.getLogin());
            prSt.setString(4, password);
            prSt.setString(5, user.getLocation());
            prSt.setBoolean(6, user.isGender());

            result = prSt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result > 0;
    }
}
