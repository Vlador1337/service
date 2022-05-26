package core;

import dto.GameDto;


import java.util.List;
import java.util.Scanner;

/**
 * @author Vlador1337
 * Class designed for interactions with games
 */
public class GameLogic {
    private DbConnector dbConnector;
    private Scanner scanner;

    /**
     * Creating a constructor for Game Logic
     * includes connection to database
     */
    public GameLogic(Scanner scanner) {
        this.scanner = scanner;
        dbConnector = new DbConnector();
        dbConnector.setSession(GameDto.class);
    }

    public void showGamesInStore() {
        List<GameDto> gameDtoList = dbConnector.getListItems("games", GameDto.class);
        gameDtoList.forEach(x -> System.out.println(x));
    }
}
