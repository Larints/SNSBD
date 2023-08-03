package model_block;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDB implements Serializable {

    private int currentId; // Текущий id

    private List<User> userdb; // Создание базы данных

    /**
     * Конструктор для базы данных
     */
    public UserDB() {
        userdb = new ArrayList<User>();
        currentId = 1;
    }

    /**
     * Метод добавления пользователя в базу данных
     *
     * @param user - конкретный пользователь
     * @return - возвращает true или false
     */
    public boolean addUser(User user) {
        if (!userdb.contains(user)) {
            userdb.add(user);
            user.setId(currentId);
            currentId++;
            return true;
        }
        return false;
    }

    /**
     * Метод удаления пользователя из базы
     *
     * @param search - поиск по введенным параметрам
     * @return - возвращает true или false
     */

    public boolean removeUser(String search) {
        if (search != null) {
            Iterator<User> iterator = userdb.iterator();
            while (iterator.hasNext()) {
                User user = iterator.next();
                if (user.toString().contains(search)) {
                    iterator.remove();
                    return true;
                }
            }
        }
        return false;
    }

    public User findUser(String username) {
        if (username != null) {
            for (User user : userdb) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
        }
        return null; // Если пользователь с заданным именем не найден, возвращаем null
    }

    public User findUser(int id) {
        for (User user : userdb) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null; // Если пользователь с заданным id не найден, возвращаем null
    }

    public void printAllUsers() {
        for (User user : userdb) {
            System.out.println(user);
        }
    }

}
