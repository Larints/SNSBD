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

    /**
     * Метод поиска пользователя в базе данных
     *
     * @param username - поиск по введенным параметрам
     */

    public void findUser(String username) {
        for (User user: userdb) {
            if (user.toString().contains(username)) {
                System.out.println(user);
            }
        }
    }


    /**
     * Метод поиска пользователя в базе данных
     *
     * @param id - поиск по введенным параметрам
     */
    public void findUser(int id) {
        for (User user : userdb) {
            if (user.getId() == id) {
                System.out.println(user);
            }
        }
    }

    /**
     * Метод вывода всех пользователей в базе данных
     */

    public void printAllUsers() {
        for (User user : userdb) {
            System.out.println(user);
        }
    }
}
