package presenter_block;

import model_block.Model;
import viewerblock.UserView;

public class Presenter {

    private Model model; // Переменная экземпляра модели

    private UserView view; // переменная экземпляра вьюера

    public Presenter(UserView view) { // Конструктор класса Presenter
        model = new Model();
        this.view = view;
    }

    /**
     * Загрузка данных из файла
     */
    public void loadData() {
        model.loadDb("./users.db");
    }

    /**
     * Сохранение данных в файл
     */
    public void saveData() {
        model.saveDb("./users.db");
    }

    /**
     * Добавление пользователя в базу данных
     * @param name - имя
     * @param login - логин
     * @param password - пароль
     * @param email - email
     */
    public void addUser(String name, String login, String password, String email) {
        model.addUser(name, login, password, email);
    }

    /**
     * Поиск пользователя по базе данных
     * @param search - строка для поиска
     */
    public void searchUser(String search) {
        model.searchUser(search);
    }

    /**
     * Поиск пользователя в базе данных по id
     * @param id - искомый id
     */
    public void searchUser(int id) {
        model.searchUser(id);
    }

    /**
     * Метод удаления из базы данных
     * @param search - поиск в базе
     */
    public void removeUser(String search) {
        model.removeUser(search);
    }

    /**
     * Метод печати всех пользователей базы
     */
    public void printAllUsers() {
        model.printAllUsers();
    }

}
