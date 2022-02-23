package dao;

import model.Contest;
import model.Contest;
import model.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContestDAO implements  IDAO<Contest> {
    Connection connect = Connect.getConnection();
    ResultSet rs = null;

    @Override
    public boolean create(Contest contest) {
        boolean msg = false;
        try {
            PreparedStatement req = connect.prepareStatement("INSERT INTO contest (game_id, start_date)"
                    + "VALUES (?,?)");
            req.setInt(1, contest.getGame_id());
            req.setDate(2, contest.getStart_date());

            req.executeUpdate();

            System.out.println(contest.getGame_id() + " à bien été ajouté en BDD");
            msg = true;

        } catch (Exception e) {
            System.out.println("Insertion KO");
            System.out.println(e);
        }
        return msg;
    }

    @Override
    public void update(Contest contest) {
        boolean msg = false;
        try {
            PreparedStatement req = connect.prepareStatement("UPDATE contest SET game_id=?, start_date=?, winner_id=? WHERE id=?");
            req.setInt(1, contest.getGame_id());
            req.setDate(2, contest.getStart_date());
            req.setInt(3, contest.getWinner_id());
            req.setInt(4, contest.getId());

            req.executeUpdate();

            System.out.println(contest.getGame_id() + " à bien été modifié en BDD");
            msg = true;

        } catch (Exception e) {
            System.out.println("UPDATE KO");
        }
    }

    @Override
    public List<Contest> read() {
        List<Contest> liste = new ArrayList<>();
        Contest contest = new Contest();
        try {
            PreparedStatement req = connect.prepareStatement("SELECT * FROM contest ORDER BY start_date DESC");

            rs = req.executeQuery();

            while (rs.next())
            {
                contest = new Contest(rs.getInt("id"), rs.getInt("game_id"), rs.getDate("start_date"), rs.getInt("winner_id"));
                liste.add(contest);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return liste;
    }

    @Override
    public List<Contest> readById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement req = connect.prepareStatement("DELETE FROM contest WHERE id=?");
            req.setInt(1, id);
            //System.out.println(req);
            req.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Contest findById(int id) {
        Contest contest = new Contest();
        try {
            PreparedStatement req = connect.prepareStatement("SELECT * FROM contest WHERE id = ?");
            req.setInt(1, id);

            rs = req.executeQuery();

            while (rs.next()) {
                contest = new Contest(rs.getInt("id"), rs.getInt("game_id"), rs.getDate("start_date"), rs.getInt("winner_id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contest;
    }

    public ArrayList<Player> findContestors(int id) {
        ArrayList<Player> contestors = new ArrayList<>();
        PlayerDAO playerDAO = new PlayerDAO();
        try {
            PreparedStatement req = connect.prepareStatement("SELECT id, player_id FROM player_contest WHERE contest_id = ?");
            req.setInt(1, id);

            rs = req.executeQuery();

            while (rs.next()) {
                Player player = playerDAO.findById(rs.getInt("player_id"));
                Player player1 = new Player(rs.getInt("id"), player);
                contestors.add(player1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contestors;
    }

    public void addContestor(int player_id, int contest_id) {
        try {
            PreparedStatement req = connect.prepareStatement("INSERT INTO player_contest (player_id, contest_id)"
                    + "VALUES (?,?)");
            req.setInt(1, player_id);
            req.setInt(2, contest_id);
            //System.out.println(req);
            req.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void updateWinner(int winner_id, int contest_id) {
        try {
            PreparedStatement req = connect.prepareStatement("UPDATE contest SET winner_id=? WHERE id=?");
            req.setInt(1, winner_id);
            req.setInt(2, contest_id);
            //System.out.println(req);
            req.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void deleteContestor(int id) {
        try {
            PreparedStatement req = connect.prepareStatement("DELETE FROM player_contest WHERE id=?");
            req.setInt(1, id);
            //System.out.println(req);
            req.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
