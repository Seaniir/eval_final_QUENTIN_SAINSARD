package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int id;
    private String email = "";
    private String nickname = "";

    public Player() {};

    public Player(String email, String nickname)
    {
        this.email = email;
        this.nickname = nickname;
    }

    public Player(int id, String email, String nickname)
    {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }
}
