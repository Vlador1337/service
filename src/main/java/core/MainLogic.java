package core;


import dto.GameDto;

import java.util.Scanner;

public class MainLogic {
    private final Scanner scanner = new Scanner(System.in);
    private final Auth authLogic = new Auth(scanner);
    private final GameLogic gameLogic = new GameLogic(scanner);


    public void run(){
        authMenu();
        playerMenu();
    }

    public void authMenu() {
        System.out.println("У вас есть аккаунт? (y/n)\nВыход - 0");
        String choice = scanner.nextLine();
        switch (choice) {
            case "y":
                authLogic.auth();
                if (authLogic.getUser() == null) {
                    System.out.println("Аккаунта не найден \nРегистрируемся");
                    authLogic.reg();
                }
                break;
            case "n":
                authLogic.reg();
                break;
            case "0":
                System.out.println("Выход");
                break;
            default:
                System.out.println("Введите y или n");
                authMenu();
        }
    }
    public void playerMenu(){
        System.out.println("Желаете приобрести игру(s) или войти в свою библиотеку(l)");
        String choice = scanner.nextLine();
        switch (choice){
            case "s":
                System.out.println("Список игр доступных для приобретения:");
                gameLogic.showGamesInStore();
                break;
            case "l":

                break;
            default:
                System.out.println("Введите s или l");
                playerMenu();
        }
    }

}
