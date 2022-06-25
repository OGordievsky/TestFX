package model;

public class User {
    private Long id;
    private String name;
    private String title;
    private String login;
    private String location;
    private String gender;

    public User() {
    }

    public User(String name, String title, String login, String location, boolean gender) {
        this.name = name;
        this.title = title;
        this.login = login;
        this.location = location;
        this.gender = gender ? "Man" : "Woman";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public boolean isGender(){
        return this.gender.equals("Man");
    }

    public void setGender(boolean gender) {
        this.gender = gender ? "Man" : "Woman";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
