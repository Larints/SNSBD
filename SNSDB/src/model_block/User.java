package model_block;

import java.io.Serializable;

public class User implements Serializable {      // Класс пользователь, реализует первый принцип паттерна SOLID,
    // он отвечает только за свой функционал.
    private int id;

    private String name;

    private String username;
    private String password;
    private String email;

    /**
     * Constructor for User.
     *
     * @param id       - id пользователя;
     * @param username -  логин пользователя;
     * @param password - пароль пользователя;
     * @param email    - email пользователя;
     */
    public User(int id, String name, String username, String password, String email) {
        this.id = id;
        if (name != null) {
            this.name = name;
        }
        if (username != null) {
            this.username = username;
        }
        if (password != null && password.length() > 5) {
            this.password = password;
        }
        if (email != null && email.contains("@")) {
            this.email = email;
        }
    }

    /**
     * Метод для установки id у пользователя
     *
     * @param id -  Устанавливаем значение id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Метод для установки логина
     *
     * @param username - задаём логин для пользователя
     */
    public void setUsername(String username) {
        if (username != null) {
            this.username = username;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод для установки пароля
     *
     * @param password - задаём пароль у пользователя
     */

    public void setPassword(String password) {
        if (password != null && password.length() > 5) {
            this.password = password;
        }
    }

    /**
     * Метод для установки email пользователя
     *
     * @param email - задаём email пользователя
     */
    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        }
    }

    /**
     * Метод для возврата поля email
     *
     * @return email - возвращает email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Метод для возврата id пользователя
     *
     * @return id - возвращает id
     */
    public int getId() {
        return id;
    }

    /**
     * Метод для возврата username пользователя
     *
     * @return username - возвращает логин пользователя
     */

    public String getUsername() {
        return username;
    }

    /**
     * Метод для возврата полей класса в виде строки
     *
     * @return переопределение метода toString
     */
    @Override
    public String toString() {
        return "[" + id + "." + " " + name + " " +  username + " " + email + "]";

    }
}
