package unitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BaseTest {
  //  private DbConnector dbConnector;

//   @BeforeEach
//    public void connectDb() {
//        dbConnector = new DbConnector();
//        dbConnector.setSession(GameDto.class);
//    }
//
//    private GameDto addGame() {
//        String gameName = "Pupa Lupa" + new Random().nextInt(500);
//        GameDto gameDto = new GameDto(gameName, "KazahstanGames", 590.99, "Race");
//        dbConnector.addItem(gameDto);
//
//        List<GameDto> gamesDtoList = dbConnector.getListItems("games", GameDto.class);
//        return gamesDtoList.get(gamesDtoList.size() - 1);
//    }

    public boolean isTrue(){
        return true;
    }

    @Test
    public void getTrue(){
        Assertions.assertTrue(isTrue());
    }

   /* @Test
    public void getItemTest() {
        GameDto newGame = addGame();
        GameDto gameFromDb = dbConnector.getItem(GameDto.class, newGame.getGameID());
        Assertions.assertEquals(newGame.getGameName(), gameFromDb.getGameName());

        dbConnector.deleteItem(gameFromDb);
    }

    @Test
    public void addItemTest() {
        Integer addedItemId = addGame().getGameID();
        GameDto foundGame = dbConnector.getItem(GameDto.class, addedItemId);
        Assertions.assertNotNull(foundGame);

        dbConnector.deleteItem(foundGame);
    }

    @Test
    public void deleteItemTest() {
        GameDto addedItemId = addGame();
        dbConnector.deleteItem(addedItemId);
        GameDto deletedGame = dbConnector.getItem(GameDto.class, addedItemId.getGameID());
        Assertions.assertNull(deletedGame);
    }*/
}
