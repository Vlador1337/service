package core;

import dto.UserDto;

public class Auth {
    private UserDto user;
    private final DbConnector dbConnector;

    public UserDto getUser() {
        return user;
    }

    public Auth() {
        dbConnector = new DbConnector();
        dbConnector.setSession(UserDto.class);
    }

    public boolean auth(String email, String pass) {
        user = dbConnector.findUser(email, pass);
        return user != null;
    }

    public void reg(UserDto dto) {
        user = dto;
        dbConnector.addItem(user);
        System.out.println(user);
    }
}
