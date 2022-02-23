package model;

import dao.ContestDAO;
import dao.GameDAO;
import dao.PlayerDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Contest {
    private int id;
    private int game_id;
    private Date start_date;
    private int winner_id;
    private Game game;
    private Player winner;
    private ArrayList<Player> contestors;

    public Contest() {};

    public Contest(int game_id, Date start_date)
    {
        this.game_id = game_id;
        this.start_date = start_date;
    }

    public Contest(int game_id, Date start_date, int winner_id)
    {
        this.game_id = game_id;
        this.start_date = start_date;
        this.winner_id = winner_id;
    }

    public Contest(int id, int game_id, Date start_date, int winner_id)
    {
        this.id = id;
        this.game_id = game_id;
        this.start_date = start_date;
        this.winner_id = winner_id;
        GameDAO gameDAO = new GameDAO();
        this.game = gameDAO.findById(game_id);
        if(winner_id != 0)
        {
            PlayerDAO playerDAO = new PlayerDAO();
            this.winner = playerDAO.findById(winner_id);
        }
        ContestDAO contestDAO = new ContestDAO();
        this.contestors = contestDAO.findContestors(this.id);
    }


    public int getId() {
        return id;
    }

    public int getGame_id() {
        return game_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public int getWinner_id() {
        return winner_id;
    }

    public Game getGame() {
        return game;
    }

    public Player getWinner() {
        return winner;
    }

    public ArrayList<Player> getContestors() {
        return contestors;
    }
}
