package entities;

public class Player {

    private String nickname;
    private String role;
    private Integer level;

    public Player() {
    }

    public Player(String nickname, String role, Integer level) {
        this.nickname = nickname;
        this.role = role;
        this.level = level;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String toString() {
        return String.format("- %s (Role: %s | Level: %d)%n", nickname, role, level);
    }
}
