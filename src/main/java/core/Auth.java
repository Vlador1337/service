package core;

import dto.UserDto;

import java.util.List;
import java.util.Scanner;

public class Auth {
    private UserDto user;
    private Scanner scanner;
    private final DbConnector dbConnector;


    public UserDto getUser() {
        return user;
    }

    public Boolean isUserDeveloper() {
        return user.getIsDev() == 1;
    }

    public Auth(Scanner scanner) {
        this.scanner = scanner;
        dbConnector = new DbConnector();
        dbConnector.setSession(UserDto.class);
    }


    public void auth() {
        System.out.println("Введите ваш Email");
        String email = scanner.nextLine();
        System.out.println("Введите ваш пароль");
        String password = scanner.nextLine();
        user = dbConnector.findUser(email, password);
    }

    public void reg() {
        System.out.println("Введите имя пользователя");
        String name = scanner.nextLine();
        System.out.println("Введите Email");
        String email = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        System.out.println("Введите сумму пополнения на счет");
        Double wallet = scanner.nextDouble();
        user = new UserDto(0, name, email, password, wallet);
        dbConnector.addItem(user);
        System.out.println(user);
    }
}
