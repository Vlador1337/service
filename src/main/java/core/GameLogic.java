package core;

import dto.GameDto;


import java.util.List;
import java.util.Scanner;

public class GameLogic {
    private DbConnector dbConnector;
    private Scanner scanner;

    public GameLogic(Scanner scanner) {
        this.scanner = scanner;
        dbConnector = new DbConnector();
        dbConnector.setSession(GameDto.class);
    }

    public void showGamesInStore(){
       List<GameDto> gameDtoList = (List<GameDto>) dbConnector.getListItems("games", GameDto.class);
       gameDtoList.forEach(x-> System.out.println(x));
    }
}
