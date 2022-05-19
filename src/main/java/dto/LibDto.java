package dto;


import javax.persistence.*;

@Entity(name = "userslib")
@Table(name = "userslib", uniqueConstraints = {@UniqueConstraint(columnNames = "userLibID")})
public class LibDto {
    private Integer userLibID;
    private Integer gameID;

    public LibDto(Integer userLibID, Integer gameID) {
        this.userLibID = userLibID;
        this.gameID = gameID;
    }

    public LibDto() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userLibID")
    public Integer getUserLibID() {
        return userLibID;
    }

    @Column(name = "gameID")
    public Integer getGameID() {
        return gameID;
    }

    public void setUserLibID(Integer userLibID) {
        this.userLibID = userLibID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }

    @Override
    public String toString() {
        return "LibDto{" +
                "userLibID=" + userLibID +
                ", gameID=" + gameID +
                '}';
    }
}
