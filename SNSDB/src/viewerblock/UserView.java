package viewerblock;

import presenter_block.Presenter;

import java.util.Scanner;

public class UserView implements UI {

    Scanner in;

    Presenter presenter;

    private String select = """
            1. Загрузить базу данных.
            2. Сохранить базу данных.
            3. Добавить пользователя.
            4. Удалить пользователя.
            5. Поиск пользователя.
            6. Вывести список пользователей.
            7. Выход.
            """;

    public UserView() {
        in = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    @Override
    public void greetings() {
        System.out.println("Добро пожаловать, пройдите процедуру регистрации!");
    }


    public void registerationButton() {
        this.greetings();
        presenter.registrationButtonClicked(this.setUserName(), this.setPassword(),this.setEmail());
        System.out.println("Ваши данные успешно внесены базу");
    }

    public void validationButton() {
        if (this.setUserName().equals("admin") && this.setPassword().equals("QweAsd123")) {
            System.out.println("Добро пожаловать в режим разработчика!");
            select();
        }
    }

    @Override
    public String setUserName() {
        System.out.print("Введите логин:  ");
        return in.nextLine();
    }

    @Override
    public String setPassword() {
        System.out.print("Введите пароль: ");
        return in.nextLine();
    }

    public String setEmail() {
        System.out.println("Введите e-mail: ");
        return in.nextLine();
    }

    @Override
    public void select() {
        while (true) {
            System.out.println(select);
            switch (in.nextLine()) {
                case "1":
                    presenter.loadData();
                    System.out.println("База успешно загружена!");
                    break;
                case "2":
                    presenter.saveData();
                    System.out.println("База успешно сохранена!");
                    break;
                case "3":
                    presenter.addUser(setUserName(), setPassword(), setEmail());
                    System.out.println("Ваши данные успешно внесены базу");
                    break;
                case "4":
                    System.out.println("Введите пользователя для удаления:");
                    presenter.removeUser(in.nextLine());
                    System.out.println("Пользователь успешно удален");
                    break;
                case "5":
                    presenter.searchUser(in.nextLine());
                    break;
                case "6":
                    presenter.printAllUsers();
                    break;
                case "7":
                    System.out.println("Досвидания");
                    presenter.saveData();
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте снова!");
            }
        }
    }
}

