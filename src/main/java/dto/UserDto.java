package dto;


import javax.persistence.*;

@Entity(name = "users")
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "userID")})
public class UserDto {
    private Integer userID;
    private Integer isDev;
    private String userEmail;
    private String userName;
    private String userPas;
    private Double userWallet;


    public UserDto(Integer isDev, String userName, String userEmail, String userPas, Double userWallet) {
        this.isDev = isDev;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPas = userPas;
        this.userWallet = userWallet;
    }

    public UserDto() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    public Integer getUserID() {
        return userID;
    }

    @Column(name = "isDev")
    public Integer getIsDev() {
        return isDev;
    }

    @Column(name = "userEmail")
    public String getUserEmail() {
        return userEmail;
    }

    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    @Column(name = "userPas")
    public String getUserPas() {
        return userPas;
    }

    @Column(name = "userWallet")
    public Double getUserWallet() {
        return userWallet;
    }

    public void setIsDev(Integer isDev) {
        this.isDev = isDev;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPas(String userPas) {
        this.userPas = userPas;
    }

    public void setUserWallet(Double userWallet) {
        this.userWallet = userWallet;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userID=" + userID +
                ", isDev=" + isDev +
                ", userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", userPas='" + userPas + '\'' +
                ", userWallet=" + userWallet +
                '}';
    }
}
