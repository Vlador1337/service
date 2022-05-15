package com.company;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConnection {

    private Statement statement;
    private Connection connection;

    public DBConnection() {
        try {
            connection = getConnection();
            statement = connection.createStatement();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() throws SQLException, IOException {

        Properties props = new Properties();
        props.load(DBConnection.class.getClassLoader().getResourceAsStream("database.properties"));
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");
        return DriverManager.getConnection(url, username, password);
    }


    public void insertData(String gameName, String gameDeveloper, String gameCost, String gameGenre) {
        String query = String.format("insert into games(gameName,gameDeveloper,gameCost,gameGenre) values('%s','%s','%s','%s');",
                gameName, gameDeveloper, gameCost, gameGenre);
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
