package dto;


import javax.persistence.*;

@Entity(name = "games")
@Table(name = "games", uniqueConstraints = {@UniqueConstraint(columnNames = "gameID")})
public class GameDto {
    private Integer gameID;
    private String gameName;
    private String gameDeveloper;
    private Double gameCost;
    private String gameGenre;

    public GameDto(Integer gameID, String gameName, String gameDeveloper, Double gameCost, String gameGenre) {
        this.gameID = gameID;
        this.gameName = gameName;
        this.gameDeveloper = gameDeveloper;
        this.gameCost = gameCost;
        this.gameGenre = gameGenre;
    }

    public GameDto(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "gameID")
    public Integer getGameID() {
        return gameID;
    }

    @Column(name = "gameName")
    public String getGameName() {
        return gameName;
    }

    @Column(name = "gameDeveloper")
    public String getGameDeveloper() {
        return gameDeveloper;
    }

    @Column(name = "gameCost")
    public Double getGameCost() {
        return gameCost;
    }

    @Column(name = "gameGenre")
    public String getGameGenre() {
        return gameGenre;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setGameDeveloper(String gameDeveloper) {
        this.gameDeveloper = gameDeveloper;
    }

    public void setGameCost(Double gameCost) {
        this.gameCost = gameCost;
    }

    public void setGameGenre(String gameGenre) {
        this.gameGenre = gameGenre;
    }

    @Override
    public String toString() {
        return "GameDto{" +
                "gameID=" + gameID +
                ", gameName='" + gameName + '\'' +
                ", gameDeveloper='" + gameDeveloper + '\'' +
                ", gameCost=" + gameCost +
                ", gameGenre='" + gameGenre + '\'' +
                '}';
    }
}
