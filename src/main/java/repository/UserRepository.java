package repository;

import model.User;
import repository.connection.DataBaseConnection;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final DataBaseConnection dataBaseConnection = new DataBaseConnection();

    public User getUser(String stId) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement prSt = dataBaseConnection.getDbConnection().prepareStatement(sql)) {
            Long index = Long.parseLong(stId);
            prSt.setLong(1, index);
            ResultSet set = prSt.executeQuery();
            if (set.next()) {
                User user = new User();
                user.setId(set.getLong("id"));
                user.setName(set.getString("name"));
                user.setTitle(set.getString("title"));
                user.setLogin(set.getString("login"));
                user.setLocation(set.getString("location"));
                user.setGender(set.getBoolean("gender"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getPassByLogin(String login) {
        String sql = "SELECT password FROM users WHERE login = ?";
        try (PreparedStatement prSt = dataBaseConnection.getDbConnection().prepareStatement(sql)) {
            prSt.setString(1, login);
            ResultSet set = prSt.executeQuery();
            if (set.next()) {
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
        try (PreparedStatement prSt = dataBaseConnection.getDbConnection().prepareStatement(sql)) {
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

    public List<User> getAll() {
        String sql = "SELECT * FROM users";
        List<User> userList = new ArrayList<>();
        try (PreparedStatement prSt = dataBaseConnection.getDbConnection().prepareStatement(sql)) {
            ResultSet set = prSt.executeQuery();
            while (set.next()) {
                User user = new User(
                        set.getString("name"),
                        set.getString("title"),
                        set.getString("login"),
                        set.getString("location"),
                        set.getBoolean("gender")
                );
                user.setId(set.getLong("id"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public boolean updateUser(User user) {
        String sql = "UPDATE users SET name = ?, title = ?, location = ?, gender = ? " +
                "WHERE id = ?";
        int result = 0;
        try (PreparedStatement prSt = dataBaseConnection.getDbConnection().prepareStatement(sql)) {
            prSt.setString(1, user.getName());
            prSt.setString(2, user.getTitle());
            prSt.setString(3, user.getLocation());
            prSt.setBoolean(4, user.isGender());
            prSt.setLong (5, user.getId());
            result = prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result > 0;
    }
}
