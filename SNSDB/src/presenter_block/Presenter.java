package presenter_block;

import model_block.Model;
import viewerblock.UserView;

public class Presenter {

    private Model model;

    private UserView view;

    public Presenter(UserView view) {
        model = new Model();
        this.view = view;
    }

    public void loadData() {
        model.loadDb("./users.db");
    }

    public void saveData() {
        model.saveDb("./users.db");
    }

    public void addUser(String name, String login, String password) {
        model.addUser(name, login, password);
    }

    public void searchUser(String search) {
        model.searchUser(search);
    }

    public void searchUser(int id) {
        model.searchUser(id);
    }

    public void removeUser(String search) {
        model.removeUser(search);
    }

    public void printAllUsers() {
        model.printAllUsers();
    }

    public void registrationButtonClicked(String username, String password, String email) {
        model.addUser(username, password, email);
    }
}
