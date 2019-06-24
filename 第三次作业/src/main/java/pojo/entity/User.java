package pojo.entity;

public class User {


    private String name;

    private String password;


    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }


    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}


