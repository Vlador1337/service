package unitTest;

import core.DbConnector;
import dto.GameDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

public class BaseTest {
    private DbConnector dbConnector;

    @BeforeEach
    public void connectDb(){
        dbConnector = new DbConnector();
        dbConnector.setSession(GameDto.class);
    }

    private GameDto addGame(){
        String gameName = "Pupa Lupa" + new Random().nextInt(500);
        GameDto gameDto = new GameDto(1, gameName, "KazahstanGames", 590.99,"Race");
        dbConnector.addItem(gameDto);

        List<GameDto> gamesDtoList = (List<GameDto>) dbConnector.getListItems("games", GameDto.class);
        GameDto lastGame = gamesDtoList.get(gamesDtoList.size()-1);
        return lastGame;
    }

    @Test
    public void getItemTest(){
        GameDto newGame = addGame();
        GameDto gameFromDb = (GameDto) dbConnector.getItem(GameDto.class, newGame.getGameID());
        Assertions.assertEquals(newGame.getGameName(), gameFromDb.getGameName());

        dbConnector.deleteItem(gameFromDb);
    }

    @Test
    public void addItemTest(){
        Integer addedItemId = addGame().getGameID();
        GameDto foundGame = (GameDto) dbConnector.getItem(GameDto.class,addedItemId);
        Assertions.assertNotNull(foundGame);

        dbConnector.deleteItem(foundGame);
    }

    @Test
    public void deleteItemTest(){
        GameDto addedItemId = addGame();
        dbConnector.deleteItem(addedItemId);
        GameDto deletedGame = (GameDto) dbConnector.getItem(GameDto.class,addedItemId.getGameID());
        Assertions.assertNull(deletedGame);
    }
}
