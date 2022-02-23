package dao;

import model.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDAO implements  IDAO<Game> {
    Connection connect = Connect.getConnection();
    ResultSet rs = null;

    @Override
    public boolean create(Game game) {
        boolean msg = false;
        try {
            PreparedStatement req = connect.prepareStatement("INSERT INTO game (title, min_players, max_players)"
                    + "VALUES (?,?,?)");
            req.setString(1, game.getTitle());
            req.setInt(2, game.getMin_players());
            req.setInt(3, game.getMax_players());

            req.executeUpdate();

            System.out.println(game.getTitle() + " à bien été ajouté en BDD");
            msg = true;

        } catch (Exception e) {
            System.out.println("Insertion KO");
        }
        return msg;
    }

    @Override
    public void update(Game game) {
        boolean msg = false;
        try {
            PreparedStatement req = connect.prepareStatement("UPDATE game SET title=?, min_players=?, max_players=? WHERE id=?");
            req.setString(1, game.getTitle());
            req.setInt(2, game.getMin_players());
            req.setInt(3, game.getMax_players());
            req.setInt(4, game.getId());

            req.executeUpdate();

            System.out.println(game.getTitle() + " à bien été modifié en BDD");
            msg = true;

        } catch (Exception e) {
            System.out.println("UPDATE KO");
        }
    }

    @Override
    public List<Game> read() {
        List<Game> liste = new ArrayList<>();
        Game game = new Game();
        try {
            PreparedStatement req = connect.prepareStatement("SELECT * FROM game");

            rs = req.executeQuery();

            while (rs.next())
            {
                game = new Game(rs.getInt("id"), rs.getString("title"), rs.getInt("min_players"), rs.getInt("max_players"));
                liste.add(game);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return liste;
    }

    @Override
    public List<Game> readById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement req = connect.prepareStatement("DELETE FROM game WHERE id=?");
            req.setInt(1, id);
            //System.out.println(req);
            req.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Game findById(int id) {
        Game game = new Game();
        try {
            PreparedStatement req = connect.prepareStatement("SELECT * FROM game WHERE id = ?");
            req.setInt(1, id);

            rs = req.executeQuery();

            while (rs.next()) {
                game = new Game(rs.getInt("id"), rs.getString("title"), rs.getInt("min_players"), rs.getInt("max_players"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return game;
    }
}
