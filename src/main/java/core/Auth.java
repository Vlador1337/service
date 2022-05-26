package core;

import dto.UserDto;

/**
 * @author Vlador1337
 * Class designed for authorization and registration
 */
public class Auth {
    /**
     * Creating a User Entity
     */
    public UserDto user;
    /**
     * Creating a database connection Entity
     */
    private final DbConnector dbConnector;

    public UserDto getUser() {
        return user;
    }

    /**
     * Creating a constructor for authorization
     */
    public Auth() {
        dbConnector = new DbConnector();
        dbConnector.setSession(UserDto.class);
    }

    /**
     * Method for user authorization
     *
     * @param email user email
     * @param pass  user pass
     * @return user exist
     */
    public boolean auth(String email, String pass) {
        user = dbConnector.findUser(email, pass);
        return user != null;
    }

    /**
     * Method for user registration
     *
     * @param dto user data from the database
     */
    public void reg(UserDto dto) {
        user = dto;
        dbConnector.addItem(user);
        System.out.println(user);
    }
}
