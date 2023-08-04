package viewerblock;

import presenter_block.Presenter;

import java.util.Scanner;

public class UserView implements UI {

    Scanner in; // Создаём переменную сканнера

    Presenter presenter; // Создаём экземпляр презентера

    private String select = """         
            1. Загрузить базу данных.
            2. Сохранить базу данных.
            3. Добавить пользователя.
            4. Удалить пользователя.
            5. Поиск пользователя.
            6. Вывести список пользователей.
            7. Выход.
            """;

    /**
     * Конструктор вьюера
     */
    public UserView() {
        in = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    /**
     * Реализация метода интерфейса "Приветствие"
     */
    @Override
    public void greetings() {
        System.out.println("Добро пожаловать, пройдите процедуру регистрации!");
    }

    /**
     * Метод который позволяет задать имя пользователя
     * @return - возвращает строку
     */
    @Override
    public String setName() {
        System.out.print("Введите имя пользователя:  ");
        return in.nextLine();
    }


    /**
     * Метод имитирующий кнопку валидации.
     * Проверяя пароль по хэш - коду
     */
    public void validationButton() {
        if (this.setUserName().equals("admin") && this.setPassword().hashCode() == "QweAsd123".hashCode()) {
            System.out.println("Добро пожаловать в режим разработчика!");
            select();
        }
    }

    /**
     * Метод позволяющий задать логин пользователя
     * @return - возвращает строку
     */
    @Override
    public String setUserName() {
        System.out.print("Введите логин:  ");
        return in.nextLine();
    }

    /**
     * Метод позволяющий задать пароль пользователя
     * @return - возвращает пароль
     */
    @Override
    public String setPassword() {
        System.out.print("Введите пароль: ");
        return in.nextLine();
    }

    /**
     * Метод ползволяющий задать email пользователя
     * @return - возвращает email
     */
    public String setEmail() {
        System.out.print("Введите e-mail: ");
        return in.nextLine();
    }

    /**
     * Метод имитации поведения меню
     */
    @Override
    public void select() {
        while (true) {
            System.out.println("=".repeat(50));
            System.out.println(select);
            System.out.println("=".repeat(50));
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
                    presenter.addUser(setName(), setUserName(), setPassword(), setEmail());
                    System.out.println("Ваши данные успешно внесены базу");
                    break;
                case "4":
                    System.out.println("Введите пользователя для удаления:");
                    presenter.removeUser(in.nextLine());
                    System.out.println("Пользователь успешно удален");
                    break;
                case "5":
                    System.out.println("Введите значение поиска: ");
                    if (in.hasNextLine()) {
                        presenter.searchUser(in.nextLine());
                    } else presenter.searchUser(in.nextInt());
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

