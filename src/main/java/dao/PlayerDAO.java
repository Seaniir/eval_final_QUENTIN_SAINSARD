package dao;

import model.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO implements  IDAO<Player> {
    Connection connect = Connect.getConnection();
    ResultSet rs = null;

    @Override
    public boolean create(Player player) {
        boolean msg = false;
        try {
            PreparedStatement req = connect.prepareStatement("INSERT INTO player (email, nickname)"
                    + "VALUES (?,?)");
            req.setString(1, player.getEmail());
            req.setString(2, player.getNickname());

            req.executeUpdate();

            System.out.println(player.getNickname() + " à bien été ajouté en BDD");
            msg = true;

        } catch (Exception e) {
            System.out.println("Insertion KO");
        }
        return msg;
    }

    @Override
    public void update(Player player) {
        boolean msg = false;
        try {
            PreparedStatement req = connect.prepareStatement("UPDATE player SET email=?, nickname=? WHERE id=?");
            req.setString(1, player.getEmail());
            req.setString(2, player.getNickname());
            req.setInt(3, player.getId());

            req.executeUpdate();

            System.out.println(player.getNickname() + " à bien été modifié en BDD");
            msg = true;

        } catch (Exception e) {
            System.out.println("UPDATE KO");
        }
    }

    @Override
    public List<Player> read() {
        List<Player> liste = new ArrayList<>();
        Player player = new Player();
        try {
            PreparedStatement req = connect.prepareStatement("SELECT * FROM player");

            rs = req.executeQuery();

            while (rs.next())
            {
                player = new Player(rs.getInt("id"), rs.getString("email"), rs.getString("nickname"));
                liste.add(player);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return liste;
    }

    @Override
    public List<Player> readById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement req = connect.prepareStatement("DELETE FROM player WHERE id=?");
            req.setInt(1, id);
            //System.out.println(req);
            req.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Player findById(int id) {
        Player player = new Player();
        try {
            PreparedStatement req = connect.prepareStatement("SELECT * FROM player WHERE id = ?");
            req.setInt(1, id);

            rs = req.executeQuery();

            while (rs.next()) {
                player = new Player(rs.getInt("id"), rs.getString("email"), rs.getString("nickname"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return player;
    }
}
